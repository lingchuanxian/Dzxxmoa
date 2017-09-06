package cn.com.kind.dzxxmoa.ui.activity.personal;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;

/**
 * 关于我们
 * @author ling_cx
 * @date 2017/8/4.
 */

public class AboutActivity extends BaseActivity {
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_personal_about;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.pe_aboutus));
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
}
