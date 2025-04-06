package com.kodilla.good.patterns.ChallengeFlight;

import java.util.List;

public interface FlightRepository {
    void saveFlight(Flight flight);
    List<Flight> getAllFlights();
}
