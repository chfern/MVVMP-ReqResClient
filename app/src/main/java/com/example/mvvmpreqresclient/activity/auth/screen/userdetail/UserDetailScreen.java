package com.example.mvvmpreqresclient.activity.auth.screen.userdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.base.screen.BaseScreen;
import com.example.mvvmpreqresclient.dagger.scope.ScreenScope;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

@ScreenScope
public class UserDetailScreen extends BaseScreen {
    private static final String BUNDLE_USERID = "bundle_userid";
    
    @Inject UserDetailPresenter presenter;
    @Inject UserDetailViewModel viewModel;
    
    @BindView(R.id.tv_email) TextView tvEmail;
    @BindView(R.id.tv_firstname) TextView tvFirstName;
    @BindView(R.id.tv_lastname) TextView tvLastName;
    
    @Override
    protected int layoutRes () {
        return R.layout.screen_user_detail;
    }
    
    @Override
    protected void onViewBound (View view) {
        int id = getArguments().getInt(BUNDLE_USERID);
        presenter.loadUserDetail(id);
        addDisposable(viewModel.loading().observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading -> {
                    Toast.makeText(getContext(), loading ? "Loading" : "Finished", Toast.LENGTH_SHORT).show();
                }));
        addDisposable(viewModel.error().observeOn(AndroidSchedulers.mainThread())
                .subscribe(errorRes -> Toast.makeText(getContext(), getContext().getString(errorRes), Toast.LENGTH_SHORT).show()));
        addDisposable(viewModel.user().observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    tvEmail.setText(user.getEmail());
                    tvFirstName.setText(user.getFirstName());
                    tvLastName.setText(user.getLastName());
                }));
    }
    
    public static Bundle args (int userId) {
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_USERID, userId);
        return bundle;
    }
}
