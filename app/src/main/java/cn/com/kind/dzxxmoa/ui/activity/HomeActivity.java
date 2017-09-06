package cn.com.kind.dzxxmoa.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.TabBean;
import cn.com.kind.dzxxmoa.bean.VersionBean;
import cn.com.kind.dzxxmoa.di.component.DaggerGetNewAppDetailComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.GetNewAppDetailModule;
import cn.com.kind.dzxxmoa.global.ViewPagerSetting;
import cn.com.kind.dzxxmoa.mvp.presenter.GetNewAppDetailPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.adapter.PagerAdapter;
import cn.com.kind.dzxxmoa.ui.fragment.IndexFragment;
import cn.com.kind.dzxxmoa.ui.fragment.PersonalFragment;

/**
 * 主页
 * @author ling_cx
 * @date 2017/8/4.
 */

public class HomeActivity extends BaseActivity<GetNewAppDetailPresenter> implements ViewContract.GetNewAppDetailView{
	@BindView(R.id.vpContent)
	ViewPager mVpContent;
	@BindView(R.id.ctlMenu)
	CommonTabLayout mCtlMenu;
	private ArrayList<Fragment> mFragments = new ArrayList<>();
	private String[] mTitles = {"首页", "消息", "我的"};
	private int[] mIconUnselectIds = {
			R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
			R.mipmap.tab_contact_unselect};
	private int[] mIconSelectIds = {
			R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
			R.mipmap.tab_contact_select};
	private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_home;
	}

	@Override
	protected void initViews() {
		getToolBar().hide();
		mFragments.add(IndexFragment.getInstance());
		mFragments.add(IndexFragment.getInstance());
		mFragments.add(PersonalFragment.getInstance());
		for (int i = 0; i < mTitles.length; i++) {
			mTabEntities.add(new TabBean(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
		}
		mVpContent.setAdapter(new PagerAdapter(getSupportFragmentManager(),mFragments,mTitles));
		mCtlMenu.setTabData(mTabEntities);
		ViewPagerSetting.commonSettingWithCommonTabLayout(mVpContent,mCtlMenu);

	}

	@Override
	protected void initData() {
		//mPresenter.getNewAppDetail("ajj_moa","android","LD");
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

	@Override
	public void getNewAppDetailSuccess(VersionBean versionBean) {

	}

	/**
	 * 按返回键后台运行程序
	 */
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
}
