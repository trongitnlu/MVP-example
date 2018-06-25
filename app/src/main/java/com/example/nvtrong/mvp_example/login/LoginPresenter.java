package com.example.nvtrong.mvp_example.login;

public class LoginPresenter implements ILoginIterator.OnLoginListener {
    ILoginView loginView;
    ILoginIterator loginIterator;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        loginIterator = new LoginInterator();
    }

    @Override
    public void onLoginSuccess(String message) {
        loginView.showMessage(message);
        loginView.hideProgess();
        loginView.startMainActivity();
    }

    @Override
    public void onLoinFailed(String message) {
        loginView.showMessage(message);
        loginView.hideProgess();
    }

    public void login(String username, String password) {
        loginView.showProgess();
        loginIterator.login(username, password, this);
    }
}
