package com.example.mvvmpreqresclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {
    @SerializedName ("page")
    @Expose
    private Integer page;
    @SerializedName ("per_page")
    @Expose
    private Integer perPage;
    @SerializedName ("total")
    @Expose
    private Integer total;
    @SerializedName ("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName ("data")
    @Expose
    private List<User> users;
    
    public Integer getPage () {
        return page;
    }
    
    public Integer getPerPage () {
        return perPage;
    }
    
    public Integer getTotal () {
        return total;
    }
    
    public Integer getTotalPages () {
        return totalPages;
    }
    
    public List<User> getUsers () {
        return users;
    }
    
    public UsersResponse withPage (Integer page) {
        this.page = page;
        return this;
    }
    
    public UsersResponse withPerPage (Integer perPage) {
        this.perPage = perPage;
        return this;
    }
    
    public UsersResponse withTotal (Integer total) {
        this.total = total;
        return this;
    }
    
    public UsersResponse withTotalPages (Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }
    
    public UsersResponse withUsers (List<User> users) {
        this.users = users;
        return this;
    }
}
