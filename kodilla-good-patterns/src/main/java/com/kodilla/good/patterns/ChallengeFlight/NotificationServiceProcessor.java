package com.kodilla.good.patterns.ChallengeFlight;

public class NotificationServiceProcessor implements NotificationService {

    @Override
    public void sendEmail(String email, String message) {
        System.out.println("E-mail sent to: " + email + " | Message:  " + message);
    }

    @Override
    public void sendSms(String phoneNumber, String message) {
        System.out.println("SMS sent to: " + phoneNumber + " | Message: " + message);
    }
}
