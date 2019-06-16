package com.example.mvvmpreqresclient.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.activity.auth.UserActivity;
import com.example.mvvmpreqresclient.base.activity.BaseActivity;
import com.example.mvvmpreqresclient.base.application.BaseApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity {
    
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        startActivity(new Intent(this, UserActivity.class));
    }
}