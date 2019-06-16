package com.example.mvvmpreqresclient.activity.auth.screen.users;

import android.support.v7.util.DiffUtil;

import com.example.mvvmpreqresclient.model.User;

import java.util.List;

public class UserDiffCallback extends DiffUtil.Callback {
    private final List<User> oldList;
    private final List<User> newList;
    
    public UserDiffCallback (List<User> oldList, List<User> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }
    
    @Override
    public int getOldListSize () {
        return oldList.size();
    }
    
    @Override
    public int getNewListSize () {
        return newList.size();
    }
    
    @Override
    public boolean areItemsTheSame (int i, int i1) {
        return oldList.get(i).getId().equals(newList.get(i1).getId());
    }
    
    @Override
    public boolean areContentsTheSame (int i, int i1) {
        return oldList.get(i).equals(newList.get(i1));
    }
}
