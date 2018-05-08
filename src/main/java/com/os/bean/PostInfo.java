package com.os.bean;

import java.util.List;

public class PostInfo {
    private String code;
    private String name;
    private List<String> postUsers;

    public PostInfo() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPostUsers() {
        return this.postUsers;
    }

    public void setPostUsers(List<String> postUsers) {
        this.postUsers = postUsers;
    }
}
