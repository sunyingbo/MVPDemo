package com.syb.mvpdemo.presenter;

import com.syb.mvpdemo.bean.BuyBookBean;
import com.syb.mvpdemo.model.BuyBookModel;
import com.syb.mvpdemo.model.IBuyBookModel;
import com.syb.mvpdemo.model.ValueCallBack;
import com.syb.mvpdemo.view.IBuyBookView;

import java.util.List;

public class BuyBookPresenter extends BasePresenter implements IBuyBookPresenter {

    private IBuyBookModel mModel;
    private IBuyBookView mView;

    public BuyBookPresenter(IBuyBookView view) {
        this.mModel = new BuyBookModel();
        this.mView = view;
    }

    @Override
    public void initData() {
        mModel.getTestData(new ValueCallBack<List<BuyBookBean>>() {
            @Override
            public void onSuccess(List<BuyBookBean> buyBookBeans) {
                mModel.getAdapterData().addAll(buyBookBeans);
                mView.refreshAdapter();
            }

            @Override
            public void onFail(String code) {
                mView.showToast(code);
                mView.onEmpty();
            }
        });
    }

    @Override
    public List<BuyBookBean> getAdapterData() {
        return mModel.getAdapterData();
    }

}
