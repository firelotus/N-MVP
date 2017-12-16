package com.example.mvp1.base;

public interface BaseMvpView {
    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    void showLoding(String msg);

    /**
     * 隐藏进度条
     */
    void hideLoding();

    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);
}
