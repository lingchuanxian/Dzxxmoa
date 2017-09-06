package cn.com.kind.dzxxmoa.mvp.presenter;

import android.util.Log;

import javax.inject.Inject;

import cn.com.kind.dzxxmoa.base.BasePresenter;
import cn.com.kind.dzxxmoa.bean.HttpResult;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.di.scope.ActivityScope;
import cn.com.kind.dzxxmoa.mvp.model.LoginModel;
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
public class LoginPresenter extends BasePresenter<LoginModel,ViewContract.LoginView> {
	private Subscription subscribe;
	@Inject
	public LoginPresenter(LoginModel model, ViewContract.LoginView view) {
		this.mModel = model;
		this.mView = view;
	}

	public void userLogin(String signon,String password,boolean ifKeyLogin) {
		subscribe = mModel.userLogin(signon, password,true,ifKeyLogin)
				.doOnSubscribe(new Action0() {
					@Override
					public void call() {
					}
				})
				.subscribe(new Subscriber<HttpResult<User>>() {
					@Override
					public void onCompleted() {
					}

					@Override
					public void onError(Throwable e) {
						mView.loginFail(99,e.getMessage());
					}

					@Override
					public void onNext(HttpResult<User> result) {
						Log.d(TAG, "onNext: "+result.toString());
						if(result.getReturnCode() == 0){
							mView.loginSuccess(result.getDescription(),result.getDetailInfo());
						}else{
							mView.loginFail(result.getReturnCode(),result.getDescription());
						}
					}
				});
		addSubscribe(subscribe);
	}

}
