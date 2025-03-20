package com.kodilla.good.patterns.ChallengeFlight;
import java.time.LocalDateTime;
import java.util.Objects;

public class FlightDto {
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public FlightDto(String departure, String destination, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.departure = departure;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(departure, flightDto.departure) && Objects.equals(destination, flightDto.destination) && Objects.equals(departureTime, flightDto.departureTime) && Objects.equals(arrivalTime, flightDto.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, destination, departureTime, arrivalTime);
    }
}
