package com.kodilla.good.patterns.challenges.ChalengePart2;

public class UserFlightEmailInformationService implements InformationUserFlightService{
    @Override
    public void  sendFlightDetailsViaEmail(UserFlight userFlight) {
        System.out.println("Sending confirmation to: " + userFlight.getUserEmail());
    }
}
