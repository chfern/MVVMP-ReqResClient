package com.example.mvvmpreqresclient.activity.auth.screen.users;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.activity.auth.screen.userdetail.UserDetailScreen;
import com.example.mvvmpreqresclient.base.screen.BaseScreen;
import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

@ScreenScope
public class UsersScreen extends BaseScreen {
    @BindView (R.id.list_users) RecyclerView usersRecyclerView;
    @BindView (R.id.progress_circular) ProgressBar progressBar;
    
    @Inject UsersPresenter usersPresenter;
    @Inject UsersViewModel usersViewModel;
    
    private UsersAdapter usersAdapter;
    
    @Override
    protected int layoutRes () {
        return R.layout.screen_users;
    }
    
    private void setupUsersRecyclerView(){
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        usersAdapter = new UsersAdapter(user -> {
            Navigation.findNavController(getView()).navigate(R.id.action_usersScreen_to_userDetailScreen,
                    UserDetailScreen.args(user.getId()));
        });
        usersRecyclerView.setAdapter(usersAdapter);
    }
    
    @Override
    protected void onViewBound (View view) {
        setupUsersRecyclerView();
        usersPresenter.loadUsers(1);
        addDisposable(usersViewModel.loading()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading -> {
                    progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
                    usersRecyclerView.setVisibility(loading ? View.GONE : View.VISIBLE);
                }));
        addDisposable(usersViewModel.error()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(errorRes -> Toast.makeText(getContext(), getActivity().getString(errorRes), Toast.LENGTH_SHORT).show()));
        addDisposable(usersViewModel.usersResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(usersResponse -> usersAdapter.setData(usersResponse.getUsers())));
    }
}
