package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.Announce;


/**
 * Created by lcx on 2017/6/8.
 */

public class AnnounceAdapter extends BaseQuickAdapter<Announce,BaseViewHolder> {
	public AnnounceAdapter(@Nullable List data) {
		super(R.layout.layout_item_common, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, Announce item) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		helper.setText(R.id.tv_comm_title,item.getTitle())
			.setText(R.id.tv_modu3,sdf.format(new Date(Long.parseLong(item.getCreate_date().replace("/Date(","").replace(")/","")))))
		.setText(R.id.tv_modu2,item.getCreate_user_deptname())
		.setText(R.id.tv_modu1,item.getCreate_user_name());
	}
}
