package cn.com.kind.dzxxmoa.ui.activity.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.Announce;
import cn.com.kind.dzxxmoa.bean.InfoShow;
import cn.com.kind.dzxxmoa.bean.PageBean;
import cn.com.kind.dzxxmoa.bean.RowsBean;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.adapter.AnnounceAdapter;
import cn.com.kind.dzxxmoa.ui.adapter.InfoShowAdapter;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class InfoshowActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView {

    @BindView(R.id.edt_key)
    EditText edtKey;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.llayout_empty)
    LinearLayout llayoutEmpty;
    @BindView(R.id.rclv_list)
    RecyclerView rclvList;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    private String key = "";
    private List<InfoShow> mDatas = new ArrayList<InfoShow>();
    private InfoShowAdapter mAdapter;
    private int mCurrentPage = 1;//当前页码
    private int mTotalPage;//总页码
    private int flag = 0;//0 -- 第一次加载或者刷新  1 -- 加载更多
    private Map<String, Object> params = new HashMap<>();

    @Override
    protected int attachLayoutRes() {
        return R.layout.common_list_page;
    }

    @Override
    protected void initViews() {

        key = getIntent().getExtras().getString("key");
        switch (key) {

            case "Type_0004|$|"://集团动态
                getToolBar().setTitle(getResources().getString(R.string.ho_group));
                break;
            case "Type_0003|$|"://司务公开
                getToolBar().setTitle(getResources().getString(R.string.ho_mess));
                break;
            case "Type_0001|$|"://交流园地
                getToolBar().setTitle(getResources().getString(R.string.ho_commu));
                break;
        }
        rclvList.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new InfoShowAdapter(mDatas);
        rclvList.setAdapter(mAdapter);
        /**item点击事件 */
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: " + mDatas.size());
//                Intent intent = new Intent(AnnounceActivity.this,AnnounceDetailActivity.class);
//                intent.putExtra("Id", mAdapter.getItem(position).getCreate_id());
//                startActivity(intent);
            }
        });
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                flag = 0;
                mCurrentPage = 1;
                Log.d(TAG, "onRefresh: " + mSubmitParams.getOperateType());
                params.put("PageIndex", mCurrentPage);
                doAction(params);
            }
        });
        /* 加载更多 */
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rclvList.postDelayed(new Runnable() {
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
        }, rclvList);

        edtKey.addTextChangedListener(new TextWatcher() {

            // 第二个执行
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  System.out.println("onTextChanged:" + "start:" + start + "before:" + before + "count:" + count);
            }

            // 第一个执行
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //  System.out.println("beforeTextChanged:" + "start:" + start + "count:" + count + "after:" + after);
            }

            // 第三个执行
            @Override
            public void afterTextChanged(Editable s) { // Edittext中实时的内容
                System.out.println("afterTextChanged:" + s);
                String str = s.toString();
                mSwipeRefresh.post(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefresh.setRefreshing(true);
                    }
                });
                mCurrentPage = 1;
                flag = 0;
                params.put("PageIndex", mCurrentPage);
                params.put("PageSize", Contants.GLOBAL_PAGESIZE);
                params.put("KeyWord", key + str);
                doAction(params);
            }
        });


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
        params.put("KeyWord", key);
        params.put("Infos", null);
        doAction(params);
    }

    private void doAction(Map<String, Object> params) {
        mSubmitParams.setParaInfo(gson.toJson(params));
        mPresenter.operate(mSubmitParams, true);
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
        return "PubOA.WService.Info.InfoShowList";
    }

    @Override
    public void operateSuccess(String data) {
        PageBean<RowsBean<InfoShow>> page = gson.fromJson(data, new TypeToken<PageBean<RowsBean<InfoShow>>>() {
        }.getType());
        List<InfoShow> list = page.getDatas().getRows();
        //获取页码
        mTotalPage = page.getPageCount();
        if (flag == 0) {//第一次加载或者刷新
            mDatas.clear();
            if (list.size() == 0) {
                showNonData();
                return;
            } else {
                hideNonData();
                mAdapter.setNewData(list);
            }
            if (mSwipeRefresh.isRefreshing()) {
                mSwipeRefresh.post(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefresh.setRefreshing(false);
                    }
                });
            }
        } else if (flag == 1) {//加载更多
            mAdapter.loadMoreComplete();
            mAdapter.addData(list);
        }
    }
}
