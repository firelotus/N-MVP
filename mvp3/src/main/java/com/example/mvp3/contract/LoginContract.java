package com.example.mvp3.contract;

public class LoginContract {
    
    public interface Login1View{

        void showToast(String msg);

        void tiaoZhuan();

        String getName();

        String getPsw();
    }

    public interface Login1Presenter{

        void onNameError();

        void onPswError();

        void onSuccess();

        void onfail();
    }

    public interface Login1Model{
        void login(String name, String psw,Login1Presenter presenter);
    }
}