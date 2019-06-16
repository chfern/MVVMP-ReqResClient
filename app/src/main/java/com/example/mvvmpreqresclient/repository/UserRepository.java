package com.example.mvvmpreqresclient.repository;

import com.example.mvvmpreqresclient.model.User;
import com.example.mvvmpreqresclient.model.UsersResponse;
import com.example.mvvmpreqresclient.service.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class UserRepository {
    private UserService userService;
    
    @Inject
    public UserRepository(UserService userService){
        this.userService = userService;
    }
    
    public Single<UsersResponse> getUsers(int page){
        return userService.getUsers(page, 5)
                .subscribeOn(Schedulers.io());
    }
    
    public Single<User> getUser(int id){
        return userService.getUser(id)
                .subscribeOn(Schedulers.io());
    }
}