package cn.com.kind.dzxxmoa.ui.activity.home;

import cn.com.kind.dzxxmoa.base.BaseActivity;
import cn.com.kind.dzxxmoa.mvp.presenter.OperatePresenter;
import cn.com.kind.dzxxmoa.mvp.view.ViewContract;

/**
 * Created by lcx on 2017/9/6 0006.
 */

public class HandleSelectActivity extends BaseActivity<OperatePresenter> implements ViewContract.OperateView{

    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initInject() {

    }

    @Override
    protected String[] getNeedPermissions() {
        return new String[0];
    }

    @Override
    protected String getOperateType() {
        return null;
    }

    @Override
    public void operateSuccess(String data) {

    }
}
