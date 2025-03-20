package com.kodilla.good.patterns.ChallengeFlight;
import java.util.List;


public interface FlightRepository {
    void addFlight(FlightDto flight);
    List<FlightDto> findFlightsFrom(String city);
    List<FlightDto> findFlightsVia(String departure, String via, String destination);
}