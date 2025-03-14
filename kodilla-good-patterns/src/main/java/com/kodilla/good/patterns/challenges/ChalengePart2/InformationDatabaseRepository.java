package com.kodilla.good.patterns.challenges.ChalengePart2;
import java.util.ArrayList;
import java.util.List;
public class InformationDatabaseRepository implements FlightRepository {
    private final List<Flight> flights = new ArrayList<>();

    @Override
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights); // Zwracamy nową listę, aby zabezpieczyć oryginalną
    }

}
