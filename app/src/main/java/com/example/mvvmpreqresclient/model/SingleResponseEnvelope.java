package com.example.mvvmpreqresclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleResponseEnvelope<T> {
    @SerializedName ("data")
    @Expose
    T data;
    
    public T getData () {
        return data;
    }
    
    public SingleResponseEnvelope<T> withData (T data) {
        this.data = data;
        return this;
    }
}
