package com.kodilla.good.patterns.challenges.ChalengePart1;

public class OrderInformation {
    private final User user;
    private final Company company;
    private final Order order;

    public OrderInformation(User user, Company company, Order order) {
        this.user = user;
        this.company = company;
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    public Order getOrder() {
        return order;
    }
}


