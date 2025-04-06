package com.kodilla.good.patterns.ChallengeFlight;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Airport gdansk = new Airport("Gdansk");
        Airport wroclaw = new Airport("Wroclaw");
        Airport krakow = new Airport("Krakow");
        Airport lublin = new Airport("Lublin");
        Airport warszawa = new Airport("Warszawa");

        Flight flight1 = new Flight(gdansk, wroclaw, Arrays.asList(krakow), LocalDateTime.of(2023, 12, 1, 10, 30));
        Flight flight2 = new Flight(gdansk, krakow, Arrays.asList(), LocalDateTime.of(2023, 12, 1, 14, 45));
        Flight flight3 = new Flight(krakow, wroclaw, Arrays.asList(), LocalDateTime.of(2023, 12, 1, 16, 0));
        Flight flight4 = new Flight(gdansk, warszawa, Arrays.asList(), LocalDateTime.of(2023, 12, 1, 9, 0));
        Flight flight5 = new Flight(warszawa, lublin, Arrays.asList(), LocalDateTime.of(2023, 12, 1, 11, 30));

        Notification notificationSMS = new NotificationSMS();

        Set<Flight> flightsSet = new HashSet<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5));
        FlightRepository flightRepository = new FlightRepositoryManager();
        flightsSet.forEach(flightRepository::saveFlight);

        FlightManager flightManager = new FlightManager(flightsSet, notificationSMS, flightRepository);

        System.out.println("\nWe are looking for flights: ");
        flightManager.findFlights(gdansk, lublin, "123-456-789");

        System.out.println("\nAvailable flights: ");
        flightManager.displayFlights();
    }
}