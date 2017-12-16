package com.example.mvp4.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp4.R;
import com.example.mvp4.presenter.Login2PresenterImpl;

public class Login2Activity extends AppCompatActivity implements Login2View {

    private android.widget.EditText login2zhanghao;
    private android.widget.EditText login2mima;
    private Login2PresenterImpl login2Presenter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        initViews();

        login2Presenter = new Login2PresenterImpl(this);//实现我们的PresenterImpl实现类
    }

    private void initViews() {
        this.login2mima = (EditText) findViewById(R.id.login2_mima);
        this.login2zhanghao = (EditText) findViewById(R.id.login2_zhanghao);
    }

    /**
     * 登陆按钮
     * @param v
     */
    public void login2Denglu(View v){
        login2Presenter.login();        //当我们点击登陆按钮的时候，调用一下PresenterImpl实现类中的login方法。
    }

    /**
     * 这里做提示
     * @param msg 我们所想提示的内容
     */
    @Override
    public void shouToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 在这做一个简单的登陆成功后的跳转
     */
    @Override
    public void onSuccess() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    /**
     * 对外提供获取用户输入的账号
     * @return
     */
    @Override
    public String getName() {
        return login2zhanghao.getText().toString();
    }

    /**
     * 对外提供获取用户输入的密码
     * @return
     */
    @Override
    public String getPassWord() {
        return login2mima.getText().toString();
    }
}
