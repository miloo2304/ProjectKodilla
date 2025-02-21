package com.kodilla.exception.test;

public class FlightsMain {

    public static void main(String[] args) {
        FlightSearcher flightSearcher = new FlightSearcher();
        Flight[] flights = {
                new Flight("Warsaw", "Paris"),
                new Flight("Cracow", "Paris"),
                new Flight("New York", "Tokyo"),
                new Flight("Berlin", "Sydney"),
                new Flight("London", "Paris"),
        };
        for (Flight flight : flights) {
            flightSearcher.findFlight(flight);
        }
    }
}
