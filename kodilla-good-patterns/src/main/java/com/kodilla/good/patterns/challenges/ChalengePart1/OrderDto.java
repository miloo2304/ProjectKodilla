package com.kodilla.good.patterns.challenges.ChalengePart1;

public class OrderDto {
    private final OrderInformation orderInformation;
    private final boolean isOrdered;

    public OrderDto(OrderInformation orderInformation, boolean isOrdered) {
        this.orderInformation = orderInformation;
        this.isOrdered = isOrdered;
    }

    public OrderInformation getOrderInformation() {
        return orderInformation;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
