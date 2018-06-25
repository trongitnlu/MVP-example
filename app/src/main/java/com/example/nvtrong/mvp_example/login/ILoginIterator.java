package com.example.nvtrong.mvp_example.login;

public interface ILoginIterator {
    interface OnLoginListener{
        void onLoginSuccess(String message);
        void onLoinFailed(String message);
    }

    void login(String username, String password, OnLoginListener onLoginListener);
}
