package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.CollectDoc;
import cn.com.kind.dzxxmoa.utils.StringUtil;

/**
 * 收文列表适配器
 * @author ling_cx
 * @date 2017/9/4.
 */

public class CollectDocAdapter extends BaseQuickAdapter<CollectDoc,BaseViewHolder> {
	public CollectDocAdapter(@Nullable List data) {
		super(R.layout.layout_item_common, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, CollectDoc item) {
		helper.setText(R.id.tv_comm_title,item.getTitle())
				.setText(R.id.tv_modu1,item.getCreate_user_name())
				.setVisible(R.id.lin_modu2,false)
				.setText(R.id.tv_modu3, StringUtil.getDate(item.getCollect_date()));
		;
	}
}
