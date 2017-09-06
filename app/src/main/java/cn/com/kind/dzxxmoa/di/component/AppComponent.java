package cn.com.kind.dzxxmoa.di.component;

import android.content.Context;

import javax.inject.Singleton;

import cn.com.kind.dzxxmoa.api.ApiService;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import dagger.Component;

/**
 * @author ling_cx
 * @date 2017/5/4.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();  // 提供Applicaiton的Context
    ApiService apiService();
}
