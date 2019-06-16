package com.example.mvvmpreqresclient.activity.auth.screen.users;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.model.UsersResponse;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

@ScreenScope
public class UsersViewModel {
    private BehaviorRelay<UsersResponse> usersResponseRelay = BehaviorRelay.create();
    private BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();
    private BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    
    @Inject
    public UsersViewModel(){
    
    }
    
    Consumer<UsersResponse> updateUsersResponse(){
        return usersResponseRelay;
    }
    
    Consumer<Boolean> updateLoading(){
        return loadingRelay;
    }
    
    Consumer<Throwable> updateError(){
        return throwable -> {
            Timber.e(throwable);
            errorRelay.accept(R.string.api_users_load_error);
        };
    }
    
    public Observable<UsersResponse> usersResponse(){
        return usersResponseRelay;
    }
    
    public Observable<Boolean> loading(){
        return loadingRelay;
    }
    
    public Observable<Integer> error(){
        return errorRelay;
    }
}
