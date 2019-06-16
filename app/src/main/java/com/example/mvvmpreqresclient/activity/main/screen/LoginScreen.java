package com.example.mvvmpreqresclient.activity.main.screen;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.activity.auth.UserActivity;
import com.example.mvvmpreqresclient.base.application.BaseApplication;
import com.example.mvvmpreqresclient.base.screen.BaseScreen;
import com.example.mvvmpreqresclient.model.LoginRequest;
import com.example.mvvmpreqresclient.model.ReqResUser;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.Binds;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class LoginScreen extends BaseScreen {
    @Inject LoginScreenPresenter presenter;
    @Inject LoginScreenViewModel viewModel;
    
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.textinput_password) TextInputLayout password;
    @BindView(R.id.textinput_username) TextInputLayout username;
    
    @Override
    protected int layoutRes () {
        return R.layout.screen_login;
    }
    
    @Override
    protected void onViewBound (View view) {
        Toast.makeText(view.getContext(), "asdasd", Toast.LENGTH_SHORT).show();
        
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("eve.holt@reqres.in");
        loginRequest.setPassword("cityslicka");
        presenter.login(loginRequest);
        
        addDisposable(viewModel.loading()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading -> {
                    btnLogin.setEnabled(!loading);
                    username.setEnabled(!loading);
                    password.setEnabled(!loading);
                }));
        
        addDisposable(viewModel.error()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(err -> {
                    Toast.makeText(view.getContext(), err, Toast.LENGTH_SHORT).show();
                }));
        
        addDisposable(viewModel.loginResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginResponse -> {
                    ((BaseApplication) getContext().getApplicationContext()).login(new ReqResUser()
                            .withToken(loginResponse.getToken()));
                    Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_userActivity);
                    getActivity().finish();
                }));
    }
}