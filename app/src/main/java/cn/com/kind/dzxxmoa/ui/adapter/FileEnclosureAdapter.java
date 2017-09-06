package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;
import android.text.format.Formatter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.FileUpload;
import cn.com.kind.dzxxmoa.utils.StringUtil;

/**
 * 附件适配器
 * @author ling_cx
 * @date 2017/9/4.
 */

public class FileEnclosureAdapter extends BaseQuickAdapter<FileUpload,BaseViewHolder> {
	public FileEnclosureAdapter(@Nullable List data) {
		super(R.layout.layout_item_enclosure, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, FileUpload item) {
		helper.setText(R.id.tv_enclosure_name,item.getEncltext()+" ("+ StringUtil.getDataSize(item.getEnclsize())+")");
	}
}
