package com.example.mvp4.model;


public class Login2ModelImpl implements Login2Model {

    @Override
    public void login(String name, String psw, com.example.mvp4.presenter.Login2Presenter login2Presenter) {

        /**
         * 这里我只是对数据做一个简单的判断，大神勿喷。
         */
        if (name.isEmpty() || psw.isEmpty()){
            login2Presenter.onfail("账号密码不能为空");
        } else if (name.equals(psw)) {
            login2Presenter.onSuccess();
        }else {
            login2Presenter.onfail("账号密码错误");
        }
    }

}