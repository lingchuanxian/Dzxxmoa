package cn.com.kind.dzxxmoa.di.module;

import cn.com.kind.dzxxmoa.mvp.model.OperateModel;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import dagger.Module;
import dagger.Provides;

/**
 * @author ling_cx
 * @date 2017/8/10.
 */
@Module
public class OperateModule {
    private ViewContract.OperateView mView;

    public OperateModule(ViewContract.OperateView view) {
        this.mView = view;
    }
    @Provides
    public OperatePresenter getOperatePresenter(OperateModel model){
        return new OperatePresenter(model,mView);
    }

    @Provides
    public OperateModel getOperateModel(){
        return new OperateModel();
    }

}
