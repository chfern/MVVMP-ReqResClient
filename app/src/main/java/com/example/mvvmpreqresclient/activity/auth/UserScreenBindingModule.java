package com.example.mvvmpreqresclient.activity.auth;

import android.support.v4.app.Fragment;

import com.example.mvvmpreqresclient.activity.auth.screen.userdetail.UserDetailScreen;
import com.example.mvvmpreqresclient.activity.auth.screen.userdetail.UserDetailScreenComponent;
import com.example.mvvmpreqresclient.activity.auth.screen.users.UsersScreen;
import com.example.mvvmpreqresclient.activity.auth.screen.users.UsersScreenComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        UsersScreenComponent.class,
        UserDetailScreenComponent.class
})
public abstract class UserScreenBindingModule {
    @Binds
    @IntoMap
    @FragmentKey(UsersScreen.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindUsersScreen(UsersScreenComponent.Builder builder);
    
    @Binds
    @IntoMap
    @FragmentKey(UserDetailScreen.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindUserDetailScreen(UserDetailScreenComponent.Builder builder);
}
