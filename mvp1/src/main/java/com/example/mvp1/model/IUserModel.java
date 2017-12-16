package com.example.mvp1.model;


public interface IUserModel {
    /**
     *  登录逻辑处理
     * @param username   用户名
     * @param password   密码
     * @param callBack   结果回调
     */
    void login(String username,String password,CallBack  callBack);
}
