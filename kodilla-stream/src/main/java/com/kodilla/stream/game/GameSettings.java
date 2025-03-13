package com.kodilla.stream.game;

import java.util.Scanner;

public class GameSettings {
    private String language;
    private int winningScore;
    private int numberOfRounds;
    private String[] choices;

    public void chooseLanguage(Scanner scanner) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Choose language: 1 - English, 2 - Polski");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 1) {
                    language = "EN";
                    choices = new String[]{"Rock", "Paper", "Scissors"};
                    validInput = true;
                } else if (choice == 2) {
                    language = "PL";
                    choices = new String[]{"Kamień", "Papier", "Nożyce"};
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter 1 for English or 2 for Polski.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number (1 or 2).");
            }
        }
    }

    public void setWinningScore(Scanner scanner) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(getString("set_score"));
                winningScore = Integer.parseInt(scanner.nextLine().trim());
                if (winningScore <= 0) {
                    System.out.println("The winning score must be a positive number. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid positive integer.");
            }
        }
    }

    public void setNumberOfRounds(Scanner scanner) {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(getString("set_rounds"));
                numberOfRounds = Integer.parseInt(scanner.nextLine().trim());
                if (numberOfRounds <= 0) {
                    System.out.println("The number of rounds must be a positive number. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid positive integer.");
            }
        }
    }

    public String getString(String key) {
        return switch (key) {
            case "welcome" -> language.equals("EN") ? "Welcome to Rock, Paper, Scissors!" : "Witaj w grze Kamień, Papier, Nożyce!";
            case "set_score" -> language.equals("EN") ? "Set the winning score:" : "Ustaw liczbę punktów do wygranej:";
            case "set_rounds" -> language.equals("EN") ? "Set the number of rounds:" : "Ustaw liczbę rund:";
            case "invalid_mode" -> language.equals("EN") ? "Invalid game mode, exiting." : "Nieprawidłowy tryb gry, wychodzę.";
            case "goodbye" -> language.equals("EN") ? "Thanks for playing!" : "Dziękujemy za grę!";
            default -> "";
        };
    }

    public int getWinningScore() {
        return winningScore;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public String[] getChoices() {
        return choices;
    }
}