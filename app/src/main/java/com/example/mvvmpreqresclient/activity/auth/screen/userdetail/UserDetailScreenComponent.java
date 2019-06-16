package com.example.mvvmpreqresclient.activity.auth.screen.userdetail;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface UserDetailScreenComponent extends AndroidInjector<UserDetailScreen> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserDetailScreen>{
    
    }
}
