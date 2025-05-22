package com.pl.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class PizzaHutOrderDecorator extends AbstractPizzaOrderDecorator{
    public PizzaHutOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 30
        return super.getCost().add(new BigDecimal(30));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by PizzaHut pizzeria";
    }
}
