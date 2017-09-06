package cn.com.kind.dzxxmoa.ui.activity.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.AnnounceDetail;
import cn.com.kind.dzxxmoa.bean.FileUpload;
import cn.com.kind.dzxxmoa.bean.Readers;
import cn.com.kind.dzxxmoa.bean.Receivers;
import cn.com.kind.dzxxmoa.bean.SubmitParams;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.global.EnclosureItemClickListener;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import cn.com.kind.dzxxmoa.ui.adapter.FileEnclosureAdapter;
import cn.com.kind.dzxxmoa.utils.StringUtil;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class AnnounceDetailActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView {

    @BindView(R.id.tv_part1)
    TextView tvPart1;
    @BindView(R.id.tv_part2)
    TextView tvPart2;
    @BindView(R.id.tv_part3)
    TextView tvPart3;
    @BindView(R.id.tv_detail_title)
    TextView tvDetailTitle;
    @BindView(R.id.wbv_detail_content)
    WebView wbv_detail_content;
    @BindView(R.id.rclv_detail_fj)
    RecyclerView rclvdetailfj;
    @BindView(R.id.llayout_fj)
    LinearLayout llayoutFj;
    @BindView(R.id.tv_detail_scope)
    TextView tvDetailScope;
    @BindView(R.id.tv_detail_sign)
    TextView tvDetailSign;
    @BindView(R.id.tv_detail_yiyue)
    TextView tvDetailYiyue;
    @BindView(R.id.llayout_all)
    LinearLayout llayoutAll;
    @BindView(R.id.detail_scr)
    ScrollView detailScr;
    @BindView(R.id.edt_detail_yijian)
    EditText edtDetailYijian;
    private Map<String, Object> params = new HashMap<>();
    private SubmitParams signParams = new SubmitParams();
    private Map<String, Object> signMap = new HashMap<>();

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_announce_detail;
    }

    @Override
    protected void initViews() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//把整个Layout顶上去露出获得焦点的EditText,不压缩多余空间
        getToolBar().setTitle(getResources().getString(R.string.ho_announce));
        tvPart2.setText(getResources().getString(R.string.tongzhi));
    }

    @Override
    protected void initData() {
        String key = getIntent().getStringExtra("Id");
        params.put("Id", key);
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
        return "PubOA.WService.Announce.GetAnnounceDetail";
    }

    @Override
    public void operateSuccess(String data) {

        if(data==null){
            //处理增加签阅意见
            ToastUtil.show(mContext,getResources().getString(R.string.sign_success));
           // initData();
        }else{
            //处理通知详情
            operateDetailsuc(data);
        }

    }

    private void operateDetailsuc(String data){
        AnnounceDetail ad = gson.fromJson(data, new TypeToken<AnnounceDetail>() {//通知公告
        }.getType());
        tvPart3.setText("[" + StringUtil.getDate(ad.getApplyDate()) + "]");
        tvDetailTitle.setText(ad.getTitle());
        if (!StringUtil.isNullOrEmpty(ad.getComment())) {
            String res = ad.getComment();
            Document doc = Jsoup.parse(res);
            Elements img = doc.select("img");
            img.attr("src", Contants.IP2 + img.attr("src"));
            wbv_detail_content.loadData(doc.html(), "text/html; charset=UTF-8", null);
        }
        List<FileUpload> uploads = ad.getUpload();
        if (uploads.size() == 0) {
            llayoutFj.setVisibility(View.GONE);
        } else {
            rclvdetailfj.setLayoutManager(new LinearLayoutManager(mContext));
            rclvdetailfj.setNestedScrollingEnabled(false);
            FileEnclosureAdapter mAdapter = new FileEnclosureAdapter(uploads);
            rclvdetailfj.setAdapter(mAdapter);
            /**item点击事件 */
            mAdapter.setOnItemClickListener(new EnclosureItemClickListener());
        }
        int scopeId = ad.getScopeId();//发布范围id
        String id = "";
        switch (scopeId) {
            case 0:
                id = "全系统";
                break;
            case 1:
                id = "本单位";
                break;
            case 2:
                id = "本部门";
                break;
            case 3:
                List<Receivers> recelist = ad.getReceivers();//指定接收人员
                id = "";
                for (int i = 0; i < recelist.size(); i++) {
                    if (recelist.get(i) != null) {
                        id += recelist.get(i).getReceName() + "、";//将接收人员收集（指定人员范围）
                    }
                }
                id = id.substring(0, id.length() - 1);
                break;
        }
        tvDetailScope.setText(id);
        List<Readers> readers = ad.getReaders();//已阅人员
        //TODO 优化代码，修改签阅意见和已阅人员
        if (readers.size() != 0) {
            String renyuan = "";//已阅人员
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String qianyues = "";//签阅意见，领导的意见放在前面
            for (int i = 0; i < readers.size(); i++) {
                if (readers.get(i) != null) {
                    if (readers.get(i).getReceDeptname().equals("局领导")) {
                        if (readers.get(i).getInfo_Deal() != null) {
                            qianyues += readers.get(i).getInfo_Deal() + "\r\n";
                            long date = Long.parseLong(readers.get(i).getReceDate().substring(6, readers.get(i).getReceDate().length() - 2));
                            Date dt = new Date(date);
                            String time = simple.format(dt);
                            String res = "----------" + readers.get(i).getReceName() + " " + time;
                            qianyues += res + "\r\n\r\n";
                        }
                    }
                }
                renyuan += readers.get(i).getReceName() + "、";
            }
            for (int j = 0; j < readers.size(); j++) {
                if (readers.get(j) != null) {
                    if (readers.get(j).getInfo_Deal() != null) {
                        if (!readers.get(j).getReceDeptname().equals("局领导")) {
                            qianyues += readers.get(j).getInfo_Deal() + "\r\n";
                            long date = Long.parseLong(readers.get(j).getReceDate().substring(6, readers.get(j).getReceDate().length() - 2));
                            Date dt = new Date(date);
                            String time = simple.format(dt);
                            String res = "----------" + readers.get(j).getReceName() + " " + time;
                            qianyues += res + "\r\n\r\n";

                        }
                    }
                }
            }
            tvDetailSign.setText(qianyues);
            tvDetailYiyue.setText(renyuan.substring(0, renyuan.length() - 1));
            signParams = mSubmitParams;
            signParams.setOperateType("PubOA.WService.Announce.InsertInfoReadDeal");
            signMap.put("ReceInfoid", ad.getCreateId());
            signMap.put("ReceId", 1);
        }
        hideLoding();

    }
    @OnClick(R.id.btn_detail_sign)
    public void onViewClicked() {
       String str= edtDetailYijian.getText().toString();
        if(!StringUtil.isNullOrEmpty(str)) {
            signMap.put("Info_Deal", str);
            signParams.setParaInfo(gson.toJson(signMap));
            mPresenter.operate(signParams, false);
        }else{
            ToastUtil.show(mContext,getResources().getString(R.string.sign_comment));
        }
    }

}
