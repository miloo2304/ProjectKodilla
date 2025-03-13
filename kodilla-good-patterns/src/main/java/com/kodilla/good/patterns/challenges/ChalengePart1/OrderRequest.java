package com.kodilla.good.patterns.challenges.ChalengePart1;

import java.time.LocalDateTime;

public class OrderRequest {
    private final OrderInformation orderInformation;
    private final LocalDateTime from;
    private final LocalDateTime to;

    public OrderRequest(OrderInformation orderInformation, LocalDateTime from, LocalDateTime to) {
        this.orderInformation = orderInformation;
        this.from = from;
        this.to = to;
    }
    public OrderInformation getOrderInformation() {
        return orderInformation;
    }
    public LocalDateTime getFrom() {
        return from;
    }
    public LocalDateTime getTo() {
        return to;
    }
}
