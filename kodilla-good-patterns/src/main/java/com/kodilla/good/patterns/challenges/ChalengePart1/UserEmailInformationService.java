package com.kodilla.good.patterns.challenges.ChalengePart1;
import java.lang.*;

public class UserEmailInformationService implements InformationUserService {
    @Override
    public void informUser(User user) {
       System.out.println("Sending email to " + user.getUserEmail());
    }
}
