package com.kodilla.good.patterns.challenges.Project1;

public class RentalDto {
    private final User1 user1;
    private final boolean isRented;

    public RentalDto(User1 user1, boolean isRented) {
        this.user1 = user1;
        this.isRented = isRented;
    }

    public User1 getUser() {
        return user1;
    }

    public boolean isRented() {
        return isRented;
    }
}
