package cn.com.kind.dzxxmoa.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.MenuBean;

/**
 * 首页菜单适配器
 * @author ling_cx
 * @date 2017/8/4.
 */

public class HomeMenuAdapter extends BaseQuickAdapter<MenuBean,BaseViewHolder> {
	public HomeMenuAdapter(@Nullable List data) {
		super(R.layout.layout_item_menu, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, MenuBean item) {
		helper.setText(R.id.tvMenu,item.getName());
		Glide.with(mContext).load(item.getImgId()).crossFade().into((ImageView) helper.getView(R.id.ivIcon));
	}
}
