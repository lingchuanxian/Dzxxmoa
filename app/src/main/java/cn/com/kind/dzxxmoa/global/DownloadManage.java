package cn.com.kind.dzxxmoa.global;

import android.content.Context;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

import cn.com.kind.dzxxmoa.R;
import cn.com.kind.dzxxmoa.utils.AppUtil;
import cn.com.kind.dzxxmoa.utils.FileUtils;
import cn.com.kind.dzxxmoa.utils.ToastUtil;

/**
 * class description here
 *
 * @author ling_cx
 * @date 2017/8/25
 */

public class DownloadManage {
	protected static final String TAG = "DownloadManage";

	/**
	 * 下载APK并且通过dialog来控制显示
	 *
	 * @param url 下载地址
	 * @param path 存储路径
	 * @param mContext 上下文对象
	 * @param mDialog 要显示的对话框
	 * @param application 不为空则为退出App
	 */
	public static void downloadApkWithDialog(final String url,final String path, final Context mContext, final MaterialDialog mDialog,final MoaApplication application){
		FileDownloader.getImpl().create(url)
				.setPath(path)
				.setListener(new FileDownloadListener() {
					@Override
					protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
						Log.d(TAG, "pending: 正在建立连接。。。");
					}

					@Override
					protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
						Log.d(TAG, "connected: 连接成功，正在下载");
						mDialog.setContent(mContext.getResources().getString(R.string.lg_connected));
					}

					@Override
					protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
						mDialog.setContent(mContext.getResources().getString(R.string.lg_downloading)+String.format("(%dKB/s)", task.getSpeed()));
						mDialog.setProgress((int)((double)soFarBytes/(double)totalBytes*100));
					}

					@Override
					protected void blockComplete(BaseDownloadTask task) {
						Log.d(TAG, "blockComplete: ");
					}

					@Override
					protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
						Log.d(TAG, "retry: ");
					}

					@Override
					protected void completed(BaseDownloadTask task) {
						Log.d(TAG, "onCompleted: 下载完成");
						mDialog.dismiss();
						AppUtil.installAPK(new File(path),mContext);
						if(application!=null){
							application.finishAllActivity();
						}
					}

					@Override
					protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
						Log.d(TAG, "paused: ");
					}

					@Override
					protected void error(BaseDownloadTask task, Throwable e) {
						Log.e(TAG, "error: " );
						mDialog.setContent("下载出错!");
					}

					@Override
					protected void warn(BaseDownloadTask task) {
						Log.d(TAG, "warn: ");
					}
				}).start();
	}

	/**
	 * 下载文件，完成后自动打开
	 *
	 * @param url 下载地址
	 * @param path 存储路径
	 * @param mContext 上下文对象
	 * @param mDialog 要显示的对话框
	 */
	public static void downloadFileWithDialog(final String url,final String path, final Context mContext, final MaterialDialog mDialog){
		FileDownloader.getImpl().create(url)
				.setPath(path)
				.setListener(new FileDownloadListener() {
					@Override
					protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
						Log.d(TAG, "pending: 正在建立连接。。。");
						mDialog.show();
					}

					@Override
					protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
						Log.d(TAG, "connected: 连接成功，正在下载");
					}

					@Override
					protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
					}

					@Override
					protected void blockComplete(BaseDownloadTask task) {
						Log.d(TAG, "blockComplete: ");
					}

					@Override
					protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
						Log.d(TAG, "retry: ");
					}

					@Override
					protected void completed(BaseDownloadTask task) {
						Log.d(TAG, "onCompleted: 下载完成");
						mDialog.dismiss();
						FileUtils.openFile(new File(path),mContext);
					}

					@Override
					protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
						Log.d(TAG, "paused: ");
					}

					@Override
					protected void error(BaseDownloadTask task, Throwable e) {
						Log.e(TAG, "error: " +e.getMessage());
						mDialog.dismiss();
						if(e.getMessage().contains("404")){
							ToastUtil.show(mContext,"文件不存在");
						}else{
							ToastUtil.show(mContext,e.getMessage());
						}
					}

					@Override
					protected void warn(BaseDownloadTask task) {
						Log.d(TAG, "warn: ");
					}
				}).start();
	}
}
