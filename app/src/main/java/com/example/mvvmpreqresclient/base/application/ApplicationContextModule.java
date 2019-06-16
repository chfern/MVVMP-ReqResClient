package com.example.mvvmpreqresclient.base.application;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {
    Application application;
    
    ApplicationContextModule(Application application){
        this.application = application;
    }

    @Provides
    public Context provideApplicationContext(){
        return application.getApplicationContext();
    }
}
