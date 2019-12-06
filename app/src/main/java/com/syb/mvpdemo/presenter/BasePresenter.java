package com.syb.mvpdemo.presenter;

import com.syb.mvpdemo.view.BaseActivity;

public abstract class BasePresenter<T extends BaseActivity> {

    abstract void initData();

}
