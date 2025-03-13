package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class RentalDatabaseRepository implements RentalRepository {
    @Override
    public void createRental(User1 user1, LocalDateTime from, LocalDateTime to) {
        System.out.println("Creating rental record for: " + user1.getName() + " from " + from + " to " + to);
    }
}
