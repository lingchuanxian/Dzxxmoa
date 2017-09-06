package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.KeyValue;

/**
 * 收文详情适配器
 * @author ling_cx
 * @date 2017/9/4.
 */

public class CollectDocDetailAdapter extends BaseQuickAdapter<KeyValue,BaseViewHolder> {
	public CollectDocDetailAdapter(@Nullable List data) {
		super(R.layout.layout_item_detail, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, KeyValue item) {
		helper.setText(R.id.tv_colunm,item.getKey())
				.setText(R.id.tv_value,item.getValue());
		;
	}
}
