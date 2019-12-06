package com.syb.mvpdemo.view;

import android.app.Activity;
import android.os.Bundle;

import com.syb.mvpdemo.presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends Activity {

    protected T basePrestenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        basePrestenter = initPresenter();
        onPrepare();
    }

    protected abstract T initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void onPrepare();

}
