package com.kodilla.stream.game;

import java.util.Random;

public class Utils {
    public static String getRandomChoice(String[] choices) {
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }
}
