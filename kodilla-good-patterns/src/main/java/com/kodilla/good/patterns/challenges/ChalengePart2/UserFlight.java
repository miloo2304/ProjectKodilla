package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class UserFlight {
    private final String userName;
    private final String ID;
    private final String userEmail;

    public UserFlight(String userName, String ID, String email) {
        this.userName = userName;
        this.ID = ID;
        this.userEmail = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getID() {
        return ID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserFlight that)) return false;
        return Objects.equals(userName, that.userName) && Objects.equals(ID, that.ID) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, ID, userEmail);
    }
}
