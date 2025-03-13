package com.kodilla.good.patterns.challenges.ChalengePart1;



public class OrderProcessor {
    private InformationCompanyService informationCompanyService;
    private InformationUserService informationUserService;
    private OrderRepository orderRepository;
    private OrderService orderService;

    public OrderProcessor(InformationCompanyService informationCompanyService,
                          InformationUserService informationUserService,
                          OrderRepository orderRepository,
                          OrderService orderService) {
        this.informationCompanyService = informationCompanyService;
        this.informationUserService = informationUserService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.ordered(orderRequest.getOrderInformation(), orderRequest.getFrom(),
                orderRequest.getTo());
        if (isOrdered) {
            informationUserService.informUser(orderRequest.getOrderInformation().getUser());
            informationCompanyService.informCompany(orderRequest.getOrderInformation().getCompany());
            orderRepository.createOrderDescription(orderRequest.getOrderInformation(), orderRequest.getFrom(), orderRequest.getTo());
            return new OrderDto(orderRequest.getOrderInformation(), true);
        } else
            return new OrderDto(orderRequest.getOrderInformation(), false);
    }
}


