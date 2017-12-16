package com.example.mvp2.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp2.R;
import com.example.mvp2.model.UserModel;
import com.example.mvp2.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = initPresenter();//初始化presenter
    }
    public LoginPresenter initPresenter() {
        return new LoginPresenter(new UserModel(), this);
    }
    @Override
    public void showLoding(String msg) {
        progressDialog.setMessage(msg);
        if(!progressDialog.isShowing())
             progressDialog.show();
    }
    @Override
    public void hideLoding() {
       if(progressDialog.isShowing())
           progressDialog.dismiss();
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
    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (loginPresenter != null) {
            loginPresenter = null;
        }
        super.onDestroy();
    }
    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        progressDialog =new ProgressDialog(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                 loginPresenter.login();//loginPresenter的login
                break;
        }
    }
}
