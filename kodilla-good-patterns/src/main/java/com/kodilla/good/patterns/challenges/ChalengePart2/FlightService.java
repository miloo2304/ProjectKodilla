package com.kodilla.good.patterns.challenges.ChalengePart2;
import java.time.LocalDateTime;

public interface FlightService extends FindFlightFrom, FindFlightTo, FindFlightThrough {
    public boolean booked(Informations informations, LocalDateTime dateTime);
}
