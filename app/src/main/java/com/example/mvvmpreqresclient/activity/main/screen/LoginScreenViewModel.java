package com.example.mvvmpreqresclient.activity.main.screen;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.model.LoginResponse;
import com.jakewharton.rxrelay2.BehaviorRelay;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class LoginScreenViewModel {
    BehaviorRelay<Boolean> loadingStateRelay = BehaviorRelay.create();
    BehaviorRelay<String> errorRelay = BehaviorRelay.create();
    BehaviorRelay<LoginResponse> loginResponseRelay = BehaviorRelay.create();
    
    @Inject
    LoginScreenViewModel(){
    
    }
    
    Observable<Boolean> loading(){
        return loadingStateRelay;
    }
    
    Observable<String> error(){
        return errorRelay;
    }
    Observable<LoginResponse> loginResponse(){
        return loginResponseRelay;
    }
    
    Consumer<Boolean> loadingUpdated(){
        return loadingStateRelay;
    }
    
    Consumer<LoginResponse> loginResponseUpdated(){
        return loginResponseRelay;
    }
    
    Consumer<Throwable> errorUpdated(){
        return throwable -> {
            Timber.e(throwable);
            errorRelay.accept("Login Failed");
        };
    }
}
