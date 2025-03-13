package com.kodilla.good.patterns.challenges.ChalengePart1;

public class Order {
    private final String orderName;
    private final int orderPrice;
    private final int orderQuantity;

    public Order(String orderName, int orderPrice, int orderQuantity) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
