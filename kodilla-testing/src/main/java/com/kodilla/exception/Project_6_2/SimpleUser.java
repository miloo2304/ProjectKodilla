package com.kodilla.exception.Project_6_2;

public class SimpleUser {
    private String username;
    private String realName;

    public SimpleUser(String username) {
        this.username = username;
    }

    public SimpleUser(String username, String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
