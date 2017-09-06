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
 * @date 2017/8/14.
 */
@ActivityScope
public class CheckKeyResultModel implements BaseModel {

	public Observable<String> CheckKeyResult(String appCode,String strSrc,String strB64Sign,String strB64Cert){
		return ApiEngine.getInstance().getApiService().CheckKeyResult(appCode,strSrc,strB64Sign,strB64Cert)
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.subscribeOn(AndroidSchedulers.mainThread())
				.observeOn(AndroidSchedulers.mainThread())
				.retryWhen(new RetryWithDelay(3,1000));
	}
}
