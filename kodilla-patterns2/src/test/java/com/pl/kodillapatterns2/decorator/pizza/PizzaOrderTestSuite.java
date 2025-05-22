package com.pl.kodillapatterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + calculatedCost);
        // Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + description);
        // Then
        assertEquals("Pizza dough with tomato sauce and cheese", description);
    }

    @Test
    public void testPizzaWithSalamiAndCheeseGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + calculatedCost);
        // Then
        assertEquals(new BigDecimal(26), calculatedCost);
    }

    @Test
    public void testPizzaWithSalamiAndCheeseGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + description);
        // Then
        assertEquals("Pizza dough with tomato sauce and cheese + Salami + Cheese", description);
    }

    @Test
    public void testPizzaWithMultipleIngredientsGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BaconDecorator(theOrder);
        theOrder = new ChampignonsDecoractor(theOrder);
        theOrder = new CornDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + calculatedCost);
        // Then
        assertEquals(new BigDecimal(35), calculatedCost);
    }

    @Test
    public void testPizzaWithMultipleIngredientsGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BaconDecorator(theOrder);
        theOrder = new ChampignonsDecoractor(theOrder);
        theOrder = new CornDecorator(theOrder);
        theOrder = new OnionDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + description);
        // Then
        assertEquals("Pizza dough with tomato sauce and cheese + Bacon + Champignons + Corn + Onion + Salami", description);
    }

    @Test
    public void testPizzaFromDominosWithToppingsGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DominosNetworkOrderDecorator(theOrder);
        theOrder = new PaprikaDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + calculatedCost);
        // Then
        assertEquals(new BigDecimal(46), calculatedCost);
    }

    @Test
    public void testPizzaFromDominosWithToppingsGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DominosNetworkOrderDecorator(theOrder);
        theOrder = new PaprikaDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + description);
        // Then
        assertEquals("Pizza dough with tomato sauce and cheese by Dominos pizzeria + Paprika + Ham", description);
    }

    @Test
    public void testPizzaFromPizzaHutWithCheeseAndOlivesGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaHutOrderDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println("Cost: " + calculatedCost);
        // Then
        assertEquals(new BigDecimal(56), calculatedCost);
    }

    @Test
    public void testPizzaFromPizzaHutWithCheeseAndOlivesGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaHutOrderDecorator(theOrder);
        theOrder = new CheeseDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        System.out.println("Description: " + description);
        // Then
        assertEquals("Pizza dough with tomato sauce and cheese by PizzaHut pizzeria + Cheese + Olives", description);
    }
}
