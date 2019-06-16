package com.example.mvvmpreqresclient.activity.main.screen;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface LoginScreenComponent extends AndroidInjector<LoginScreen> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginScreen>{
    
    }
}
