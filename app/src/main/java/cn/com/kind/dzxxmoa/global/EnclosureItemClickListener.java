package cn.com.kind.dzxxmoa.global;

import android.content.Context;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.FileUpload;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/9/6
 */

public class EnclosureItemClickListener implements BaseQuickAdapter.OnItemClickListener {
	@Override
	public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
		Context mContext = view.getContext();
		FileUpload fileUpload = (FileUpload)adapter.getItem(position);
		MaterialDialog dialog = new MaterialDialog.Builder(mContext)
				.content(mContext.getResources().getString(R.string.loading))
				.progress(true, 0)
				.cancelable(false)
				.build();
		String url = Contants.IP + fileUpload.getEnclname();
		DownloadManage.downloadFileWithDialog(url,Contants.downloadFilePath+fileUpload.getEncltext(),mContext,dialog);
	}
}
