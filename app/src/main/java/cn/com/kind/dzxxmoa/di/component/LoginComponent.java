package cn.com.kind.dzxxmoa.di.component;

import javax.inject.Singleton;

import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.LoginModule;
import cn.com.kind.dzxxmoa.ui.activity.LoginActivity;
import dagger.Component;

/**
 * @author ling_cx
 * @date 2017/5/4.
 */
@Singleton
@Component(modules = LoginModule.class,dependencies = AppModule.class)
public interface LoginComponent {
   void inject(LoginActivity activity);
}
