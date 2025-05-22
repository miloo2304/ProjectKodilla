package com.pl.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class DaGrassoOrderDecorator extends AbstractPizzaOrderDecorator {
    public DaGrassoOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by DaGrasso pizzeria";
    }
}
