package com.kodilla.good.patterns.challenges.ChalengePart2;
import java.time.LocalDateTime;
import java.util.Objects;

public class InformationsRequest {
    private final Informations informations;
    private final LocalDateTime dateTime;
    public InformationsRequest(Informations informations, LocalDateTime dateTime) {
        this.informations = informations;
        this.dateTime = dateTime;
    }
    public Informations getInformations() {
        return informations;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InformationsRequest that)) return false;
        return Objects.equals(informations, that.informations) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(informations, dateTime);
    }
}
