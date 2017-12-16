package com.example.mvp4.presenter;

/**
 * 在我们的Presenter层里，定义一下我们的登陆状态
 * 这里我们可以理解为这就是一个状态监听器
 */

public interface Login2Presenter {

    void onSuccess();//登陆成功

    void onfail(String msg);//登陆失败
}
