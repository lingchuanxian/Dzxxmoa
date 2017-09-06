package cn.com.kind.dzxxmoa.di.module;

import cn.com.kind.dzxxmoa.mvp.model.LoginModel;
import cn.com.kind.dzxxmoa.mvp.presenter.LoginPresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;
import dagger.Module;
import dagger.Provides;

/**
 * @author ling_cx
 * @date 2017/8/10.
 */
@Module
public class LoginModule {
    private ViewContract.LoginView mView;

    public LoginModule(ViewContract.LoginView view) {
        this.mView = view;
    }
    @Provides
    public LoginPresenter getLoginPresenter(LoginModel model){
        return new LoginPresenter(model,mView);
    }

    @Provides
    public LoginModel getNewsListModel(){
        return new LoginModel();
    }

}
