package com.example.mvp3.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp3.contract.LoginContract;
import com.example.mvp3.presenter.LoginPresenterImpl;
import com.example.mvp3.R;


public class Login1Activity extends AppCompatActivity implements LoginContract.Login1View{


    private android.widget.EditText zhanghao;
    private android.widget.EditText mima;

    private LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        initViews();

        loginPresenter = new LoginPresenterImpl(this);

    }

    private void initViews() {
        this.mima = (EditText) findViewById(R.id.mima);
        this.zhanghao = (EditText) findViewById(R.id.zhanghao);
    }

    /**
     * 登录按钮
     * @param v
     */
    public void denglu(View v){
        loginPresenter.login();
    }

    /**
     * 显示提示
     * @param msg 提示内容
     */
    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 登录成功开始跳转
     */
    @Override
    public void tiaoZhuan() {
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }

    /**
     * 获取到用户名
     * @return 返回获到的用户名
     */
    @Override
    public String getName() {
        return zhanghao.getText().toString();
    }

    /**
     * 获取EditText的密码
     * @return 返回获到的密码
     */
    @Override
    public String getPsw() {
        return mima.getText().toString();
    }
}
