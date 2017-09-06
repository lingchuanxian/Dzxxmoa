package cn.com.kind.dzxxmoa.mvp.presenter;

import android.util.Log;

import javax.inject.Inject;

import cn.com.kind.dzxxmoa.base.BasePresenter;
import cn.com.kind.dzxxmoa.di.scope.ActivityScope;
import cn.com.kind.dzxxmoa.mvp.model.CheckKeyResultModel;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/**
 * 登录的P层
 * @author ling_cx
 * @date 2017/8/4.
 */
@ActivityScope
public class CheckKeyResultPresenter extends BasePresenter<CheckKeyResultModel,ViewContract.CheckKeyResultView> {
	private Subscription subscribe;
	@Inject
	public CheckKeyResultPresenter(CheckKeyResultModel model, ViewContract.CheckKeyResultView view) {
		this.mModel = model;
		this.mView = view;
	}

	public void checkKeyResult(String strSrc,String strB64Sign,String strB64Cert) {
		subscribe = mModel.CheckKeyResult("FeigOA",strSrc,strB64Sign,strB64Cert)
				.doOnSubscribe(new Action0() {
					@Override
					public void call() {
					}
				})
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
						Log.d(TAG, "onNext: "+result.toString());
						mView.CheckKeyResultSuccess(result);
					}
				});
		addSubscribe(subscribe);
	}

}
