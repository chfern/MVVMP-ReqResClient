package com.example.mvvmpreqresclient.base.application;

import android.app.Activity;
import android.app.Application;

import com.example.mvvmpreqresclient.BuildConfig;
import com.example.mvvmpreqresclient.base.activity.UserComponent;
import com.example.mvvmpreqresclient.base.activity.UserModule;
import com.example.mvvmpreqresclient.core.AuthStatus;
import com.example.mvvmpreqresclient.model.ReqResUser;
import com.example.mvvmpreqresclient.utils.NetworkModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class BaseApplication extends Application implements HasActivityInjector {
    BaseApplicationComponent applicationComponent;
    private UserComponent userComponent;
    
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    
    @Override
    public void onCreate () {
        super.onCreate();
        
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        initApplicationComponent();
    }
    
    private void initApplicationComponent(){
        this.applicationComponent = DaggerBaseApplicationComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .networkModule(new NetworkModule(null))
                .build();
        applicationComponent.inject(this);
        
    }
    
    @Override
    public AndroidInjector<Activity> activityInjector () {
        return activityDispatchingAndroidInjector;
    }
    
    public void login(ReqResUser reqResUser){
        this.applicationComponent = DaggerBaseApplicationComponent
                .builder()
                .networkModule(new NetworkModule(reqResUser.getToken()))
                .applicationContextModule(new ApplicationContextModule(this))
                .networkModule(new NetworkModule(reqResUser.getToken()))
                .build();
        this.userComponent = applicationComponent
                .authComponent()
                .userModule(new UserModule(reqResUser))
                .build();
        this.applicationComponent.inject(this);
        this.userComponent.inject(this);
    }

    public void logout(){
        this.userComponent = null;
    }

    public int getAuthStatus(){
        return this.userComponent == null ? AuthStatus.UNAUTHENTICATED : AuthStatus.AUTHENTICATED;
    }
}
