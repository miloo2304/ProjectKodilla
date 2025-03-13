package com.kodilla.good.patterns.challenges.ChalengePart1;

import java.time.LocalDateTime;

public class OrderDatabaseRepository implements OrderRepository{
    @Override
    public void createOrderDescription(OrderInformation orderInformation, LocalDateTime from, LocalDateTime to) {
        System.out.println("Create database to save, order informations: " + orderInformation.getUser()
        + ", " + orderInformation.getCompany() + ", " + orderInformation.getOrder()
        + " From LocalDataTime: " + from);
    }
}
