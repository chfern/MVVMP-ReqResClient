package com.example.mvvmpreqresclient.utils;

import com.example.mvvmpreqresclient.dagger.qualifier.ReqResApiQualifier;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private String authToken;
    
    public NetworkModule(String authToken){
        this.authToken = authToken;
    }
    
    @Provides
    @ReqResApiQualifier
    static OkHttpClient provideOkHttpClient (@Named ("reqres-header-token-interceptor") Interceptor headerTokenInterceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(headerTokenInterceptor);
        return builder.build();
    }
    
    @Provides
    @Named ("reqres-header-token-interceptor")
    Interceptor provideHeaderTokenInterceptor () {
        return chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "asd")
                    .build();
            return chain.proceed(newRequest);
        };
    }
    
    @Provides
    @ReqResApiQualifier
    static Retrofit provideRetrofit (@ReqResApiQualifier OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(SingleResponseEnvelopeConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        
        return builder.build();
    }
}
