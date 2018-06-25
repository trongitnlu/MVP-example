package com.example.nvtrong.mvp_example.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nvtrong.mvp_example.MainActivity;
import com.example.nvtrong.mvp_example.R;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupProgressLoading();
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void showProgess() {
        progressDialog.show();
    }

    @Override
    public void showMessage(String message) {
        hideProgess();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void hideProgess() {
        progressDialog.dismiss();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickLogin(View view) {
        String username = ((TextInputEditText) findViewById(R.id.txtUsername)).getText().toString();
        String password = ((TextInputEditText) findViewById(R.id.txtPassword)).getText().toString();
        loginPresenter.login(username, password);
    }

    public void setupProgressLoading() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Loading");
    }
}
