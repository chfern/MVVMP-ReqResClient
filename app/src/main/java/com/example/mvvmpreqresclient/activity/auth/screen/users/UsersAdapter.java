package com.example.mvvmpreqresclient.activity.auth.screen.users;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmpreqresclient.R;
import com.example.mvvmpreqresclient.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private List<User> users = new ArrayList<>();
    private final OnItemClickListener onItemClickListener;
    
    public UsersAdapter(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
        setHasStableIds(true);
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_users, viewGroup, false);
        return new ViewHolder(view, onItemClickListener);
    }
    
    @Override
    public void onBindViewHolder (@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(users.get(i));
    }
    
    @Override
    public int getItemCount () {
        return users.size();
    }
    
    public void setData(List<User> newUsers){
        if(users != null){
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserDiffCallback(users, newUsers));
            users.clear();
            users.addAll(newUsers);
            diffResult.dispatchUpdatesTo(this);
        }
        else{
            users.clear();
            notifyDataSetChanged();
        }
    }
    
    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_username) TextView tvUsername;
        private User user;
        
        public ViewHolder (@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    if(user != null){
                        onItemClickListener.onClick(user);
                    }
                }
            });
        }
        
        void bind(User user){
            this.user = user;
            
            tvUsername.setText(user.getFirstName());
        }
    }
    
    interface OnItemClickListener{
        void onClick(User user);
    }
}
