package com.kodilla.good.patterns.ChallengeFlight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class FlightRepositoryStreamer implements FlightRepository {
    private List<FlightDto> flights = new ArrayList<>();

    @Override
    public void addFlight(FlightDto flight) {
        flights.add(flight);
    }

    @Override
    public List<FlightDto> findFlightsFrom(String city) {
        return flights.stream()
                .filter(f -> f.getDeparture().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findFlightsVia(String departure, String via, String destination) {
        List<FlightDto> firstLeg = flights.stream()
                .filter(f -> f.getDeparture().equalsIgnoreCase(departure) && f.getDestination().equalsIgnoreCase(via))
                .collect(Collectors.toList());

        // Second leg: Flights from the via city to the destination city
        List<FlightDto> secondLeg = flights.stream()
                .filter(f -> f.getDeparture().equalsIgnoreCase(via) && f.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

        // Combine results into a single list containing matched flights
        List<FlightDto> result = new ArrayList<>();
        for (FlightDto leg1 : firstLeg) {
            for (FlightDto leg2 : secondLeg) {
                result.add(leg1);
                result.add(leg2);
            }
        }
        return result;
    }
}