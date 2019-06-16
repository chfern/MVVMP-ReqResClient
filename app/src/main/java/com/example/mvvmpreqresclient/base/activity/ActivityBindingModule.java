package com.example.mvvmpreqresclient.base.activity;

import android.app.Activity;

import com.example.mvvmpreqresclient.activity.main.MainActivity;
import com.example.mvvmpreqresclient.activity.main.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class,
        UserComponent.class,
})
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActiviyInjector(MainActivityComponent.Builder builder);
}
