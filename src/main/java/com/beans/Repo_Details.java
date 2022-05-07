package com.beans;

import java.util.ArrayList;
import java.util.List;

public class Repo_Details {
    private String name ;
    private String repo_owner ;
    private String repo_created_at;
    private  List<String> branches;

    public String getRepo_owner() {
        return repo_owner;
    }

    public void setRepo_owner(String repo_owner) {
        this.repo_owner = repo_owner;
    }

    public String getRepo_created_at() {
        return repo_created_at;
    }

    public void setRepo_created_at(String repo_created_at) {
        this.repo_created_at = repo_created_at;
    }

    public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }

    public String getName() {
        return name;
    }
    public Repo_Details()
    {}

    public Repo_Details(String name, String repo_owner, String repo_created_at, List<String> branches) {
        this.name = name;
        this.repo_owner = repo_owner;
        this.repo_created_at = repo_created_at;
        this.branches = branches;
    }

    public void setName(String name) {
        this.name = name;
    }
}
