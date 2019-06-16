package com.example.mvvmpreqresclient.base.screen;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

@ScreenScope
public abstract class BaseScreen extends Fragment {
    CompositeDisposable disposables = new CompositeDisposable();
    
    @LayoutRes
    protected abstract int layoutRes();
    
    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        
        View view = inflater.inflate(layoutRes(), container, false);
        ButterKnife.bind(this, view);
        
        onViewBound(view);
        return view;
    }
    
    protected abstract void onViewBound(View view);
    
    public void addDisposable(Disposable disposable){
        disposables.add(disposable);
    }
    
    @Override
    public void onDestroy () {
        disposables.dispose();
        super.onDestroy();
    }
}
