package com.example.mvvmpreqresclient.base.activity;

import com.example.mvvmpreqresclient.base.application.BaseApplication;
import com.example.mvvmpreqresclient.dagger.scope.UserScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
        UserModule.class,
        UserActivityBindingModule.class
})
@UserScope
public interface UserComponent extends AndroidInjector<BaseApplication> {
    
    @Subcomponent.Builder
    interface Builder {
        Builder userModule(UserModule userModule);
        UserComponent build();
    }
}
