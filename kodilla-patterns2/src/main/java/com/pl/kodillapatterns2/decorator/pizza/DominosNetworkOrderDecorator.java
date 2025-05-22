package com.pl.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class DominosNetworkOrderDecorator extends AbstractPizzaOrderDecorator {
    public DominosNetworkOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {

        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by Dominos pizzeria";
    }
}
