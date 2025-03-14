package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class Informations {
    private final UserFlight userFlight;
    private final AirPlane airPlane;
    private final Airport airport;
    private final FlightCompany flightCompany;
    private final Flight flight;

    public Informations(UserFlight userFlight, AirPlane airPlane, Airport airport, FlightCompany flightCompany, Flight flight) {
        this.userFlight = userFlight;
        this.airPlane = airPlane;
        this.airport = airport;
        this.flightCompany = flightCompany;
        this.flight = flight;
    }

    public UserFlight getUserFlight() {
        return userFlight;
    }

    public AirPlane getAirPlane() {
        return airPlane;
    }

    public Airport getAirport() {
        return airport;
    }

    public FlightCompany getFlightCompany() {
        return flightCompany;
    }

    public Flight getFlight() {
        return flight;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Informations that)) return false;
        return Objects.equals(userFlight, that.userFlight) && Objects.equals(airPlane, that.airPlane) && Objects.equals(airport, that.airport) && Objects.equals(flightCompany, that.flightCompany) && Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userFlight, airPlane, airport, flightCompany, flight);
    }
}
