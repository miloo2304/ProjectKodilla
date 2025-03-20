package com.kodilla.stream.game;

import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSettings settings = new GameSettings();
        settings.chooseLanguage(scanner);

        System.out.println(settings.getString("welcome"));

        boolean runGame = true;

        while (runGame) {
            System.out.println("\nChoose an option:");
            System.out.println("1: Player vs Computer");
            System.out.println("2: Player vs 2 Computers");
            System.out.println("3: Player vs 3 Computers");
            System.out.println("4: 2 Players");
            System.out.println("5: 3 Players");
            System.out.println("7: Choose language");
            System.out.println("8: Set the number of rounds");
            System.out.println("9: Exit");

            try {
                int mode = Integer.parseInt(scanner.nextLine().trim());

                switch (mode) {
                    case 1 -> {
                        settings.setWinningScore(scanner);
                        GameMode gameMode = new GameMode(settings);
                        gameMode.chooseAndStartGameMode(scanner);
                    }
                    case 2 -> {
                        settings.setWinningScore(scanner);
                        GameMode gameMode = new GameMode(settings);
                        gameMode.chooseAndStartGameMode(scanner);
                    }
                    case 3 -> {
                        settings.setWinningScore(scanner);
                        GameMode gameMode = new GameMode(settings);
                        gameMode.chooseAndStartGameMode(scanner);
                    }
                    case 4 -> {
                        settings.setWinningScore(scanner);
                        GameMode gameMode = new GameMode(settings);
                        gameMode.chooseAndStartGameMode(scanner);
                    }
                    case 5 -> {
                        settings.setWinningScore(scanner);
                        GameMode gameMode = new GameMode(settings);
                        gameMode.chooseAndStartGameMode(scanner);
                    }
                    case 7 -> {
                        settings.chooseLanguage(scanner);
                        System.out.println(settings.getString("welcome"));
                    }
                    case 8 -> {
                        settings.setNumberOfRounds(scanner);
                        System.out.println("The number of rounds has been set to: " + settings.getNumberOfRounds());
                    }
                    case 9 -> {
                        System.out.println(settings.getString("goodbye"));
                        runGame = false;
                    }
                    default -> System.out.println("Invalid mode! Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        scanner.close();
    }
}