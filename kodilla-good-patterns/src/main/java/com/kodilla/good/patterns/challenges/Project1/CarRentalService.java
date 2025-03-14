package com.kodilla.good.patterns.challenges.Project1;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {
    @Override
    public boolean rent(User1 user1, LocalDateTime from, LocalDateTime to) {
        System.out.println("Renting car for: " + user1.getName() + " from " + from + " to " + to);
        return true;
    }
}
