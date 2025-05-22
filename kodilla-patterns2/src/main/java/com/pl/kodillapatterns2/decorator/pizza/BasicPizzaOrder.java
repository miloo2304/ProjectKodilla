package com.pl.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(20.00);
    }
    @Override
    public String getDescription() {
        return "Pizza dough with tomato sauce and cheese";
    }
}
