package com.example.mvvmpreqresclient.activity.auth.screen.users;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface UsersScreenComponent extends AndroidInjector<UsersScreen> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UsersScreen>{
    
    }
}
