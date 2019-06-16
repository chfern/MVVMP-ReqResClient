package com.example.mvvmpreqresclient.activity.auth.screen.userdetail;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.model.User;
import com.jakewharton.rxrelay2.BehaviorRelay;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class UserDetailViewModel {
    private BehaviorRelay<User> userRelay = BehaviorRelay.create();
    private BehaviorRelay<Boolean> loadingRelay= BehaviorRelay.create();
    private BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    
    
    @Inject
    public UserDetailViewModel(){
    
    }
    
    public Consumer<User> updateUser(){
        return userRelay;
    }
    
    public Consumer<Boolean> updateLoading(){
        return loadingRelay;
    }
    
    public Consumer<Throwable> updateError(){
        return throwable -> {
            Timber.e(throwable);
            errorRelay.accept(R.string.api_user_load_error);
        };
    }
    
    public Observable<User> user(){
        return userRelay;
    }
    
    public Observable<Boolean> loading(){
        return loadingRelay;
    }
    
    public Observable<Integer> error(){
        return errorRelay;
    }
}
