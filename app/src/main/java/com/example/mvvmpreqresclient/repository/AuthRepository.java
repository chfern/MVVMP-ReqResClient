package com.example.mvvmpreqresclient.repository;


import com.example.mvvmpreqresclient.model.LoginRequest;
import com.example.mvvmpreqresclient.model.LoginResponse;
import com.example.mvvmpreqresclient.service.AuthService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class AuthRepository {
    private AuthService authService;
    
    @Inject
    AuthRepository (AuthService authService) {
        this.authService = authService;
    }
    
    public Single<LoginResponse> login (LoginRequest loginRequest) {
        return authService.login(loginRequest)
                .subscribeOn(Schedulers.io());
    }
}
