package cn.com.kind.dzxxmoa.di.component;

import javax.inject.Singleton;

import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.ui.activity.home.AnnounceActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.AnnounceDetailActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.CollectDocDetailActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.HandleActivity;
import cn.com.kind.dzxxmoa.ui.activity.home.InfoshowActivity;
import cn.com.kind.dzxxmoa.ui.activity.personal.ModifyPwdActivity;
import cn.com.kind.dzxxmoa.ui.activity.personal.VersionLogActivity;
import cn.com.kind.dzxxmoa.ui.fragment.CollectDocFragment;
import dagger.Component;

/**
 * @author ling_cx
 * @date 2017/5/4.
 */
@Singleton
@Component(modules = OperateModule.class,dependencies = AppModule.class)
public interface OperateComponent {
   void inject(ModifyPwdActivity activity);
   void inject(VersionLogActivity activity);
   void inject(AnnounceActivity activity);
   void inject(CollectDocFragment fragment);
   void inject(CollectDocDetailActivity activity);
   void inject(AnnounceDetailActivity activity);
   void inject(InfoshowActivity activity);
   void inject(HandleActivity activity);
}
