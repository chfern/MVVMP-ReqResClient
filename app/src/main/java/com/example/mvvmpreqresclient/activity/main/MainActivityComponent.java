package com.example.mvvmpreqresclient.activity.main;

import com.example.mvvmpreqresclient.activity.auth.UserScreenBindingModule;
import com.example.mvvmpreqresclient.base.activity.BaseActivity;
import com.example.mvvmpreqresclient.dagger.scope.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        AndroidSupportInjectionModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{
    
    }
}
