package com.example.mvvmpreqresclient.activity.auth;

import android.os.Bundle;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.base.activity.BaseActivity;

public class UserActivity extends BaseActivity {
//    @Inject ReqResUser githubUser;
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        
//        if(githubUser == null) {
//            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "not null", Toast.LENGTH_SHORT).show();
//        }
    }
}
