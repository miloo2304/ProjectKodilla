package com.kodilla.good.patterns.ChallengeFlight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Flight {

    private Airport originAirport;
    private Airport destinationAirport;
    private List<Airport> transitAirport;
    private LocalDateTime departureTime;

    public Flight(Airport originAirport, Airport destinationAirport, List<Airport> transitAirport, LocalDateTime departureTime) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.transitAirport = transitAirport;
        this.departureTime = departureTime;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public List<Airport> getTransitAirport() {
        return transitAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return originAirport.equals(flight.originAirport) &&
                destinationAirport.equals(flight.destinationAirport) &&
                transitAirport.equals(flight.transitAirport) &&
                departureTime.equals(flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originAirport, destinationAirport, transitAirport, departureTime);
    }

    @Override
    public String toString() {
        return "Flight from: " + originAirport + " to: " + destinationAirport +
                (transitAirport.isEmpty() ? "" : " through: " + transitAirport) +
                " o'clock: " + departureTime;
    }
}