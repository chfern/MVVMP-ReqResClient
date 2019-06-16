package com.example.mvvmpreqresclient.base.activity;

import android.app.Activity;

import com.example.mvvmpreqresclient.activity.auth.UserActivity;
import com.example.mvvmpreqresclient.activity.auth.UserActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module (subcomponents = {
        UserActivityComponent.class
})
public abstract class UserActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey (UserActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideUserActivityInjector(UserActivityComponent.Builder builder);
}
