package com.kodilla.good.patterns.ChallengeFlight;


import java.util.ArrayList;
import java.util.List;

public class FlightRepositoryManager implements FlightRepository {

    private final List<Flight> flights = new ArrayList<>();

    @Override
    public void saveFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight saved: " + flight);
    }

    @Override
    public List<Flight> getAllFlights() { // we can use if we need
        return new ArrayList<>(flights);
    }
}