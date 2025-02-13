package com.kodilla.stream.Project_7_4.WholeWorld;
import java.util.*;

public class Continent {

    private final String name;
    private final List<Inter> countries;

    public Continent(String name, List<Inter> countries) {
        this.name = name;
        this.countries = countries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name) && Objects.equals(countries, continent.countries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countries);
    }

    public List<Inter> getCountries() {
        return countries;
    }

}
