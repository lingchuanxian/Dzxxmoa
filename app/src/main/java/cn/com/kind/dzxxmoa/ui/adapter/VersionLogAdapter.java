package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.VersionLog;
import cn.com.kind.dzxxmoa.utils.StringUtil;


/**
 * 关于我们
 * @author ling_cx
 * @date 2017/8/4.
 */

public class VersionLogAdapter extends BaseQuickAdapter<VersionLog,BaseViewHolder> {
	public VersionLogAdapter(@Nullable List data) {
		super(R.layout.layout_item_versionlog, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, VersionLog item) {
		helper.setText(R.id.tvVersion,item.getVersion())
			.setText(R.id.tvVersionDate, StringUtil.getDate(item.getCreate_date()))
		.setText(R.id.tvVersionExpalin,item.getContent());
	}
}
