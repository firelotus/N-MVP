package com.example.mvp3.presenter;


import com.example.mvp3.contract.LoginContract;
import com.example.mvp3.model.LoginModelImpl;

public class LoginPresenterImpl implements LoginContract.Login1Presenter{

    private LoginContract.Login1View Loginview;
    private LoginContract.Login1Model LoginModel;

    public LoginPresenterImpl(LoginContract.Login1View loginview) {
        Loginview = loginview;
        LoginModel = new LoginModelImpl();
    }

    public void login(){
        String name = Loginview.getName();
        String psw = Loginview.getPsw();
        LoginModel.login(name,psw,this);
    }

    @Override
    public void onNameError() {
        Loginview.showToast("帐号错误");
    }

    @Override
    public void onPswError() {
        Loginview.showToast("密码错误");
    }

    @Override
    public void onSuccess() {
        Loginview.tiaoZhuan();
    }

    @Override
    public void onfail() {
        Loginview.showToast("帐号密码不能为空");
    }
}