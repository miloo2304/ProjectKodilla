package com.pl.kodillapatterns2.decorator.taxiportal;

import java.math.BigDecimal;
public interface TaxiOrder {
    BigDecimal getCost();
    String getDescription();
}