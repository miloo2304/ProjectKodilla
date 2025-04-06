package com.kodilla.good.patterns.ChallengeFlight;

public class NotificationEmail implements Notification {
    @Override
    public void sendNotification(String user, String body) {
        System.out.println("Sending e-mail to: " + user);
        System.out.println("Body of mail: " + body);
    }
}
