package com.kodilla.good.patterns.challenges.Project1;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        InformationService informationService = new EmailInformationService();
        RentalService rentalService = new CarRentalService();
        RentalRepository rentalRepository = new RentalDatabaseRepository();

        RentalProcessor rentalProcessor = new RentalProcessor(informationService, rentalService, rentalRepository);

        User1 user1 = new User1("User user", "User_user@gmail.com");
        RentRequest rentRequest = new RentRequest(user1, LocalDateTime.now(), LocalDateTime.now().plusDays(2));

        RentalDto rentalDto = rentalProcessor.process(rentRequest);

        if (rentalDto.isRented()) {
            System.out.println("Rental request processed successfully for: " + rentalDto.getUser().getName());
        } else {
            System.out.println("Rental request failed for: " + rentalDto.getUser().getName());
        }
    }
}