package com.kodilla.stream.game;

import java.util.Scanner;

public class GameModeOneVsComputer extends BaseGameMode {

    public GameModeOneVsComputer(GameSettings settings) {
        super(settings);
    }

    @Override
    public void startGame(Scanner scanner) {
        Player player = new Player(getPlayerName(scanner, "Enter your name"));
        Player computer = new Player("Computer");

        playRounds(scanner, player, computer);
    }
}