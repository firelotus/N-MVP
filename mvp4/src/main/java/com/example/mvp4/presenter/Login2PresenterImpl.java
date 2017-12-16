package com.example.mvp4.presenter;

import com.example.mvp4.model.Login2Model;
import com.example.mvp4.model.Login2ModelImpl;
import com.example.mvp4.view.Login2View;

public class Login2PresenterImpl implements Login2Presenter {

    private Login2View login2View;
    private Login2Model login2Model;//声明出我们Login2Model业务处理层的接口

    /**
     * 这里我们写一个带参构造方法
     * @param login2View 哪个View调用我们，就需要传哪个View的参数
     */
    public Login2PresenterImpl(Login2View login2View) {
        this.login2View = login2View;
        login2Model = new Login2ModelImpl();//再new出我们业务处理接口的具体实现类
    }

    /**
     * 在这定义一个登陆的方法
     */
    public void login(){
        //将view中的参数获取出来。
        String name = login2View.getName();
        String psw = login2View.getPassWord();
        /**
         * 调用一下业务处理model层的登陆方法
         * 参数一：账号
         * 参数二：密码
         * 参数三：登陆状态监听器
         */
        login2Model.login(name,psw,this);
    }

    /**
     * 下面都是实现我们刚刚在接口中的方法
     */
    @Override
    public void onSuccess() {
        login2View.onSuccess();
    }

    @Override
    public void onfail(String msg) {
        login2View.shouToast(msg);
    }
}