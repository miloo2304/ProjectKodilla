package com.pl.kodillapatterns2.decorator.pizza;

import com.pl.kodillapatterns2.decorator.taxiportal.TaxiOrder;

import java.math.BigDecimal;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {
    private final PizzaOrder pizzaOrder;
    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }
    @Override
    public BigDecimal getCost() {					// [5]
        return pizzaOrder.getCost();
    }

    @Override
    public String getDescription() {					// [6]
        return pizzaOrder.getDescription();
    }
}
