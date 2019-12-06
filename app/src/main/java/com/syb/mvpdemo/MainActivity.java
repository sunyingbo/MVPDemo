package com.syb.mvpdemo;

import android.widget.ListView;
import android.widget.Toast;

import com.syb.mvpdemo.presenter.BuyBookPresenter;
import com.syb.mvpdemo.view.BaseActivity;
import com.syb.mvpdemo.view.BuyBookAdapter;
import com.syb.mvpdemo.view.IBuyBookView;

public class MainActivity extends BaseActivity<BuyBookPresenter> implements IBuyBookView {

    private ListView mListView;
    private BuyBookAdapter mAdapter;

    @Override
    protected BuyBookPresenter initPresenter() {
        return new BuyBookPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mListView = findViewById(R.id.listview);
    }

    @Override
    protected void onPrepare() {
        mAdapter = new BuyBookAdapter(this, basePrestenter.getAdapterData());
        mListView.setAdapter(mAdapter);
        basePrestenter.initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEmpty() {
        mListView.setEmptyView(null);
    }

}
