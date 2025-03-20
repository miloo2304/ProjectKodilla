package com.kodilla.good.patterns.ChallengeFlight;

public interface NotificationService {
    void sendEmail(String email, String message);
    void sendSms(String phoneNumber, String message);
}
