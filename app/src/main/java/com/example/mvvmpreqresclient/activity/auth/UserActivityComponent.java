package com.example.mvvmpreqresclient.activity.auth;

import com.example.mvvmpreqresclient.activity.main.MainActivity;
import com.example.mvvmpreqresclient.base.activity.BaseActivity;
import com.example.mvvmpreqresclient.dagger.scope.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ActivityScope
@Subcomponent(modules = {
        UserScreenBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface UserActivityComponent extends AndroidInjector<UserActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserActivity>{
    
    }
}
