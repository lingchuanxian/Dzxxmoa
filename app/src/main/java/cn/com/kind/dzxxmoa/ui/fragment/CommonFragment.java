package cn.com.kind.dzxxmoa.ui.fragment;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseFragment;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/9/4
 */

public class CommonFragment extends BaseFragment {
	@Override
	protected int attachLayoutRes() {
		return R.layout.common_list_page;
	}

	@Override
	protected void initViews() {
		getToolBar().hide();
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

	public static CommonFragment getInstance() {
		CommonFragment mCommonFragment = new CommonFragment();
		return mCommonFragment;
	}
}
