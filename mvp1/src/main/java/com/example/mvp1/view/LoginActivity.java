package com.example.mvp1.view;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp1.R;
import com.example.mvp1.base.BaseMvpActivity;
import com.example.mvp1.model.UserModel;
import com.example.mvp1.presenter.LoginPresenter;
import com.example.mvp1.utils.PresenterFactory;
import com.example.mvp1.utils.PresenterLoder;



public class LoginActivity extends BaseMvpActivity<LoginPresenter, LoginView> implements LoginView, View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 创建LoginPresenter实例
     * @param id
     * @param args
     * @return
     */
    @Override
    public Loader<LoginPresenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoder<>(this, new PresenterFactory<LoginPresenter>() {
            @Override
            public LoginPresenter crate() {
                return new LoginPresenter(new UserModel());
            }
        });
    }

    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password.getText().toString().trim();
    }

    @Override
    public void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                presenter.login();//登录操作
                break;
        }
    }


}
