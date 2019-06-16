package com.example.mvvmpreqresclient.service;

import com.example.mvvmpreqresclient.dagger.qualifier.ReqResApiQualifier;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetrofitServiceModule {
    @Provides
    public AuthService provideAuthService(@ReqResApiQualifier Retrofit retrofit){
        return retrofit.create(AuthService.class);
    }
    
    @Provides
    public UserService provideUserService(@ReqResApiQualifier Retrofit retrofit){
        return retrofit.create(UserService.class);
    }
}
