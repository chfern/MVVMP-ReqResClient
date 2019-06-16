package com.example.mvvmpreqresclient.activity.main;

import android.support.v4.app.Fragment;

import com.example.mvvmpreqresclient.activity.main.screen.LoginScreen;
import com.example.mvvmpreqresclient.activity.main.screen.LoginScreenComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
    LoginScreenComponent.class
})
public abstract class MainScreenBindingModule {
    @Binds
    @IntoMap
    @FragmentKey (LoginScreen.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindLoginScreenInjector(LoginScreenComponent.Builder builder);
}
