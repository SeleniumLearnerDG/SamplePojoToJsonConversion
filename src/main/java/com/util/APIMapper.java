package com.util;

public enum APIMapper {
     user_Detail("users/{userId}"),
    branch_Detail("repos/{userId}/{repo_name}/branches");

     private String endPoint;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    APIMapper(String s) {
        this.endPoint=s;
    }
}
