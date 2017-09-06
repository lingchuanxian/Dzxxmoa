package cn.com.kind.dzxxmoa.mvp.model;


import cn.com.kind.dzxxmoa.api.ApiEngine;
import cn.com.kind.dzxxmoa.api.RetryWithDelay;
import cn.com.kind.dzxxmoa.base.BaseModel;
import cn.com.kind.dzxxmoa.bean.HttpResult;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.di.scope.ActivityScope;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author ling_cx
 * @date 2017/8/8.
 */
@ActivityScope
public class LoginModel implements BaseModel {

	public Observable<HttpResult<User>> userLogin(String signon, String password,boolean soapJson,boolean ifKeyLogin){
		return ApiEngine.getInstance().getApiService().userLogin(signon,password,soapJson,ifKeyLogin)
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.subscribeOn(AndroidSchedulers.mainThread())
				.observeOn(AndroidSchedulers.mainThread())
				.retryWhen(new RetryWithDelay(3,1000));
	}
}
