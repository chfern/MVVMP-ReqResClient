package com.example.mvvmpreqresclient.activity.auth.screen.users;

import android.annotation.SuppressLint;

import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;
import com.example.mvvmpreqresclient.repository.UserRepository;

import javax.inject.Inject;

@ScreenScope
public class UsersPresenter {
    private UserRepository userRepository;
    private UsersViewModel viewModel;
    
    @Inject
    public UsersPresenter(UserRepository userRepository, UsersViewModel viewModel){
        this.userRepository = userRepository;
        this.viewModel = viewModel;
    }
    
    @SuppressWarnings ("ResultOfMethodCallIgnored")
    @SuppressLint ("CheckResult")
    void loadUsers(int page){
        userRepository.getUsers(page)
                .doOnSubscribe(__ -> viewModel.updateLoading().accept(true))
                .doOnEvent((data, throwable) -> viewModel.updateLoading().accept(false))
                .doOnError(throwable -> {
                    viewModel.updateError().accept(throwable);
                })
                .subscribe(usersResponse -> {
                    viewModel.updateUsersResponse().accept(usersResponse);
                }, err -> {
                    // Logging is handled in viewmodel
                });
    }
}