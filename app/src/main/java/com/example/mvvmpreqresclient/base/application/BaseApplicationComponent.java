package com.example.mvvmpreqresclient.base.application;

import com.example.mvvmpreqresclient.base.activity.ActivityBindingModule;
import com.example.mvvmpreqresclient.base.activity.UserComponent;
import com.example.mvvmpreqresclient.service.RetrofitServiceModule;
import com.example.mvvmpreqresclient.utils.NetworkModule;
import javax.inject.Singleton;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        ApplicationContextModule.class,
        ActivityBindingModule.class,
        AndroidInjectionModule.class,
        NetworkModule.class,
        
        // Services & Repositories
        RetrofitServiceModule.class
})
public interface BaseApplicationComponent extends AndroidInjector<BaseApplication> {
    UserComponent.Builder authComponent();
    
    @Component.Builder
    interface Builder {
        Builder applicationContextModule(ApplicationContextModule applicationContextModule);
        Builder networkModule(NetworkModule networkModule);
        BaseApplicationComponent build();
    }
}