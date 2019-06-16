package com.example.mvvmpreqresclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqResUser {
    
    @SerializedName ("token")
    @Expose
    private String token;
    
    public String getToken () {
        return token;
    }
    
    public void setToken (String token) {
        this.token = token;
    }
    
    public ReqResUser withToken (String token) {
        this.token = token;
        return this;
    }
}