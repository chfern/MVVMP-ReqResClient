package com.example.mvvmpreqresclient.base.activity;

import com.example.mvvmpreqresclient.model.ReqResUser;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
})
public class UserModule {
    private ReqResUser sessionUser;
    
    public UserModule(ReqResUser sessionUser){
        this.sessionUser = sessionUser;
    }
    
    @Provides
    public ReqResUser provideCurrentSessionUser(){
        return this.sessionUser;
    }
}
