package cn.com.kind.dzxxmoa.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseFragment;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.ui.activity.personal.AboutActivity;
import cn.com.kind.dzxxmoa.ui.activity.personal.ModifyPwdActivity;
import cn.com.kind.dzxxmoa.ui.activity.personal.VersionActivity;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;

/**
 * 个人中心Fragment
 * @author ling_cx
 * @date 2017/8/4.
 */

public class PersonalFragment extends BaseFragment{
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.tvName)
	TextView mTvName;
	@BindView(R.id.tvOrg)
	TextView mTvOrg;

	@Override
	protected int attachLayoutRes() {
		return R.layout.fragment_personal;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.pe_personal))
				.setDisplayHomeAsUpEnabled(false);
		mTvName.setText(app.getUser().getUserName());
		mTvOrg.setText(app.getUser().getUserOrgName());
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initInject() {

	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[0];
	}

	@Override
	protected String getOperateType() {
		return null;
	}

	public static PersonalFragment getInstance() {
		PersonalFragment mPersonalFragment = new PersonalFragment();
		return mPersonalFragment;
	}

	@OnClick({R.id.llayoutUpdatepwd,R.id.llayoutVersion,R.id.llayoutAbout,R.id.llayoutExit,R.id.rlayoutLogout})
	void click(View view){
		switch (view.getId()){
			case R.id.llayoutUpdatepwd:
				ActivityUtils.toNextActivity(mContext, ModifyPwdActivity.class);
				break;
			case R.id.llayoutVersion:
				ActivityUtils.toNextActivity(mContext, VersionActivity.class);
				break;
			case R.id.llayoutAbout:
				ActivityUtils.toNextActivity(mContext, AboutActivity.class);
				break;
			case R.id.llayoutExit:
				new MaterialDialog.Builder(mContext)
						.title(R.string.message)
						.content(R.string.pe_exitContent)
						.positiveText(R.string.confirm)
						.onPositive(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								dialog.dismiss();
								app.finishAllActivity();
							}
						})
						.negativeText(R.string.cancle)
						.onNegative(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								dialog.dismiss();
							}
						})
						.show();
				break;
			case R.id.rlayoutLogout:
				new MaterialDialog.Builder(mContext)
						.title(R.string.message)
						.content(R.string.pe_logoutContent)
						.positiveText(R.string.confirm)
						.onPositive(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								Intent intent = new Intent(mContext, Contants.loginClass);
								Bundle bundle = new Bundle();
								bundle.putInt("logout", 1);
								intent.putExtras(bundle);
								startActivity(intent);
								getActivity().finish();
								app.finishAllActivity();
							}
						})
						.negativeText(R.string.cancle)
						.onNegative(new MaterialDialog.SingleButtonCallback() {
							@Override
							public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
								dialog.dismiss();
							}
						})
						.show();
				break;
			default:
				break;
		}
	}
}
