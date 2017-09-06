package cn.com.kind.dzxxmoa.mvp.model;


import cn.com.kind.dzxxmoa.api.ApiEngine;
import cn.com.kind.dzxxmoa.api.RetryWithDelay;
import cn.com.kind.dzxxmoa.base.BaseModel;
import cn.com.kind.dzxxmoa.bean.SubmitParams;
import cn.com.kind.dzxxmoa.di.scope.ActivityScope;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author ling_cx
 * @date 2017/8/8.
 */
@ActivityScope
public class OperateModel implements BaseModel {

	public Observable<String> operate(SubmitParams submitParams){
		return ApiEngine.getInstance().getApiService()
				.operate(submitParams.getTicket(),
						submitParams.getOperateType(),
						submitParams.getParaType(),
						submitParams.getParaInfo(),
						submitParams.getSoapJson())
				.subscribeOn(Schedulers.io())
				.unsubscribeOn(Schedulers.io())
				.subscribeOn(AndroidSchedulers.mainThread())
				.observeOn(AndroidSchedulers.mainThread())
				//.compose(RxHelper.<HttpResult<Object>>handleResult())
				.retryWhen(new RetryWithDelay(3,3000));
	}
}
