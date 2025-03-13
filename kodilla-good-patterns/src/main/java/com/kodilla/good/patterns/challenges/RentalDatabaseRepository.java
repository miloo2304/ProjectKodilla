package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class RentalDatabaseRepository implements RentalRepository {
    @Override
    public void createRental(User user, LocalDateTime from, LocalDateTime to) {
        System.out.println("Creating rental record for: " + user.getName() + " from " + from + " to " + to);
    }
}
