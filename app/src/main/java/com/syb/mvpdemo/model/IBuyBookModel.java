package com.syb.mvpdemo.model;

import com.syb.mvpdemo.bean.BuyBookBean;

import java.util.List;

public interface IBuyBookModel {

    void getTestData(ValueCallBack<List<BuyBookBean>> callback);

    List<BuyBookBean> getAdapterData();

}
