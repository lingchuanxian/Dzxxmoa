package cn.com.kind.dzxxmoa.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.CollectDocDetail;
import cn.com.kind.dzxxmoa.bean.HandleParams;
import cn.com.kind.dzxxmoa.bean.KeyValue;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.global.EnclosureItemClickListener;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.adapter.CollectDocDetailAdapter;
import cn.com.kind.dzxxmoa.ui.adapter.FileEnclosureAdapter;
import cn.com.kind.dzxxmoa.utils.StringUtil;

/**
 * 收文详情
 *
 * @author ling_cx
 * @date 2017/9/5
 */

public class CollectDocDetailActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView {
	@BindView(R.id.tv_part2)
	TextView mTvPart2;
	@BindView(R.id.tv_part3)
	TextView mTvPart3;
	@BindView(R.id.tv_detail_title)
	TextView mTvDetailTitle;
	@BindView(R.id.rclv_detail)
	RecyclerView mRclvDetail;
	@BindView(R.id.rclv_collectdoc_main_enclosure)
	RecyclerView mRclvCollectdocMainEnclosure;
	@BindView(R.id.rclv_collectdoc_else_enclosure)
	RecyclerView mRclvCollectdocElseEnclosure;
	@BindView(R.id.btn_action1)
	Button mBtnAction1;
	@BindView(R.id.btn_action2)
	Button mBtnAction2;
	@BindView(R.id.scr_dital)
	ScrollView mScrDital;
	@BindView(R.id.llayout_action)
	LinearLayout mLlayoutAction;
	private Map<String, Object> params = new HashMap<>();
	private CollectDocDetailAdapter mAdapter;
	private List<KeyValue> mData = new ArrayList<>();
	private FileEnclosureAdapter mFileMainEnclosureAdapter;//收文正文适配器
	private FileEnclosureAdapter mFileElseEnclosureAdapter;//其他附件适配器
	private int flag;//收文状态标记位：0代办，1已办，2存档
	private String busikey;
	private HandleParams mHandleParams;
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_collectdoc_detail;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle(getResources().getString(R.string.ho_collectDoc_detail));
		mRclvDetail.setLayoutManager(new LinearLayoutManager(mContext));
		mRclvCollectdocMainEnclosure.setLayoutManager(new LinearLayoutManager(mContext));
		mRclvCollectdocElseEnclosure.setLayoutManager(new LinearLayoutManager(mContext));
		//设置附件的recycleview不可滚动
		mRclvDetail.setNestedScrollingEnabled(false);
		mRclvCollectdocMainEnclosure.setNestedScrollingEnabled(false);
		mRclvCollectdocElseEnclosure.setNestedScrollingEnabled(false);
	}

	@Override
	protected void initData() {
		params.put("Id", getIntent().getExtras().getString("Id"));
		doAction(params);
		flag = getIntent().getExtras().getInt("flag");
		busikey = getIntent().getExtras().getString("busikey");
		Log.d(TAG, "initData: "+busikey);
		if (flag == 0) {
			mBtnAction1.setText("我要办理");
			mBtnAction2.setText("查看痕迹");
			mHandleParams = (HandleParams) getIntent().getExtras().getSerializable("handleParams");
			Log.d(TAG, "initData: "+mHandleParams.toString());
		} else if (flag == 1) {
			mBtnAction1.setText("已办列表");
			mBtnAction2.setText("办理意见");
		} else if (flag == 2) {
			mLlayoutAction.setVisibility(View.GONE);
		}
	}

	private void doAction(Map<String, Object> params) {
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
		return "PubOA.WService.CollectDoc.GetCollectDocDetail";
	}

	@Override
	public void operateSuccess(String data) {
		CollectDocDetail detail = gson.fromJson(data, CollectDocDetail.class);
		mTvPart2.setText(detail.getCollectTypeName());
		mTvPart3.setText("[" + detail.getSendDocNo() + "]");
		mTvDetailTitle.setText(detail.getTitle());

		mData.add(new KeyValue("收文编号：", detail.getCollectDocNo()));
		mData.add(new KeyValue("来文机关：", detail.getSendUnit()));
		mData.add(new KeyValue("收文日期：", StringUtil.getDate(detail.getCollectDate())));
		mData.add(new KeyValue("秘密等级：", detail.getCollectSecretTypeName()));
		mData.add(new KeyValue("缓\t\t\t\t\t急：", detail.getCollectFastTypeName()));
		mData.add(new KeyValue("文件类别：", detail.getCollectFileTypeName()));
		mData.add(new KeyValue("备\t\t\t\t\t注：", detail.getRemark()));
		mAdapter = new CollectDocDetailAdapter(mData);
		mRclvDetail.setAdapter(mAdapter);

		mFileMainEnclosureAdapter = new FileEnclosureAdapter(detail.getDocUpload());
		mRclvCollectdocMainEnclosure.setAdapter(mFileMainEnclosureAdapter);
		mFileElseEnclosureAdapter = new FileEnclosureAdapter(detail.getElseUpload());
		mRclvCollectdocElseEnclosure.setAdapter(mFileElseEnclosureAdapter);
		//设置点击监听
		mFileMainEnclosureAdapter.setOnItemClickListener(new EnclosureItemClickListener());
		mFileElseEnclosureAdapter.setOnItemClickListener(new EnclosureItemClickListener());
		hideLoding();
	}

	@OnClick({R.id.btn_action1,R.id.btn_action2})
	void onClick(View v){
		switch (v.getId()){
			case R.id.btn_action1:
				if(flag == 0){//我要办理
					Intent intent = new Intent(mContext,HandleActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("busikey",busikey);
					bundle.putSerializable("mHandleParams",mHandleParams);
					intent.putExtras(bundle);
					startActivity(intent);
				}else{//已办列表

				}
				break;
			case R.id.btn_action2:
				if(flag == 0){//查看痕迹

				}else{//办理意见

				}
				break;
			default:
				break;
		}
	}

}
