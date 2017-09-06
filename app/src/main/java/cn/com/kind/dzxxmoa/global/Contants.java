package cn.com.kind.dzxxmoa.global;

import android.os.Environment;

import java.io.File;

import cn.com.kind.dzxxmoa.ui.activity.home.HandleActivity;

/**
 * 静态常量
 * @author ling_cx
 * @date 2017/5/4.
 */

public class Contants {
	public final static String IP = "http://192.168.0.245/FeigOA/";
	public final static String IP2 = "http://192.168.0.245";
	public final static Class loginClass = HandleActivity.class;
	public final static String downloadFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "dzxxmoa" + File.separator;
	public final static int GLOBAL_PAGESIZE = 0;

}
