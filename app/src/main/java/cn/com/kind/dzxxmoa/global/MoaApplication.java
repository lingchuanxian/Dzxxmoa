package cn.com.kind.dzxxmoa.global;

import android.app.Application;
import android.util.Log;

import com.liulishuo.filedownloader.FileDownloader;
import com.squareup.leakcanary.LeakCanary;

import cat.ereza.customactivityoncrash.config.CaocConfig;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.di.component.AppComponent;
import cn.com.kind.dzxxmoa.di.component.DaggerAppComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.ui.activity.ErrorActivity;
import cn.com.kind.dzxxmoa.ui.activity.SplashActivity;
import cn.com.kind.dzxxmoa.utils.SPUtils;

/**
 * 应用程序的Application类
 * @author ling_cx
 * @date 2017/6/5.
 */
public class MoaApplication extends Application {
	private static MoaApplication instance;
	private ActivityManager activityManager = null; // activity管理类
	private User mUser;
	private String ticket;
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		//内存溢出检测
		LeakCanary.install(this);
		getAppComponent();
		// 获得activity管理类的实例
		activityManager = ActivityManager.getInstance();
		//全局异常处理
		CaocConfig.Builder.create()
				.backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
				.enabled(true)
				.showErrorDetails(true)
				.showRestartButton(true)
				.trackActivities(false)
				.minTimeBetweenCrashesMs(2000)
				.restartActivity(SplashActivity.class)
				.errorActivity(ErrorActivity.class)
				.apply();

		regetUser();
		FileDownloader.setupOnApplicationOnCreate(this);
	}

	public static MoaApplication getInstance() {
		return instance;
	}

	public ActivityManager getActivityManager() {
		return activityManager;
	}

	public AppComponent getAppComponent(){
		return DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.build();
	}

	public void finishAllActivity(){
		activityManager.finishAllActivity();
	}

	/**
	 * 当应用被内存kill后重新启动时从shareperference中重新读取用户信息
	 */
	private void regetUser(){
		User shareUser = SPUtils.getObject(this,"user", User.class);
		if(shareUser != null){
			Log.e("shareUser-application", shareUser.toString());
			this.mUser = shareUser;
		}
		String spTicket = SPUtils.getValue(this, "ticket", "");
		if(!spTicket.equals("")){
			this.ticket = spTicket;
		}
	}

	public User getUser() {
		return mUser;
	}

	public void setUser(User user) {
		mUser = user;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
