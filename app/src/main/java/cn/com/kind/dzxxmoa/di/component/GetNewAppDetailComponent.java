package cn.com.kind.dzxxmoa.di.component;

import javax.inject.Singleton;

import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.GetNewAppDetailModule;
import cn.com.kind.dzxxmoa.ui.activity.HomeActivity;
import cn.com.kind.dzxxmoa.ui.activity.personal.VersionActivity;
import dagger.Component;

/**
 * @author ling_cx
 * @date 2017/5/4.
 */
@Singleton
@Component(modules = GetNewAppDetailModule.class,dependencies = AppModule.class)
public interface GetNewAppDetailComponent {
   void inject(VersionActivity activity);
   void inject(HomeActivity activity);
}
