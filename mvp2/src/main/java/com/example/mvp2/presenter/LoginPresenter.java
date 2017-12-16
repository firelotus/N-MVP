package com.example.mvp2.presenter;


import com.example.mvp2.model.CallBack;
import com.example.mvp2.model.UserModel;
import com.example.mvp2.view.LoginView;

public class LoginPresenter {
    private UserModel userModel;//model层具体实现类
    private LoginView loginView;//loginView接口

    public LoginPresenter(UserModel userModel, LoginView loginView) {
        this.userModel = userModel;
        this.loginView = loginView;
    }
    public void login(){
        loginView.showLoding("正在登录中...");//loginView的ui逻辑处理
        userModel.login(loginView.getUsername(), loginView.getPassword(), new CallBack() {
            @Override
            public void onSuccess() {
                loginView.hideLoding();
                loginView.showResult("登录成功");
            }

            @Override
            public void onFilure(String fail) {
                loginView.hideLoding();
                loginView.showErr(fail);
            }
        });
    }
}
