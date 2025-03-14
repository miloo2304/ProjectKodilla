package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.List;
import java.util.stream.Collectors;

public class InformationProcessor {//implements FlightService {
    /*
    private final FlightRepository flightRepository;

    public InformationProcessor(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findFlightsFromCity(String fromCity) {
        return flightRepository.getAllFlights().stream()
                .filter(flight -> flight.getFromCity().equalsIgnoreCase(fromCity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsToCity(String toCity) {
        return flightRepository.getAllFlights().stream()
                .filter(flight -> flight.getToCity().equalsIgnoreCase(toCity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsThroughCity(String throughCity) {
        return flightRepository.getAllFlights().stream()
                .filter(flight -> flight.getFromCity().equalsIgnoreCase(throughCity) ||
                        flight.getToCity().equalsIgnoreCase(throughCity))
                .collect(Collectors.toList());
    }

     */
}
