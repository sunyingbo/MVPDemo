package com.syb.mvpdemo.model;

public interface ValueCallBack<T> {

    void onSuccess(T t);

    void onFail(String code);

}
