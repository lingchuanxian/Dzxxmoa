package cn.com.kind.dzxxmoa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.di.component.DaggerLoginComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.LoginModule;
import cn.com.kind.dzxxmoa.mvp.presenter.LoginPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.utils.AESUtil;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;
import cn.com.kind.dzxxmoa.utils.SPUtils;
import cn.com.kind.dzxxmoa.utils.StringUtil;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

import static cn.com.kind.dzxxmoa.R.id.edtAccount;

/**
 * 登录
 * @author ling_cx
 * @date 2017/8/4.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,ViewContract.LoginView {
	@BindView(R.id.tvCpy)
	TextView mTvCpy;
	@BindView(edtAccount)
	EditText mEdtAccount;
	@BindView(R.id.edtPwd)
	EditText mEdtPwd;
	@BindView(R.id.btnLogin)
	Button mBtnLogin;
	@BindView(R.id.cbRemPwd)
	CheckBox mCbRemPwd;
	@BindView(R.id.cbAutoLogin)
	CheckBox mCbAutoLogin;

	private static final String PASSWORD_STRING = "fjkind.com.cn";
	private int logout = 0;//用于处理当自动登录为选中情况下是否自动登录，当logout=1时，为从内部进行注销操作或登录超时，不自动登录
	private long firstTime = 0;//记录用户首次点击返回键的时间
	private MaterialDialog progress;

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_login;
	}

	@Override
	protected void initViews() {
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//把整个Layout顶上去露出获得焦点的EditText,不压缩多余空间
		getToolBar().hide();
		int currentYear = StringUtil.getYear();
		if(currentYear == 2017){
			mTvCpy.setText(getResources().getString(R.string.lg_copyright2) +" KindTech");
		}else{
			mTvCpy.setText(getResources().getString(R.string.lg_copyright2) + "-" + StringUtil.getYear() + " KindTech");
		}

		progress = new MaterialDialog.Builder(mContext)
				.content(getResources().getString(R.string.lg_logining))
				.progress(true, 0)
				.cancelable(false)
				.build();
	}

	@Override
	protected void initData() {
		String rem_account = SPUtils.getValue(mContext,"rem_account", "");
		mEdtAccount.setText(rem_account.toCharArray(), 0, rem_account.length());
		String pwdString = AESUtil.decrypt(PASSWORD_STRING,SPUtils.getValue(mContext,"rem_pwd", ""));
		if(pwdString!=""){
			mEdtPwd.setText(pwdString.toCharArray(), 0, pwdString.length());
			mCbRemPwd.setChecked(true);
		}
		int auto_login = SPUtils.getValue(mContext,"auto_login", 0);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if(bundle != null){
			logout = bundle.getInt("logout");
		}
		if(auto_login == 1){
			mCbAutoLogin.setChecked(true);
			if(logout == 0){
				login();
			}
		}
	}

	@Override
	protected void initInject() {
		DaggerLoginComponent.builder()
				.appModule(new AppModule(this))
				.loginModule(new LoginModule(this))
				.build()
				.inject(this);
	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[0];
	}

	@Override
	protected String getOperateType() {
		return null;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.tvRemPwd://记住密码
				if(mCbRemPwd.isChecked()){
					mCbRemPwd.setChecked(false);
				}else if(!mCbRemPwd.isChecked()){
					mCbRemPwd.setChecked(true);
				}
				break;
			case R.id.tvAutoLogin://自动登录
				if(mCbAutoLogin.isChecked()){
					mCbAutoLogin.setChecked(false);
				}else if(!mCbAutoLogin.isChecked()){
					mCbAutoLogin.setChecked(true);
				}
				break;
			case R.id.btnLogin://登录
				if(mEdtAccount.getText().toString().equals("")){
					ToastUtil.show(mContext, getResources().getString(R.string.lg_plInputAccount));
					return;
				}else if(mEdtPwd.getText().toString().equals("")){
					ToastUtil.show(mContext, getResources().getString(R.string.lg_plInputPwd));
					return;
				}else {
					SPUtils.putValue(mContext,"rem_account", mEdtAccount.getText().toString());
					if(mCbRemPwd.isChecked()){
						SPUtils.putValue(mContext,"rem_pwd", AESUtil.encrypt(PASSWORD_STRING, mEdtPwd.getText().toString()));
					}else{
						SPUtils.putValue(mContext,"rem_pwd", "");
					}
					if(mCbAutoLogin.isChecked()){
						SPUtils.putValue(mContext,"auto_login", 1);
					}else{
						SPUtils.putValue(mContext,"auto_login", 0);
					}
					login();
				}
				break;
		}
	}

	private void login() {
		progress.show();
		//登录操作
		mPresenter.userLogin(mEdtAccount.getText().toString(),mEdtPwd.getText().toString(),false);
	}

	/**
	 * 登录结果
	 */
	@Override
	public void loginSuccess(String ticket, User user) {
		//将用户信息存入sharepreference，同时存入到application,方便读取
		SPUtils.setObject(mContext,"user", user);
		SPUtils.putValue(mContext, "ticket", ticket);
		app.setUser(user);
		app.setTicket(ticket);
		ActivityUtils.toNextActivity(mContext,HomeActivity.class);
		finish();
	}

	@Override
	public void loginFail(int code,final String message) {
		progress.dismiss();
		ToastUtil.show(mContext,message);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
			long secondTime = System.currentTimeMillis();
			if (secondTime - firstTime > 2000) {
				ToastUtil.showshort(mContext, getResources().getString(R.string.lg_moreExit));
				firstTime = secondTime;
				return true;
			} else {
				app.finishAllActivity();
				finish();
			}
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void finish() {
		super.finish();
		progress.dismiss();
	}
}
