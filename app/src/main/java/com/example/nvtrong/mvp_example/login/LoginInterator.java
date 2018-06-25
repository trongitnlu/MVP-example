package com.example.nvtrong.mvp_example.login;


import android.os.Handler;
import android.text.TextUtils;

public class LoginInterator implements ILoginIterator {

    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username) || username.equals("")) {
                    onLoginListener.onLoinFailed("Username not empty!");
                    return;
                } else if (TextUtils.isEmpty(password) || password.equals("")) {
                    onLoginListener.onLoinFailed("Password not empty!");
                    return;
                } else {
                    onLoginListener.onLoginSuccess("Login success!");
                    return;
                }

            }
        }, 1500);
    }
}
