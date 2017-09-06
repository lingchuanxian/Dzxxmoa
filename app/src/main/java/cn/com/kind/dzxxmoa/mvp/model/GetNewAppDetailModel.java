package cn.com.kind.dzxxmoa.mvp.model;


import cn.com.kind.dzxxmoa.api.ApiEngine;
import cn.com.kind.dzxxmoa.api.RetryWithDelay;
import cn.com.kind.dzxxmoa.base.BaseModel;
import cn.com.kind.dzxxmoa.di.scope.ActivityScope;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author ling_cx
 * @date 2017/6/7.
 */
@ActivityScope
public class GetNewAppDetailModel implements BaseModel {

	public Observable<String> getNewAppDetail(String appCode, String appType, String appDisplay){
		return ApiEngine.getInstance().getApiService()
				.getNewAppDetail(appCode,appType,appDisplay)
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.subscribeOn(AndroidSchedulers.mainThread())
				.observeOn(AndroidSchedulers.mainThread())
				//.compose(RxHelper.<HttpResult<Object>>handleResult())
				.retryWhen(new RetryWithDelay(3,3000));
	}
}
