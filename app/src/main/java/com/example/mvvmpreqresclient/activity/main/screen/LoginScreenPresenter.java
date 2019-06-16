package com.example.mvvmpreqresclient.activity.main.screen;

import android.annotation.SuppressLint;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.model.LoginRequest;
import com.example.mvvmpreqresclient.repository.AuthRepository;

import javax.inject.Inject;

@ScreenScope
public class LoginScreenPresenter {
    private AuthRepository authRepository;
    private LoginScreenViewModel viewModel;
    
    @Inject
    public LoginScreenPresenter(AuthRepository authRepository, LoginScreenViewModel viewModel){
        this.authRepository = authRepository;
        this.viewModel = viewModel;
    }
    
    @SuppressLint ("CheckResult")
    public void login(LoginRequest loginRequest){
        authRepository.login(loginRequest)
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((data, throwable) -> {
                    viewModel.loadingUpdated().accept(false);
                })
                .doOnError(throwable -> {
                    viewModel.errorUpdated().accept(throwable);
                })
                .subscribe(loginResponse -> {
                    viewModel.loginResponseUpdated().accept(loginResponse);
                }, err -> {
                    // Handle logging in view model
                });
    }
}
