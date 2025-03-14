package com.kodilla.good.patterns.challenges.ChalengePart2;

import java.util.Objects;

public class AirPlane {
    private final String model;

    public AirPlane(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AirPlane airPlane)) return false;
        return Objects.equals(model, airPlane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }
}
