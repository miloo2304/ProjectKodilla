package com.kodilla.good.patterns.challenges.ChalengePart1;

import java.time.LocalDateTime;

public class OrderedService implements OrderService{
    @Override
    public boolean ordered(OrderInformation orderInformation, LocalDateTime from, LocalDateTime to) {
        System.out.println("Ordered order for: " + orderInformation.getUser().getUserName()
                + ", " + orderInformation.getUser().getUserAdress() + " from " + from);
        return true;
    }
}
