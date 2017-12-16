package com.example.mvp4.model;


public class Login2ModelImpl implements Login2Model {

    @Override
    public void login(String name, String psw, com.example.mvp4.presenter.Login2Presenter login2Presenter) {

        /**
         * 这里我只是对数据做一个简单的判断，大神勿喷。
         */
        UserBean ub = getBean();
        if (name.isEmpty() || psw.isEmpty()){
            login2Presenter.onfail("账号密码不能为空");
        }else if (name.equals(ub.accountNumber) && psw.equals(ub.password)){
            login2Presenter.onSuccess();
        }else {
            login2Presenter.onfail("账号密码错误");
        }
    }


    /**
     * 模拟数据账号和密码，【其实大可不必这样写，你也可以直接定义两个String值就好了】
     * @return
     */
    public UserBean getBean(){
        UserBean bean = new UserBean();
        bean.accountNumber = "zhangsan";
        bean.password = "123456";
        return bean;
    }

    /**
     * 这里就先模拟一下网络数据,定义一下账号和密码
     */
    public class UserBean{
        public String accountNumber ;
        public String password;
    }
}