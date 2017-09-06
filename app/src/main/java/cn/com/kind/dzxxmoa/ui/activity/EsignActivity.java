package cn.com.kind.dzxxmoa.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.inject.Inject;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.di.component.DaggerCheckKeyResultComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.CheckKeyResultModule;
import cn.com.kind.dzxxmoa.di.module.LoginModule;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.global.DownloadManage;
import cn.com.kind.dzxxmoa.mvp.presenter.CheckKeyResultPresenter;
import cn.com.kind.dzxxmoa.mvp.presenter.LoginPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;
import cn.com.kind.dzxxmoa.utils.AppUtil;
import cn.com.kind.dzxxmoa.utils.SPUtils;
import cn.com.kind.dzxxmoa.utils.StringUtil;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

/**
 * 调用E手签登录
 *
 * @author ling_cx
 * @date 2017/8/14
 */

public class EsignActivity extends BaseActivity<CheckKeyResultPresenter> implements ViewContract.CheckKeyResultView, ViewContract.LoginView {
	@Inject
	LoginPresenter mLoginPresenter;
	private String randnum = null;
	private MaterialDialog mDialog = null;
	private String fileName = "Esign.apk";
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_esign;
	}

	@Override
	protected void initViews() {
		getToolBar().setDisplayHomeAsUpEnabled(false);
		checkHasEsign();
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initInject() {
		DaggerCheckKeyResultComponent.builder()
				.appModule(new AppModule(this))
				.loginModule(new LoginModule(this))
				.checkKeyResultModule(new CheckKeyResultModule(this))
				.build()
				.inject(this);
	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
	}

	@Override
	protected String getOperateType() {
		return null;
	}

	public void checkHasEsign(){
		//判断是否已安装E手签
		if (AppUtil.isAppInstalled(mContext, "com.kinsec.reader")) {
			progress.show();
			startEsign();
		} else {
			progress.dismiss();
			new MaterialDialog.Builder(mContext)
					.title(R.string.message)
					.content(R.string.lg_missEsign)
					.positiveText(R.string.confirm)
					.cancelable(false)
					.onPositive(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							mDialog = new MaterialDialog.Builder(mContext)
									.title(getResources().getString(R.string.message))
									.content(getResources().getString(R.string.lg_waiting))
									.cancelable(false)
									.progress(false, 100, true)
									.progressNumberFormat("%1d/%2d")
									.show();
							dialog.dismiss();
							DownloadManage.downloadApkWithDialog(Contants.IP+"app/ESign_C.apk",Contants.downloadFilePath+fileName,mContext,mDialog,app);
						}
					})
					.negativeText(R.string.cancle)
					.onNegative(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							dialog.dismiss();
							finish();
						}
					})
					.show();
		}
	}

	/**
	 * 开启E手签
	 */
	private void startEsign() {
		Intent intent = new Intent("android.intent.action.certLogin");
		String packageName = "com.kinsec.reader";
		String className = "com.kinsec.reader.CertLoginActivity";
		intent.setClassName(packageName, className);
		Bundle bundle = new Bundle();
		randnum = System.currentTimeMillis() + Math.random() * 1000 + "";
		bundle.putString("signSrc", randnum);//pki随机数
		intent.putExtras(bundle);
		startActivityForResult(intent, 88);
		progress.dismiss();
	}

	/**
	 * 接收E手签返回的证书信息
	 *
	 * @param requestCode
	 * @param resultCode
	 * @param data
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.d(TAG, "onActivityResult: requestCode=="+requestCode+"   resultCode=="+resultCode);
		if (requestCode == 88 && resultCode == 88) {
			progress.show();
			Bundle b = data.getExtras();
			String coderesult = b.getString("code");//的值为”0000”时说明签名成功
			String info = b.getString("info");//为签名后的值
			String cert = b.getString("cert");//为设备上的证书
			Log.e(TAG, "onActivityResult: coderesult:"+coderesult + "\nnum : " + randnum + "\ninfo : " + info + "\ncert:" + cert);
			if(coderesult.equals("0000")){
				mPresenter.checkKeyResult(randnum, info, cert);
			}else{
				checkHasEsign();
			}
		}else {
			finish();
		}
	}

	/**
	 * 校验证书返回的结果
	 *
	 * @param result
	 */
	@Override
	public void CheckKeyResultSuccess(String result) {
		Document doc;
		KU ku = null;
		try {
			doc = DocumentHelper.parseText(result);
			Element root = doc.getRootElement();
			ku = gson.fromJson(root.getText(), KU.class);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		if(!StringUtil.isNullOrEmpty(ku.getKeyuser())){
			mLoginPresenter.userLogin(ku.getKeyuser(), "", true);
		}else {
			Log.d(TAG, "CheckKeyResultSuccess: 证书验证错误");
			progress.dismiss();
			new MaterialDialog.Builder(mContext)
					.title(R.string.message)
					.content(getResources().getString(R.string.lg_keyCheckFail))
					.positiveText(getResources().getString(R.string.confirm))
					.cancelable(false)
					.onPositive(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							dialog.dismiss();
							finish();
						}
					})
					.show();
		}
	}

	/**
	 * 签名校验成功返回用户名
	 */
	public class KU {
		private String keyuser;

		public String getKeyuser() {
			return keyuser;
		}

		public void setKeyuser(String keyuser) {
			this.keyuser = keyuser;
		}
	}

	/**
	 * 登录结果
	 */
	@Override
	public void loginSuccess(String ticket, User user) {
		SPUtils.setObject(mContext, "user", user);
		SPUtils.putValue(mContext, "ticket", ticket);
		app.setUser(user);
		app.setTicket(ticket);
		ActivityUtils.toNextActivity(mContext, HomeActivity.class);
		finish();
	}

	@Override
	public void loginFail(int code, final String message) {
		progress.dismiss();
		ToastUtil.show(mContext, message);
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume: resume");
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy: EsignOnDestory");
		mLoginPresenter.unSubscribe();
		super.onDestroy();
	}
}

