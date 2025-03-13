package com.kodilla.good.patterns.challenges.ChalengePart1;

public class User {
    private final String userName;
    private final String userAdress;
    private final String userEmail;

    public User(String userName, String adress, String email) {
        this.userName = userName;
        this.userAdress = adress;
        this.userEmail = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAdress() {
        return userAdress;
    }
}