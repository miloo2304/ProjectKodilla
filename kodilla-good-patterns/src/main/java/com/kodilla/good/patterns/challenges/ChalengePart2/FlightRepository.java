package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.List;

public interface FlightRepository {
    void addFlight(Flight flight);
    List<Flight> getAllFlights();
}
