package com.kodilla.good.patterns.ChallengeFlight;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightManager {
    private final Set<Flight> flightsSet;
    private final Notification notification;
    private final FlightRepository flightRepository;

    public FlightManager(Set<Flight> flightsSet, Notification notification, FlightRepository flightRepository) {
        this.flightsSet = flightsSet;
        this.notification = notification;
        this.flightRepository = flightRepository;
    }

    public void findFlights(Airport origin, Airport destination, String user) {
        List<Flight> directFlights = flightsSet.stream()
                .filter(f -> f.getOriginAirport().equals(origin) && f.getDestinationAirport().equals(destination))
                .collect(Collectors.toList());

        if (!directFlights.isEmpty()) {
            directFlights.forEach(f -> notification.sendNotification(user, f.toString()));
        } else {
            List<Flight> possibleConnections = flightsSet.stream()
                    .filter(f -> f.getOriginAirport().equals(origin))
                    .flatMap(firstFlight -> flightsSet.stream()
                            .filter(secondFlight -> secondFlight.getOriginAirport().equals(firstFlight.getDestinationAirport())
                                    && secondFlight.getDestinationAirport().equals(destination))
                            .map(secondFlight -> new Flight(origin, destination,
                                    List.of(firstFlight.getDestinationAirport()), firstFlight.getDepartureTime()))
                    )
                    .collect(Collectors.toList());

            possibleConnections.forEach(f -> notification.sendNotification(user, f.toString()));
        }
    }

    public void displayFlights() {
        flightsSet.forEach(System.out::println);
    }
}