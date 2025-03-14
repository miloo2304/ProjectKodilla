package com.kodilla.good.patterns.challenges.Project1;

import java.time.LocalDateTime;

public interface RentalRepository {
    void createRental(User1 user1, LocalDateTime from, LocalDateTime to);
}
