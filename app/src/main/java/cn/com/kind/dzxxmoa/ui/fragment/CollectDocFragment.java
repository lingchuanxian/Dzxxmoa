package cn.com.kind.dzxxmoa.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseFragment;
import cn.com.kind.dzxxmoa.bean.Business;
import cn.com.kind.dzxxmoa.bean.CollectDoc;
import cn.com.kind.dzxxmoa.bean.Flow;
import cn.com.kind.dzxxmoa.bean.HandleParams;
import cn.com.kind.dzxxmoa.bean.PageBean;
import cn.com.kind.dzxxmoa.bean.RowsBean;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.activity.home.CollectDocDetailActivity;
import cn.com.kind.dzxxmoa.ui.adapter.CollectDocAdapter;

/**
 * 收文Fragment
 *
 * @author ling_cx
 * @date 2017/9/4
 */

public class CollectDocFragment extends BaseFragment<OperatePresenter> implements ViewContract.OperateView {
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.edt_key)
	EditText mEdtKey;
	@BindView(R.id.rclv_list)
	RecyclerView mRclvList;
	@BindView(R.id.swipe_refresh)
	SwipeRefreshLayout mSwipeRefresh;

	private Map<String, Object> params = new HashMap<>();
	private List<CollectDoc> mData = new ArrayList<>();
	private CollectDocAdapter mAdapter;
	private int mCurrentPage = 1;//当前页码
	private int mTotalPage;//总页码
	private int flag = 0;//0 -- 第一次加载或者刷新  1 -- 加载更多

	private Flow flow = new Flow();//流程办理所需属性

	@Override
	protected int attachLayoutRes() {
		return R.layout.common_list_page;
	}

	@Override
	protected void initViews() {
		getToolBar().hide();
		mRclvList.setLayoutManager(new LinearLayoutManager(mContext));

		mAdapter = new CollectDocAdapter(mData);
		mRclvList.setAdapter(mAdapter);
		mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
				Intent intent = new Intent(mContext,CollectDocDetailActivity.class);
				CollectDoc collectDoc = (CollectDoc)adapter.getItem(position);
				int state = getBundleInt();
				Bundle bundle = new Bundle();
				bundle.putString("Id",collectDoc.getCreate_id());
				bundle.putString("busikey",collectDoc.getBusikey());
				bundle.putInt("flag",state);
				if(state == 0){//待办传递流程参数
					flow.setWfFlowId(collectDoc.getFlow_id());
					flow.setWfFlowVersion(collectDoc.getFlow_version());
					flow.setCurActivityId(collectDoc.getActivity_id());

					Business busi = new Business();
					busi.setCreateId(collectDoc.getCreate_id());
					busi.setWfStartFlag("2");

					HandleParams handleParams = new HandleParams(flow,busi);
					bundle.putSerializable("handleParams",handleParams);
				}
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});

		//设置刷新球颜色
		mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.main));
		/* 刷新操作 */
		mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				flag = 0;
				mCurrentPage = 1;
				Log.d(TAG, "onRefresh: "+mSubmitParams.getOperateType());
				params.put("PageIndex", mCurrentPage);
				doAction(params);
			}
		});

		/* 加载更多 */
		mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
			@Override
			public void onLoadMoreRequested() {
				mRclvList.postDelayed(new Runnable() {
					@Override
					public void run() {
						if (mCurrentPage >= mTotalPage) {//数据全部加载完毕
							mAdapter.loadMoreEnd();
							Log.d(TAG, "run: end");
						} else {//数据未加载完，继续请求加载
							flag = 1;
							mCurrentPage += 1;
							Log.d(TAG, "run: load");
							params.put("PageIndex", mCurrentPage);
							doAction(params);
						}
					}
				}, 1000);
			}
		},mRclvList);

		mEdtKey.addTextChangedListener(new EditChangedListener());
	}

	@Override
	protected void initData() {
		mSwipeRefresh.post(new Runnable() {
			@Override
			public void run() {
				mSwipeRefresh.setRefreshing(true);
			}
		});
		params.put("PageIndex", mCurrentPage);
		params.put("PageSize", Contants.GLOBAL_PAGESIZE);
		params.put("SortName", "");
		params.put("SortOrder", "");
		params.put("KeyWord", "");
		Log.d(TAG, "initData: " + mSubmitParams.toString());
		doAction(params);
	}

	private void doAction(Map<String, Object> params){
		mSubmitParams.setParaInfo(gson.toJson(params));
		mPresenter.operate(mSubmitParams, true);
	}

	@Override
	protected void initInject() {
		DaggerOperateComponent.builder()
				.appModule(new AppModule(mContext))
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
		int flag = getBundleInt();
		if (flag == 0) {
			return "PubOA.WService.CollectDoc.GeCollectDocTodoList";
		} else if (flag == 1) {
			return "PubOA.WService.CollectDoc.GetCollectDocDoList";
		} else if (flag == 2) {
			return "PubOA.WService.CollectDoc.GetCollectDocSaveList";
		} else {
			return null;
		}
	}


	public static CollectDocFragment getInstance(int flag) {
		CollectDocFragment mCollectDocFragment = new CollectDocFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("flag", flag);
		mCollectDocFragment.setArguments(bundle);
		return mCollectDocFragment;
	}

	@Override
	public void operateSuccess(String data) {
		PageBean<RowsBean<CollectDoc>> page = gson.fromJson(data, new TypeToken<PageBean<RowsBean<CollectDoc>>>() {
		}.getType());
		List<CollectDoc> list = page.getDatas().getRows();
		//获取页码
		mTotalPage = page.getPageCount();
		if(flag == 0){//第一次加载或者刷新
			mData.clear();
			if(list.size() == 0){
				showNonData();
				return;
			}else{
				hideNonData();
				mAdapter.setNewData(list);
			}
			if(mSwipeRefresh.isRefreshing()){
				mSwipeRefresh.post(new Runnable() {
					@Override
					public void run() {
						mSwipeRefresh.setRefreshing(false);
					}
				});
			}
		}else if(flag == 1){//加载更多
			mAdapter.loadMoreComplete();
			mAdapter.addData(list);
		}
	}

	public class EditChangedListener implements TextWatcher{
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			Log.d(TAG, "onTextChanged: "+s.toString());
			mSwipeRefresh.post(new Runnable() {
				@Override
				public void run() {
					mSwipeRefresh.setRefreshing(true);
				}
			});
			mCurrentPage = 1;
			flag = 0;
			params.put("PageIndex", mCurrentPage);
			params.put("KeyWord", s.toString());
			doAction(params);
		}
	}
}
