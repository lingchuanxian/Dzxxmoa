package cn.com.kind.dzxxmoa.ui.activity.home;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.bean.Business;
import cn.com.kind.dzxxmoa.bean.Flow;
import cn.com.kind.dzxxmoa.bean.HandleParams;
import cn.com.kind.dzxxmoa.bean.Radio;
import cn.com.kind.dzxxmoa.di.component.DaggerOperateComponent;
import cn.com.kind.dzxxmoa.di.module.AppModule;
import cn.com.kind.dzxxmoa.di.module.OperateModule;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/9/6
 */

public class HandleActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView {
	private HandleParams mHandleParams = new HandleParams();
	private String busikey = null;
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_handle;
	}

	@Override
	protected void initViews() {
		mHandleParams = (HandleParams) getIntent().getExtras().getSerializable("mHandleParams");
		Log.d(TAG, "HandleinitData: "+mHandleParams.toString());
		doAction(mHandleParams);
	}

	@Override
	protected void initData() {

	}

	private void doAction(HandleParams params) {
		mSubmitParams.setParaInfo(gson.toJson(params));
		//mPresenter.operate(mSubmitParams, true);
	}

	@Override
	protected void initInject() {
		DaggerOperateComponent.builder()
				.appModule(new AppModule(mContext))
				.operateModule(new OperateModule(this))
				.build()
				.inject(this);
	}

	@Override
	protected String[] getNeedPermissions() {
		return new String[0];
	}

	@Override
	protected String getOperateType() {
		busikey = getIntent().getExtras().getString("busikey");
		if(busikey.equals("CollectDoc")){
			return "PubOA.WService.CollectDoc.GetCollectDocOperateActivity";
		}else{
			return null;
		}
	}

	@Override
	public void operateSuccess(String data) {
		JsonObject obj = new JsonParser().parse(data).getAsJsonObject();
		Flow flow = gson.fromJson(obj.get("Flow").toString(), Flow.class);
		Log.d(TAG, "operateSuccess: flow--->"+flow.toString());

		String activity = obj.get("Activity").toString();
		JsonObject obj1 = new JsonParser().parse(activity).getAsJsonObject();

		String ActivityName = obj1.get("ActivityName").toString();

		String Operate = obj1.get("Operate").toString();
		JsonObject obj2 = new JsonParser().parse(Operate).getAsJsonObject();

		String radioString = obj2.get("Radio").toString().replace("Key", "key").replace("Value", "value").replace("JsHide", "jsHide").replace("CheckOpinion", "checkOpinion");

		List<Radio> radioList = gson.fromJson(radioString,new TypeToken<List<Radio>>() {
		}.getType());

		String nextLine = obj2.get("NextLine").toString();

		String activityNext = obj2.get("ActivityNext").toString();

		Business busi = gson.fromJson(obj.get("Business").toString(), Business.class);

		hideLoding();
	}
}
