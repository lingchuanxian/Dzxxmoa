package cn.com.kind.dzxxmoa.di.module;

import cn.com.kind.dzxxmoa.mvp.model.GetNewAppDetailModel;
import cn.com.kind.dzxxmoa.mvp.presenter.GetNewAppDetailPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import dagger.Module;
import dagger.Provides;

/**
 * @author ling_cx
 * @date 2017/8/10.
 */
@Module
public class GetNewAppDetailModule {
    private ViewContract.GetNewAppDetailView mView;

    public GetNewAppDetailModule(ViewContract.GetNewAppDetailView view) {
        this.mView = view;
    }
    @Provides
    public GetNewAppDetailPresenter getGetNewAppDetailPresenter(GetNewAppDetailModel model){
        return new GetNewAppDetailPresenter(model,mView);
    }

    @Provides
    public GetNewAppDetailModel getGetNewAppDetailModel(){
        return new GetNewAppDetailModel();
    }

}
