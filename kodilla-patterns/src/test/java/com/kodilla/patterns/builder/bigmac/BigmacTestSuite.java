package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();

        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        assertEquals("sesame", bun);
        assertEquals(2, burgers);
        assertEquals("barbecue", sauce);
        assertTrue(ingredients.contains("lettuce"));
        assertTrue(ingredients.contains("bacon"));
        assertTrue(ingredients.contains("cheese"));
        assertEquals(3, ingredients.size());
    }

    @Test
    void testBigmacBuilderWithInvalidBun() {
        assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("wholegrain")
                    .burgers(2)
                    .sauce("standard")
                    .ingredient("lettuce")
                    .build();
        });
    }

    @Test
    void testBigmacBuilderWithTooManyBurgers() {
        assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("plain")
                    .burgers(5)
                    .sauce("1000 islands")
                    .ingredient("onion")
                    .build();
        });
    }

    @Test
    void testBigmacBuilderWithInvalidIngredient() {
        assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("plain")
                    .burgers(3)
                    .sauce("barbecue")
                    .ingredient("tomato")
                    .build();
        });
    }
}