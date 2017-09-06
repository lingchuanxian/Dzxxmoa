package cn.com.kind.dzxxmoa.di.module;

import cn.com.kind.dzxxmoa.mvp.model.CheckKeyResultModel;
import cn.com.kind.dzxxmoa.mvp.presenter.CheckKeyResultPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import dagger.Module;
import dagger.Provides;

/**
 * @author ling_cx
 * @date 2017/8/10.
 */
@Module
public class CheckKeyResultModule {
    private ViewContract.CheckKeyResultView mView;

    public CheckKeyResultModule(ViewContract.CheckKeyResultView view) {
        this.mView = view;
    }
    @Provides
    public CheckKeyResultPresenter getCheckKeyResultPresenter(CheckKeyResultModel model){
        return new CheckKeyResultPresenter(model,mView);
    }

    @Provides
    public CheckKeyResultModel getCheckKeyResultModel(){
        return new CheckKeyResultModel();
    }

}
