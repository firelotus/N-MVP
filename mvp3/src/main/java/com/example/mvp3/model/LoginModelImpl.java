package com.example.mvp3.model;

import com.example.mvp3.bean.User;
import com.example.mvp3.contract.LoginContract;

public class LoginModelImpl implements LoginContract.Login1Model{

    @Override
    public void login(String name, String psw, LoginContract.Login1Presenter presenter) {

        User be = getBean();
        if (name.isEmpty() && psw.isEmpty()){
            presenter.onfail();
        }else {
            if (name.equals(be.name) && psw.equals(be.psw)){
                presenter.onSuccess();
            }else if (!name.equals(be.name)){
                presenter.onNameError();
            }else if (!psw.equals(be.psw)){
                presenter.onPswError();
            }
        }
    }

    /**
     * 模拟网络数据
     * @return
     */
    public User getBean(){
        User b = new User();
        b.name = "wang";
        b.psw  = "peng";
        return b;
    }

}