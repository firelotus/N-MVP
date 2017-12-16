package com.example.mvp2.model;


public interface CallBack {
    /**
     * model处理逻辑：成功回调
     */
    void onSuccess();
    /**
     * model处理逻辑：失败回调
     */
    void onFilure(String fail);
}
