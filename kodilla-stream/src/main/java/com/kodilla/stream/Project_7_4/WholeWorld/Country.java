package com.kodilla.stream.Project_7_4.WholeWorld;

import java.math.BigDecimal;
import java.util.Objects;

public class Country implements Inter {
    private final String name;
    private final BigDecimal peopleQuantity;

    public Country(String name, BigDecimal peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(peopleQuantity, country.peopleQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, peopleQuantity);
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }
}