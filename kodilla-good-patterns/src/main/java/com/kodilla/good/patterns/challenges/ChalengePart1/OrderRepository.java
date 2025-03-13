package com.kodilla.good.patterns.challenges.ChalengePart1;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrderDescription(OrderInformation orderInformation, LocalDateTime from, LocalDateTime to);
}
