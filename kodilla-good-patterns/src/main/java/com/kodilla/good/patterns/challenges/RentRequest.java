package com.kodilla.good.patterns.challenges;
import java.time.LocalDateTime;

public class RentRequest {
    private final User1 user1;
    private final LocalDateTime from;
    private final LocalDateTime to;

    public RentRequest(User1 user1, LocalDateTime from, LocalDateTime to) {
        this.user1 = user1;
        this.from = from;
        this.to = to;
    }

    public User1 getUser() {
        return user1;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
