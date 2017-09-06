package cn.com.kind.dzxxmoa.base;

import android.os.Bundle;

/**
 * 基类的View
 * @author ling_cx
 * @date 2017/5/4.
 */
public interface BaseView {
    /**
     * 显示进度条
     */
    void showLoding();
    /**
     * 隐藏进度条
     */
    void hideLoding();
    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);
    /**
     * 显示暂无数据
     */
    void showNonData();
    /**
     * 隐藏暂无数据
     */
    void hideNonData();

    /**
     * activity跳转
     * @param clz
     */
    void startActivity(Class<?> clz);

    /**
     * activity跳转，带参数
     * @param clz
     * @param bundle
     */
    void startActivity(Class<?> clz, Bundle bundle);

    /**
     * 请求异常
     * @param message
     */
    void requestFail(String message);

    /**
     * 请求成功，操作失败
     * @param code
     * @param message
     */
    void operateFail(int code,String message);

}