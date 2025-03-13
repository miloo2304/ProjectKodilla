package com.kodilla.good.patterns.challenges.ChalengePart1;

import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        InformationCompanyService informationCompanyService = new CompanyEmailInformationService();
        InformationUserService informationUserService = new UserEmailInformationService();
        OrderRepository orderRepository = new OrderDatabaseRepository();
        OrderService orderService = new OrderedService();

        OrderProcessor orderProcessor = new OrderProcessor(informationCompanyService,
                informationUserService, orderRepository, orderService);

        OrderInformation orderInformation = new OrderInformation(
                new User("Adam Kowalski", "Adress of delivery", "AdamKowalski@example.com"),
                new Company("NameCompany", "AdressCompany",
                        "EmailCompany.example.com"),
                new Order("OrderName", 10, 10));
        OrderRequest orderRequest = new OrderRequest(orderInformation, LocalDateTime.now(), LocalDateTime.now().plusMinutes(1));
        OrderDto orderDto = orderProcessor.process(orderRequest);
        if (orderDto.isOrdered()) {
            System.out.println("Order request processed succesfully for: "
                    + orderDto.getOrderInformation().getUser().getUserName());
        } else {
            System.out.println("Order request failed for: "
                    + orderDto.getOrderInformation().getUser().getUserName());
        }
    }
}
