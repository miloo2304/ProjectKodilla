package com.kodilla.good.patterns.challenges.Project1;

public class EmailInformationService implements InformationService {
    @Override
    public void inform(User1 user1) {
        System.out.println("Sending email to: " + user1.getEmail());
    }
}
