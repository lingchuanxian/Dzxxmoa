package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.InfoShow;
import cn.com.kind.dzxxmoa.utils.StringUtil;


/**
 * Created by lcx on 2017/6/8.
 */

public class InfoShowAdapter extends BaseQuickAdapter<InfoShow, BaseViewHolder> {
    public InfoShowAdapter(@Nullable List data) {
        super(R.layout.layout_item_common, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InfoShow item) {
        helper.setText(R.id.tv_comm_title, item.getTitle())
                .setText(R.id.tv_modu3, StringUtil.getDate(item.getIssue_date()))
                .setVisible(R.id.lin_modu2, false)
                .setText(R.id.tv_modu1, item.getCreate_user_name());
    }
}
