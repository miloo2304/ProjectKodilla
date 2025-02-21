package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    private final Map<String, Boolean> availableAirports;

    public FlightSearcher() {
        availableAirports = new HashMap<>();
        availableAirports.put("Warsaw", true);
        availableAirports.put("Berlin", true);
        availableAirports.put("London", false);
        availableAirports.put("Paris", true);
        availableAirports.put("New York", true);
        availableAirports.put("Tokyo", false);
        availableAirports.put("Sydney", true);
        availableAirports.put("Los Angeles", true);
        availableAirports.put("Rome", false);
    }

    public void findFlight(Flight flight) {
        try {
            boolean departureAvailable = checkAirportAvailability(flight.getDepartureAirport());
            boolean arrivalAvailable = checkAirportAvailability(flight.getArrivalAirport());

            if (departureAvailable && arrivalAvailable) {
                System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " is available.");
            } else {
                System.out.println("No flights available from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport());
            }
        } catch (RouteNotFoundException e) {
            // Handle exception without displaying the stack trace
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Flight check completed for: " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + "\n");
        }
    }

    private boolean checkAirportAvailability(String airport) throws RouteNotFoundException {
        if (!availableAirports.containsKey(airport)) {
            throw new RouteNotFoundException(airport + " Airport not found.");
        }
        return availableAirports.get(airport);
    }
}
