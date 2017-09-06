package cn.com.kind.dzxxmoa.ui.activity.personal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.VersionBean;
import cn.com.kind.dzxxmoa.di.component.DaggerGetNewAppDetailComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.GetNewAppDetailModule;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.global.DownloadManage;
import cn.com.kind.dzxxmoa.mvp.presenter.GetNewAppDetailPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;
import cn.com.kind.dzxxmoa.utils.AppUtil;
import cn.com.kind.dzxxmoa.utils.StringUtil;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

/**
 * 软件版本
 *
 * @author ling_cx
 * @date 2017/8/10
 */

public class VersionActivity extends BaseActivity<GetNewAppDetailPresenter> implements ViewContract.GetNewAppDetailView{
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.tvCurVersion)
	TextView mTvCurVersion;
	@BindView(R.id.tvCpy)
	TextView mTvCpy;
	private MaterialDialog mDialog = null;
	String fileName = "dzxxmoa.apk";

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_personal_version;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.pe_softversion));
		int currentYear = StringUtil.getYear();
		if(currentYear == 2017){
			mTvCpy.setText(getResources().getString(R.string.lg_copyright2) +" KindTech");
		}else{
			mTvCpy.setText(getResources().getString(R.string.lg_copyright2) + "-" + StringUtil.getYear() + " KindTech");
		}
	}

	@Override
	protected void initData() {
		mTvCurVersion.setText(getResources().getString(R.string.pe_curVersion)+ AppUtil.getAppVersionName(mContext));
	}

	@Override
	protected void initInject() {
		DaggerGetNewAppDetailComponent.builder()
				.appModule(new AppModule(this))
				.getNewAppDetailModule(new GetNewAppDetailModule(this))
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

	@OnClick({R.id.llayoutCheckVersion,R.id.llayoutVersionLog})
	void onClick(View view){
		switch (view.getId()){
			case R.id.llayoutCheckVersion:
				progress.show();
				mPresenter.getNewAppDetail("FeigOA","android","LD");
				break;
			case R.id.llayoutVersionLog:
				ActivityUtils.toNextActivity(mContext, VersionLogActivity.class);
				break;
			default:
				break;
		}
	}

	@Override
	public void getNewAppDetailSuccess(final VersionBean versionBean) {
		Log.d(TAG, "getNewAppDetailSuccess: "+AppUtil.getAppVersionName(mContext)+","+versionBean.getVersion());
		if(!StringUtil.isNullOrEmpty(versionBean.getVersion())&&!versionBean.getVersion().equals("V"+AppUtil.getAppVersionName(mContext))){
			ToastUtil.show(mContext, getResources().getString(R.string.pe_findNewVersion));
			new MaterialDialog.Builder(mContext)
					.title(R.string.message)
					.content(getResources().getString(R.string.pe_updateRightNow))
					.cancelable(false)
					.positiveText(getResources().getString(R.string.confirm))
					.onPositive(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							mDialog = new MaterialDialog.Builder(mContext)
									.title(R.string.message)
									.content(getResources().getString(R.string.lg_waiting))
									.cancelable(false)
									.progress(false, 100, true)
									.progressNumberFormat("%1d/%2d")
									.show();
							DownloadManage.downloadApkWithDialog(Contants.IP+versionBean.getUpload().get(0).getEncltext(),Contants.downloadFilePath+fileName,mContext,mDialog,null);
						}
					})
					.negativeText(getResources().getString(R.string.cancle))
					.onNegative(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							dialog.dismiss();
						}
					})
					.show();
		}else{
			new MaterialDialog.Builder(mContext)
					.title(R.string.message)
					.content(getResources().getString(R.string.pe_alreadyNewest))
					.cancelable(false)
					.positiveText(getResources().getString(R.string.confirm))
					.onPositive(new MaterialDialog.SingleButtonCallback() {
						@Override
						public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
							dialog.dismiss();
						}
					})
					.show();
		}
		progress.dismiss();
	}

}
