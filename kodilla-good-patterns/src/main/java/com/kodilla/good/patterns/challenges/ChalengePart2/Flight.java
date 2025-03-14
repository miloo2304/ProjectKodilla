package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class Flight {
    private final String fromCity;
    private final String toCity;
    private final String flightNumber;

    public Flight(String fromCity, String toCity, String flightNumber) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightNumber = flightNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(fromCity, flight.fromCity) && Objects.equals(toCity, flight.toCity) && Objects.equals(flightNumber, flight.flightNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCity, toCity, flightNumber);
    }
}
