package com.kodilla.good.patterns.ChallengeFlight;

public class NotificationSMS implements Notification {
    @Override
    public void sendNotification (String user, String body) {
        System.out.println("Sendind SMS to: " + user);
        System.out.println("Body SMS: " + body);
    }
}

