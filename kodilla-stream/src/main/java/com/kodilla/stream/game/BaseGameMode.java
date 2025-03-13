package com.kodilla.stream.game;

import java.util.Random;
import java.util.Scanner;

public abstract class BaseGameMode {
    protected final GameSettings settings;

    public BaseGameMode(GameSettings settings) {
        this.settings = settings;
    }

    public abstract void startGame(Scanner scanner);

    protected void playRounds(Scanner scanner, Player... players) {
        Random random = new Random();
        String[] choices = settings.getChoices();
        int winningScore = settings.getWinningScore();

        System.out.println("\nFirst to " + winningScore + " points wins!");

        while (true) {
            System.out.println("\n--- New Round ---");

            for (Player player : players) {
                if (player.hasWon(winningScore)) {
                    System.out.println(player.getName() + " wins the game with " + player.getScore() + " points!");
                    return;
                }
            }

            // Collect moves from all players
            String[] moves = new String[players.length];
            for (int i = 0; i < players.length; i++) {
                Player player = players[i];
                if (player.getName().startsWith("Player")) {
                    moves[i] = getPlayerMoveAsText(scanner, player.getName(), choices);
                } else {
                    String move = choices[random.nextInt(choices.length)];
                    System.out.println(player.getName() + " chooses " + move);
                    moves[i] = move;
                }
            }

            // Process round results
            processRoundResults(moves, players);
        }
    }

    private String getPlayerMoveAsText(Scanner scanner, String playerName, String[] choices) {
        while (true) {
            try {
                System.out.println(playerName + ", type your move: " + String.join(", ", choices) + ".");
                String move = scanner.nextLine().trim();

                for (String validChoice : choices) {
                    if (validChoice.equalsIgnoreCase(move)) {
                        return validChoice;
                    }
                }
                throw new IllegalArgumentException("Invalid move! Please type one of the following: " + String.join(", ", choices));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processRoundResults(String[] moves, Player[] players) {
        for (int i = 0; i < moves.length; i++) {
            boolean winnerFound = true;

            for (int j = 0; j < moves.length; j++) {
                if (i != j && !beats(moves[i], moves[j])) {
                    winnerFound = false;
                    break;
                }
            }

            if (winnerFound) {
                players[i].increaseScore();
                System.out.println(players[i].getName() + " wins this round and now has " + players[i].getScore() + " points.");
                return;
            }
        }

        System.out.println("It's a draw! No one wins this round.");
    }

    private boolean beats(String move1, String move2) {
        return (move1.equalsIgnoreCase("Rock") && move2.equalsIgnoreCase("Scissors"))
                || (move1.equalsIgnoreCase("Scissors") && move2.equalsIgnoreCase("Paper"))
                || (move1.equalsIgnoreCase("Paper") && move2.equalsIgnoreCase("Rock"));
    }

    protected String getPlayerName(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty. Please enter a valid name.");
                }
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}