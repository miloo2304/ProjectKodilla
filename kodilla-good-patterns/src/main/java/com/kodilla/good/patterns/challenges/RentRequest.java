package com.kodilla.good.patterns.challenges;
import java.time.LocalDateTime;

public class RentRequest {
    private final User user;
    private final LocalDateTime from;
    private final LocalDateTime to;

    public RentRequest(User user, LocalDateTime from, LocalDateTime to) {
        this.user = user;
        this.from = from;
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
