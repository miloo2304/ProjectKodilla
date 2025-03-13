package com.kodilla.stream.game;

import java.util.Scanner;

public class GameMode {
    private final GameSettings settings;

    public GameMode(GameSettings settings) {
        this.settings = settings;
    }

    public void chooseAndStartGameMode(Scanner scanner) {
        int mode = 0;

        while (true) {
            try {
                System.out.println("Choose game mode:");
                System.out.println("1: Player vs Computer");
                System.out.println("2: Player vs 2 Computers");
                System.out.println("3: Player vs 3 Computers");
                System.out.println("4: 2 Players");
                System.out.println("5: 3 Players");

                mode = Integer.parseInt(scanner.nextLine().trim());
                if (mode < 1 || mode > 5) {
                    throw new IllegalArgumentException("Invalid mode selected! Please choose a number between 1 and 5.");
                }
                break; // Valid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 5.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        BaseGameMode gameMode;

        switch (mode) {
            case 1:
                gameMode = new GameModeOneVsComputer(settings);
                break;
            case 2:
                gameMode = new GameModeOneVsTwoComputers(settings);
                break;
            case 3:
                gameMode = new GameModeOneVsThreeComputers(settings);
                break;
            case 4:
                gameMode = new GameModeOneVsOne(settings);
                break;
            case 5:
                gameMode = new GameModeOneVsOneVsOne(settings);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

        // Start the selected game mode
        gameMode.startGame(scanner);
    }
}