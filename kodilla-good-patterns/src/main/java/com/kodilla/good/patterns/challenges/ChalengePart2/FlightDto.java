package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class FlightDto {
    private final Informations informations;
    private final boolean isAvailable;

    public FlightDto(Informations informations, boolean isAvailable) {
        this.informations = informations;
        this.isAvailable = isAvailable;
    }

    public Informations getInformations() {
        return informations;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FlightDto flightDto)) return false;
        return isAvailable == flightDto.isAvailable && Objects.equals(informations, flightDto.informations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informations, isAvailable);
    }
}
