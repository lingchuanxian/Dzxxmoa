package cn.com.kind.dzxxmoa.mvp.presenter;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.inject.Inject;

import cn.com.kind.dzxxmoa.base.BasePresenter;
import cn.com.kind.dzxxmoa.bean.SubmitParams;
import cn.com.kind.dzxxmoa.mvp.model.OperateModel;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import rx.Subscriber;
import rx.Subscription;

/**
 * 公共的Operate类
 * @author ling_cx
 * @date 2017/8/4.
 */

public class OperatePresenter extends BasePresenter<OperateModel,ViewContract.OperateView> {
	private Subscription subscribe;
	private SubmitParams mSubmitParams;
	private Boolean mReturnData;
	private int mPosition = -1;
	@Inject
	public OperatePresenter(OperateModel model, ViewContract.OperateView view) {
		this.mModel = model;
		this.mView = view;
	}

	public void operate(SubmitParams submitParams,final Boolean returnData) {
		mSubmitParams = submitParams;
		mReturnData = returnData;
		operate();
	}

	public void operate(SubmitParams submitParams,final Boolean returnData,int position) {
		mSubmitParams = submitParams;
		mReturnData = returnData;
		mPosition = position;
		operate();
	}

	private void operate(){
		subscribe = mModel.operate(mSubmitParams)
				.subscribe(new Subscriber<String>() {
					@Override
					public void onCompleted() {
					}
					@Override
					public void onError(Throwable e) {
						mView.requestFail(e.getMessage());
					}

					@Override
					public void onNext(String result) {
						Log.d(TAG, "onNext: "+result);
						JsonObject obj1 = new JsonParser().parse(result).getAsJsonObject();
						int code = obj1.get("ReturnCode").getAsInt();
						String description = obj1.get("Description").getAsString();
						String detail = obj1.get("DetailInfo").toString();
						if(code == 0){
							if(mReturnData){
								if(mPosition != -1){
									mView.operateSuccess(detail);
								}else{

								}

							}else{
								if(mPosition != -1){
									mView.operateSuccess(null);
								}else{

								}
							}
						}else{
							mView.operateFail(code,description);
						}
					}
				});
		addSubscribe(subscribe);
	}
}
