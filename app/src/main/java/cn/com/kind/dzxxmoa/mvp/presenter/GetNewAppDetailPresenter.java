package cn.com.kind.dzxxmoa.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.inject.Inject;

import cn.com.kind.dzxxmoa.base.BasePresenter;
import cn.com.kind.dzxxmoa.bean.VersionBean;
import cn.com.kind.dzxxmoa.mvp.model.GetNewAppDetailModel;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import rx.Subscriber;
import rx.Subscription;

/**
 * 获取App最新版本
 * @author ling_cx
 * @date 2017/8/4.
 */

public class GetNewAppDetailPresenter extends BasePresenter<GetNewAppDetailModel,ViewContract.GetNewAppDetailView> {
	private Subscription subscribe;

	@Inject
	public GetNewAppDetailPresenter(GetNewAppDetailModel model, ViewContract.GetNewAppDetailView view) {
		this.mModel = model;
		this.mView = view;
	}

	public void getNewAppDetail(String appCode, String appType, String appDisplay) {
		subscribe = mModel.getNewAppDetail(appCode,appType,appDisplay)
				.subscribe(new Subscriber<String>() {
					@Override
					public void onCompleted() {
					}
					@Override
					public void onError(Throwable e) {
						Log.e(TAG, "onError: "+e.getMessage() );
						mView.requestFail(e.getMessage());
					}

					@Override
					public void onNext(String result) {
						Log.d(TAG, "onNext: "+result.toString());
						Gson gson = new Gson();
						Document doc;
						VersionBean mVersionBean = null;
						try {
							doc = DocumentHelper.parseText(result);
							Element root = doc.getRootElement();
							mVersionBean = gson.fromJson(root.getText(), VersionBean.class);
							mView.getNewAppDetailSuccess(mVersionBean);
						} catch (DocumentException e) {
							e.printStackTrace();
						}
					}
				});
		addSubscribe(subscribe);
	}
}
