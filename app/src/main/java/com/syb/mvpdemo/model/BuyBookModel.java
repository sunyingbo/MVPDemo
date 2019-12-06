package com.syb.mvpdemo.model;

import android.os.Handler;

import com.syb.mvpdemo.bean.BuyBookBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BuyBookModel implements IBuyBookModel {

    private List<BuyBookBean> listData;

    public BuyBookModel() {
        listData = new ArrayList<>();
    }

    @Override
    public void getTestData(final ValueCallBack<List<BuyBookBean>> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<BuyBookBean> list = new ArrayList<>();
                list.add(new BuyBookBean("赵云", 1, "09-27 09：11"));
                list.add(new BuyBookBean("典韦", 10, "09-27 09：11"));
                list.add(new BuyBookBean("黄忠", 50, "09-27 09：11"));
                list.add(new BuyBookBean("曹操", 30, "09-27 09：11"));

                Random random = new Random();
                int N = random.nextInt(10);
                if (N > 5) {
                    callback.onSuccess(list);
                } else {
                    callback.onFail("拒绝请求");
                }
            }
        }, 1000);
    }

    @Override
    public List<BuyBookBean> getAdapterData() {
        return listData;
    }

}
