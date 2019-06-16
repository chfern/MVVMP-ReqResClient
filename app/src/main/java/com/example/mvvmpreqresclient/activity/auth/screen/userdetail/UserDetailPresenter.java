package com.example.mvvmpreqresclient.activity.auth.screen.userdetail;

import android.annotation.SuppressLint;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.repository.UserRepository;

import javax.inject.Inject;

@ScreenScope
public class UserDetailPresenter {
    @Inject UserDetailViewModel viewModel;
    @Inject UserRepository userRepository;
    
    @Inject
    UserDetailPresenter(UserDetailViewModel viewModel, UserRepository userRepository){
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }
    
    @SuppressWarnings ("ResultOfMethodCallIgnored")
    @SuppressLint ("CheckResult")
    void loadUserDetail(int id){
        userRepository.getUser(id)
                .doOnSubscribe(__ -> viewModel.updateLoading().accept(true))
                .doOnEvent((data, throwable) -> viewModel.updateLoading().accept(false))
                .doOnError(throwable -> {
                    viewModel.updateError().accept(throwable);
                })
                .subscribe(user -> {
                    viewModel.updateUser().accept(user);
                }, throwable -> {
                    viewModel.updateError().accept(throwable);
                });
    }
}
