package cn.com.kind.dzxxmoa.mvp.view;

import java.util.List;

import cn.com.kind.dzxxmoa.base.BaseView;
import cn.com.kind.dzxxmoa.bean.User;
import cn.com.kind.dzxxmoa.bean.VersionBean;


/**
 * Created by lcx on 2017/6/5.
 */

public interface ViewContract {
	interface NewsListView extends BaseView {
		void success(int totlaPage, List<?> list);
		void fail(String msg);
	}
	interface LoginView extends BaseView {
		void loginSuccess(String ticket,User user);
		void loginFail(int code,String message);
	}
	interface OperateView extends BaseView {
		void operateSuccess(String data);
	}
	interface GetNewAppDetailView extends BaseView{
		void getNewAppDetailSuccess(VersionBean versionBean);
	}
	interface CheckKeyResultView extends BaseView{
		void CheckKeyResultSuccess(String result);
	}
	interface DownloadFileView extends BaseView{
		void DownloadFileSuccess();
	}
}
