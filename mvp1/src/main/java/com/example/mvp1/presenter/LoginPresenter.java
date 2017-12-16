package com.example.mvp1.presenter;


import com.example.mvp1.base.BaseMvpPresenter;
import com.example.mvp1.model.CallBack;
import com.example.mvp1.model.UserModel;
import com.example.mvp1.view.LoginView;

public class LoginPresenter extends BaseMvpPresenter<LoginView> implements ILoginPresenter {
    private UserModel userModel;//model层具体实现类

    public LoginPresenter(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public void login() {
        checkViewAttach();//检查是否绑定
        final LoginView loginView=getMvpView();//获得LoginView
        loginView.showLoding("正在登录中...");//loginView的ui逻辑处理
        userModel.login(loginView.getUsername(), loginView.getPassword(), new CallBack() {
            @Override
            public void onSuccess() {
                loginView.hideLoding();
                loginView.showResult("登录成功");
            }

            @Override
            public void onFailure(String fail) {
                loginView.hideLoding();
                loginView.showResult(fail);
            }
        });
    }
}
