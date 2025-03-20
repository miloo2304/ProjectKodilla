/*package com.kodilla.good.patterns.ChallengeFlight;
import java.time.LocalDateTime;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepositoryStreamer();

        NotificationService notificationService = new NotificationServiceProcessor();

        flightRepository.addFlight(new FlightDto("GDAŃSK", "KRAKÓW", LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
        flightRepository.addFlight(new FlightDto("KRAKÓW", "WROCŁAW", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5)));
        flightRepository.addFlight(new FlightDto("WROCŁAW", "POZNAŃ", LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(7)));
        flightRepository.addFlight(new FlightDto("GDAŃSK", "POZNAŃ", LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10)));
        flightRepository.addFlight(new FlightDto("WARSZAWA", "ŁÓDŹ", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)));
        flightRepository.addFlight(new FlightDto("ŁÓDŹ", "KATOWICE", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4)));
        flightRepository.addFlight(new FlightDto("KATOWICE", "SZCZECIN", LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(7)));
        flightRepository.addFlight(new FlightDto("SZCZECIN", "LUBLIN", LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10)));
        flightRepository.addFlight(new FlightDto("LUBLIN", "RZESZÓW", LocalDateTime.now().plusHours(11), LocalDateTime.now().plusHours(13)));
        flightRepository.addFlight(new FlightDto("RZESZÓW", "GDAŃSK", LocalDateTime.now().plusHours(14), LocalDateTime.now().plusHours(16)));
        flightRepository.addFlight(new FlightDto("GDAŃSK", "SZCZECIN", LocalDateTime.now(), LocalDateTime.now().plusHours(2)));
        flightRepository.addFlight(new FlightDto("SZCZECIN", "LUBLIN", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5)));

        List<FlightDto> connectingFlights = flightRepository.findFlightsVia("GDAŃSK", "SZCZECIN", "LUBLIN");
        if (!connectingFlights.isEmpty()) {
            System.out.println("Znaleziono następujące loty:");
            for (FlightDto flight : connectingFlights) {
                System.out.println(flight);
            }
        } else {
            System.out.println("Brak dostępnego lotu.");
        }
    }
    // Szukane miasta
    String departureCity = "GDAŃSK";
    String viaCity = "SZCZECIN";
    String destinationCity = "LUBLIN";

        System.out.println("Szukam lotów z " + departureCity + " do " + destinationCity + " przez " + viaCity + "...");

    // Wyszukiwanie lotów przez miasto via
    List<FlightDto> connectingFlights = flightRepository.findFlightsVia(departureCity, viaCity, destinationCity);

    // Wyświetlanie wyników
        if (!connectingFlights.isEmpty()) {
        System.out.println("Znaleziono następujące loty:");
        for (FlightDto flight : connectingFlights) {
            System.out.println("Lot z " + flight.getDeparture() + " do " + flight.getDestination() +
                    ", odlot: " + flight.getDepartureTime() +
                    ", przylot: " + flight.getArrivalTime());
        }
    } else {
        System.out.println("Brak dostępnego lotu z " + departureCity + " do " + destinationCity + " przez " + viaCity + ".");
    }
}

}
*/