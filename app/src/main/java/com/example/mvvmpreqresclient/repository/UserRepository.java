package com.example.mvvmpreqresclient.repository;

import com.example.mvvmpreqresclient.model.User;
import com.example.mvvmpreqresclient.model.UsersResponse;
import com.example.mvvmpreqresclient.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class UserRepository {
    private UserService userService;
    
    // Key: UserID, Value: Actual User
    private Map<Integer, User> userCache = new HashMap<>();
    
    @Inject
    public UserRepository (UserService userService) {
        this.userService = userService;
    }
    
    public Single<UsersResponse> getUsers (int page) {
        return userService.getUsers(page, 5)
                .subscribeOn(Schedulers.io());
    }
    
    public Single<User> getUser (int id) {
        return Maybe.concat(getCachedUser(id), getApiUser(id))
                .firstOrError()
                .subscribeOn(Schedulers.io());
    }
    
    public Maybe<User> getCachedUser (int id) {
        return Maybe.create(emitter -> {
            if (userCache.containsKey(id)) {
                emitter.onSuccess(userCache.get(id));
            }
            emitter.onComplete();
        });
    }
    
    public Maybe<User> getApiUser(int id){
        return userService.getUser(id)
                .doOnSuccess(user -> {
                    userCache.put(id, user);
                })
                .toMaybe();
    }
}