package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class FlightCompany {
    private final String flightCompanyName;
    private final String flightCompanyAddress;

    public FlightCompany(String flightCompanyName, String flightCompanyAddress) {
        this.flightCompanyName = flightCompanyName;
        this.flightCompanyAddress = flightCompanyAddress;
    }

    public String getFlightCompanyAddress() {
        return flightCompanyAddress;
    }

    public String getFlightCompanyName() {
        return flightCompanyName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FlightCompany that)) return false;
        return Objects.equals(flightCompanyName, that.flightCompanyName) && Objects.equals(flightCompanyAddress, that.flightCompanyAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightCompanyName, flightCompanyAddress);
    }
}
