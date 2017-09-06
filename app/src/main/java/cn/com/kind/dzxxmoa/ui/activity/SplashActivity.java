package cn.com.kind.dzxxmoa.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.global.Contants;
import cn.com.kind.dzxxmoa.utils.ActivityUtils;
import cn.com.kind.dzxxmoa.utils.ImageLoader;

/**
 * 引导页
 * @author ling_cx
 * @date 2017/8/4.
 */

public class SplashActivity extends AppCompatActivity{

	@BindView(R.id.ivSplsh)
	ImageView mIvSplsh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
		ButterKnife.bind(this);
		initViews();
		initData();
	}

	protected void initViews() {
		mIvSplsh.setImageBitmap(ImageLoader.load(this, R.mipmap.bg_splashs));
	}

	protected void initData() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				ActivityUtils.toNextActivity(SplashActivity.this, Contants.loginClass);
				finish();
			}
		}, 2000);
	}
}
