package cn.com.kind.dzxxmoa.ui.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseFragment;
import cn.com.kind.dzxxmoa.bean.MenuBean;
import cn.com.kind.dzxxmoa.ui.activity.home.AnnounceActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.CollectDocActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.InfoshowActivity;
import cn.com.kind.dzxxmoa.ui.adapter.HomeMenuAdapter;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;

/**
 * 首页Fragment
 * @author ling_cx
 * @date 2017/8/4.
 */

public class IndexFragment extends BaseFragment {
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.rclvMenu)
	RecyclerView mRecyclerView;
	private HomeMenuAdapter mHomeMenuAdapter;

	@Override
	protected int attachLayoutRes() {
		return R.layout.fragment_index;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.app_name))
				.setDisplayHomeAsUpEnabled(false);
		mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
	}

	@Override
	protected void initData() {
		List<MenuBean> list = new ArrayList<>();
		list.add(new MenuBean("收文管理",R.mipmap.ic_collectdoc));
		list.add(new MenuBean("发文管理",R.mipmap.ic_senddoc));
		list.add(new MenuBean("督查督办",R.mipmap.ic_supervision));
		list.add(new MenuBean("合同管理",R.mipmap.ic_contract));
		list.add(new MenuBean("文件管理",R.mipmap.ic_file));
		list.add(new MenuBean("制度管理",R.mipmap.ic_system));
		list.add(new MenuBean("用车管理",R.mipmap.ic_car));
		list.add(new MenuBean("会议管理",R.mipmap.ic_meeting));
		list.add(new MenuBean("请假管理",R.mipmap.ic_leave));
		mHomeMenuAdapter = new HomeMenuAdapter(list);
		mRecyclerView.setAdapter(mHomeMenuAdapter);
		/* item点击事件 */
		mHomeMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
				switch (position){
					case 0:
						ActivityUtils.toNextActivity(mContext, CollectDocActivity.class);
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					default:
						break;
				}
			}
		});
	}

	@Override
	protected void initInject() {

	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
	}

	@Override
	protected String getOperateType() {
		return null;
	}

	public static IndexFragment getInstance() {
		IndexFragment mPersonalFragment = new IndexFragment();
		return mPersonalFragment;
	}

	@OnClick({R.id.llayout_announce,R.id.llayout_dynamic,R.id.llayout_mess,R.id.llayout_communication})
	void onClick(View view){
		Bundle bun=new Bundle();
		int temp=0;
		switch (view.getId()){
			case R.id.llayout_announce://通知公告
				ActivityUtils.toNextActivity(mContext,AnnounceActivity.class);
				temp=1;
				break;
			case R.id.llayout_dynamic://集团动态
				bun.putString("key","Type_0004|$|");
				break;
			case R.id.llayout_mess://司务公开
				bun.putString("key","Type_0003|$|");
				break;
			case R.id.llayout_communication://交流园地
				bun.putString("key","Type_0001|$|");
				break;
			default:
				break;
		}
		if(temp==0){
			ActivityUtils.toNextActivity(mContext,InfoshowActivity.class,bun);
		}
	}

}
