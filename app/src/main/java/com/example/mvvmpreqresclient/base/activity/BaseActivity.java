package com.example.mvvmpreqresclient.base.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.mvvmpreqresclient.dagger.scope.ActivityScope;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

@ActivityScope
@SuppressLint ("Registered")
public class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;
    
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        
//        if(((BaseApplication) getApplicationContext()).getAuthStatus() == AuthStatus.UNAUTHENTICATED) {
//            Navigation.findNavController(this, R.id.main_nav_host_fragment).navigate();
//        }
        
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector () {
        return fragmentAndroidInjector;
    }
}
