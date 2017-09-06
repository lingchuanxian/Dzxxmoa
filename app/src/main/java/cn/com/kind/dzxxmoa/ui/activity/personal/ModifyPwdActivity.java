package cn.com.kind.dzxxmoa.ui.activity.personal;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

import static cn.com.kind.dzxxmoa.utils.ToastUtil.show;

/**
 * 修改密码
 * @author ling_cx
 * @date 2017/8/4.
 */

public class ModifyPwdActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView {
	@BindView(R.id.edtOldPwd)
	EditText mEdtOldPwd;
	@BindView(R.id.edtNewPwd)
	EditText mEdtNewPwd;
	@BindView(R.id.edtConfirmPwd)
	EditText mEdtConfirmPwd;

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_personal_modifypwd;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.pe_modifyPwd));
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initInject() {
		DaggerOperateComponent.builder()
				.appModule(new AppModule(this))
				.operateModule(new OperateModule(this))
				.build()
				.inject(this);
	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[0];
	}

	@Override
	protected String getOperateType() {
		return "KindFrame.WSys.User.ChangePwd";
	}

	@OnClick(R.id.btnSubmit)
	public void click(View view){
		switch (view.getId()){
			case R.id.btnSubmit:
				if(checkSubmitForm()){
					progress.show();
					Map<String, String> params = new HashMap<>();
					params.put("OldPwd",mEdtOldPwd.getText().toString());
					params.put("NewPwd",mEdtNewPwd.getText().toString());
					params.put("RNewPwd",mEdtConfirmPwd.getText().toString());
					mSubmitParams.setParaInfo(gson.toJson(params));
					mPresenter.operate(mSubmitParams,false);
				}
				break;
			default:
				break;
		}
	}

	/**
	 * 参数验证
	 * @return
	 */
	public boolean checkSubmitForm(){
		if(mEdtOldPwd.getText().toString().equals("")){
			show(mContext,getResources().getString(R.string.pe_inputOldPwd));
			return false;
		}else if(mEdtNewPwd.getText().toString().equals("")){
			show(mContext,getResources().getString(R.string.pe_inputNewPwd));
			return false;
		}else if(mEdtConfirmPwd.getText().toString().equals("")){
			show(mContext,getResources().getString(R.string.pe_reInputPwd));
			return false;
		}else if(!mEdtConfirmPwd.getText().toString().equals(mEdtNewPwd.getText().toString())){
			show(mContext,getResources().getString(R.string.pe_noSameNewAndRePwd));
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void operateSuccess(String data) {
		progress.dismiss();
		ToastUtil.show(mContext,getResources().getString(R.string.pe_modifyPwdSuccess));
		new Handler().postDelayed(new Runnable(){
			public void run() {
				finish();
			}
		}, 1000);
	}
}
