package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class Airport {
    private final String airportName;
    private final String airportCode;

    public Airport(String airportName, String airportCode) {
        this.airportName = airportName;
        this.airportCode = airportCode;
    }
    public String getAirportName() {
        return airportName;
    }
    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Airport airport)) return false;
        return Objects.equals(airportName, airport.airportName) && Objects.equals(airportCode, airport.airportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportName, airportCode);
    }
}
