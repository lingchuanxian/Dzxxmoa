package cn.com.kind.dzxxmoa.ui.activity.personal;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.PageBean;
import cn.com.kind.dzxxmoa.bean.RowsBean;
import cn.com.kind.dzxxmoa.bean.VersionLog;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.adapter.VersionLogAdapter;

/**
 * APP更新日志
 *
 * @author ling_cx
 * @date 2017/8/11
 */

public class VersionLogActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView{
	@BindView(R.id.rclvLog)
	RecyclerView mRclvLog;

	private List<VersionLog> mData;
	private VersionLogAdapter mAdapter;

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_personal_version_log;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.pe_updateLog));
		mRclvLog.setLayoutManager(new LinearLayoutManager(mContext));
	}

	@Override
	protected void initData() {
		progress.show();
		Map<String, String> params = new HashMap<>();
		params.put("PageIndex","1");
		params.put("PageSize","20");
		params.put("SortName","");
		params.put("SortOrder","");
		params.put("KeyWord","android|LD");
		mSubmitParams.setParaInfo(gson.toJson(params));
		mPresenter.operate(mSubmitParams,true);
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
		return "PubOA.WService.AppManage.AppManage";
	}

	@Override
	public void operateSuccess(String data) {
		PageBean<RowsBean<VersionLog>> page = gson.fromJson(data,new TypeToken<PageBean<RowsBean<VersionLog>>>() {
		}.getType());
		mData = page.getDatas().getRows();
		mAdapter = new VersionLogAdapter(mData);
		mRclvLog.setAdapter(mAdapter);
		progress.dismiss();
	}
}
