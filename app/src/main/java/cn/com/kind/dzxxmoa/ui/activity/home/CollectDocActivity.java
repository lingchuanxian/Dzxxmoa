package cn.com.kind.dzxxmoa.ui.activity.home;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.global.ViewPagerSetting;
import cn.com.kind.dzxxmoa.ui.adapter.PagerAdapter;
import cn.com.kind.dzxxmoa.ui.fragment.CollectDocFragment;

/**
 * 收文管理主activity
 *
 * @author ling_cx
 * @date 2017/9/4
 */

public class CollectDocActivity extends BaseActivity {

	@BindView(R.id.stl_tab)
	SlidingTabLayout mStlTab;
	@BindView(R.id.vpContent)
	ViewPager mVpContent;
	private ArrayList<Fragment> mFragments = new ArrayList<>();
	private final String[] mTitles = {
			"待办", "已办", "存档"
	};

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_collectdoc;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.ho_collectDoc_manage));

		mFragments.add(CollectDocFragment.getInstance(0));
		mFragments.add(CollectDocFragment.getInstance(1));
		mFragments.add(CollectDocFragment.getInstance(2));
		mVpContent.setAdapter(new PagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
		mVpContent.setOffscreenPageLimit(2);
		mStlTab.setViewPager(mVpContent);
		ViewPagerSetting.commonSettingWithSlidingTabLayout(mVpContent,mStlTab);
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
