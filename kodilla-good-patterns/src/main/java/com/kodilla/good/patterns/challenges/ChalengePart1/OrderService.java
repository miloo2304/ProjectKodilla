package com.kodilla.good.patterns.challenges.ChalengePart1;
import java.time.LocalDateTime;

public interface OrderService {
    boolean ordered(OrderInformation orderInformation, LocalDateTime from, LocalDateTime to);
}
