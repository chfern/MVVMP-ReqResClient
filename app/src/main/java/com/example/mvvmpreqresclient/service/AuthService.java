package com.example.mvvmpreqresclient.service;

import com.example.mvvmpreqresclient.model.LoginRequest;
import com.example.mvvmpreqresclient.model.LoginResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("login")
    Single<LoginResponse> login(@Body LoginRequest loginRequest);
}
