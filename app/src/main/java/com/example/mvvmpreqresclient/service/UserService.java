package com.example.mvvmpreqresclient.service;

import com.example.mvvmpreqresclient.model.User;
import com.example.mvvmpreqresclient.model.UsersResponse;
import com.example.mvvmpreqresclient.utils.SingleEnvelopedResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET ("users")
    Single<UsersResponse> getUsers (@Query ("page") int page, @Query ("delay") int delay);
    
    @GET ("users/{id}")
    @SingleEnvelopedResponse
    Single<User> getUser (@Path ("id") int userId);
}