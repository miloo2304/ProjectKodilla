package com.kodilla.stream.Project_7_4.WholeWorld;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class World {
    private final List<Continent> continents;

    public World(List<Continent> continents) {
        this.continents = continents;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        World world = (World) o;
        return Objects.equals(continents, world.continents);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(continents);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Inter::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}