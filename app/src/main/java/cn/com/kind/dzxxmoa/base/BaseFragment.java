package cn.com.kind.dzxxmoa.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.bean.SubmitParams;
import cn.com.kind.dzxxmoa.global.MoaApplication;
import cn.com.kind.dzxxmoa.ui.activity.LoginActivity;
import cn.com.kind.dzxxmoa.utils.AppUtil;
import cn.com.kind.dzxxmoa.utils.ToastUtil;
import cn.com.kind.dzxxmoa.widget.EmptyLayout;
import cn.com.kind.dzxxmoa.widget.ToolBarSet;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * 基类的Fragment
 * @author ling_cx
 * @date 2017/5/4.
 */
//TODO Fragment 的6.0以上的权限处理
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
	@Nullable
	@BindView(R.id.empty_layout)
	EmptyLayout mEmptyLayout;
	@Nullable
	@BindView(R.id.llayout_empty)
	LinearLayout mLlayoutEmpty;
	@Inject
	protected P mPresenter;
	public Context mContext;
	public View view;
	private Toolbar mToolbar;
	private ToolBarSet mToolBarSet;
	public MoaApplication app;

	/**
	 * 需要进行检测的权限数组
	 */
	protected String[] mNeedPermissions = {};
	private static final int PERMISSION_REQUEST_CODE = 0;
	private boolean isNeedCheckPermission = true; //判断是否需要检测，防止无限弹框申请权限

	public SubmitParams mSubmitParams = null;
	public Gson gson = new Gson();

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.base_layout, container, false);
		initDefaultView(attachLayoutRes(),view);
		mNeedPermissions = getNeedPermissions();
		//checkPermissions(mNeedPermissions);
		init();
		return view;
	}

	private void initDefaultView(int layoutResId,View view) {
		FrameLayout container = (FrameLayout)view.findViewById(R.id.container);
		mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
		View childView = LayoutInflater.from(getActivity()).inflate(layoutResId, null);
		container.addView(childView, 0);
		ButterKnife.bind(this,container);
	}

	private void init() {
		mContext = getActivity();
		app = (MoaApplication) getActivity().getApplication();
		mToolBarSet = new ToolBarSet(mToolbar,(AppCompatActivity)getActivity());
		if(getOperateType()!=null){
			mSubmitParams = new SubmitParams(app.getTicket(),getOperateType(),"Json",true);
		}
		initInject();
		initViews();
		initData();
	}

	/**
	 * 绑定布局文件
	 * @return 布局文件ID
	 */
	@LayoutRes
	protected abstract int attachLayoutRes();

	/**
	 * 初始化视图控件
	 */
	protected abstract void initViews();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	/**
	 * 初始化dagger2
	 */
	protected abstract void initInject();

	/**
	 * 获取所需的危险权限进行请求
	 */
	protected abstract String[] getNeedPermissions();

	/**
	 * 获取请求类别
	 */
	protected abstract String getOperateType();

	/**
	 * 校验权限是否已获得
	 * @param permissions
	 */
	private void checkPermissions(String... permissions) {
		List<String> needRequestPermissionList = findDeniedPermissions(permissions);
		if (null != needRequestPermissionList
				&& needRequestPermissionList.size() > 0) {
			requestPermissions(
					needRequestPermissionList.toArray(
							new String[needRequestPermissionList.size()]),
					PERMISSION_REQUEST_CODE);
		}
	}

	/**
	 * 获取权限集中需要申请权限的列表
	 * @param permissions
	 * @return
	 */
	private List<String> findDeniedPermissions(String[] permissions) {
		List<String> needRequestPermissionList = new ArrayList<>();
		for (String perm : permissions) {
			if (ContextCompat.checkSelfPermission(mContext, perm) != PackageManager.PERMISSION_GRANTED
					|| shouldShowRequestPermissionRationale(perm)) {
				needRequestPermissionList.add(perm);
			}
		}
		return needRequestPermissionList;
	}

	/**
	 * 检测是否需要的权限都已经授权
	 * @param grantResults
	 * @return
	 */
	private boolean verifyPermissions(int[] grantResults) {
		for (int result : grantResults) {
			if (result != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 请求权限的结果
	 * @param requestCode
	 * @param permissions
	 * @param grantResults
	 */
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == PERMISSION_REQUEST_CODE) {
			if (!verifyPermissions(grantResults)) {
				showMissingPermissionDialog();
				isNeedCheckPermission = false;
			}
		}
	}

	/**
	 * 显示提示信息
	 */
	private void showMissingPermissionDialog() {
		new MaterialDialog.Builder(mContext)
				.title("提示信息")
				.content("缺少必要权限，应用将不能正常使用。<br>\\r请点击\\\"去设置\\\"-\\\"权限\\\"-打开所需权限。")
				.positiveText("去设置")
				.onPositive(new MaterialDialog.SingleButtonCallback() {
					@Override
					public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
						AppUtil.startAppSettings(mContext);
					}
				})
				.negativeText("拒绝")
				.onNegative(new MaterialDialog.SingleButtonCallback() {
					@Override
					public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
						//app.finishAllActivity();
						((Activity)mContext).finish();
					}
				})
				.show();
	}


	@Override
	public void requestFail(String message){
		Log.d(TAG, "requestFail: "+message);
		if(message.contains("JsonReader")){
			ToastUtil.show(mContext, getResources().getString(R.string.returnDataFormatError));
		}else{
			ToastUtil.show(mContext, message);
		}
	}

	@Override
	public void operateFail(int code,final String message){
		if (code == 2) {
			ToastUtil.show(mContext, getResources().getString(R.string.login_timeout));
			Intent intent = new Intent(mContext, LoginActivity.class);
			Bundle bundle = new Bundle();
			bundle.putInt("logout", 1);
			intent.putExtras(bundle);
			startActivity(intent);
			app.finishAllActivity();
		} else {
			ToastUtil.show(mContext, message);
		}
	}

	/**
	 * 获取Toolbar对象
	 * @return
	 */
	public ToolBarSet getToolBar(){
		if(mToolBarSet==null){
			mToolBarSet = new ToolBarSet(mToolbar,(AppCompatActivity)getActivity());
		}
		return mToolBarSet;
	}

	public int getBundleInt() {
		Bundle bundle = this.getArguments();
		if (bundle != null) {
			return bundle.getInt("flag");
		} else {
			return -1;
		}
	}

	@Override
	public void startActivity(Class<?> clz) {

	}

	@Override
	public void startActivity(Class<?> clz, Bundle bundle) {

	}

	@Override
	public void showLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
		}
	}

	@Override
	public void hideLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.hide();
		}
	}

	@Override
	public void showErr(String err) {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
		}
	}

	@Override
	public void showNonData() {
		if (mLlayoutEmpty != null) {
			mLlayoutEmpty.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hideNonData() {
		if (mLlayoutEmpty != null) {
			mLlayoutEmpty.setVisibility(View.GONE);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onResume() {
		super.onResume();
		/*if(isNeedCheckPermission){
			checkPermissions(mNeedPermissions);
		}*/
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
