package com.kodilla.stream.game;

import java.util.Scanner;

public class GameModeOneVsOne extends BaseGameMode {

    public GameModeOneVsOne(GameSettings settings) {
        super(settings);
    }

    @Override
    public void startGame(Scanner scanner) {
        Player player = new Player(getPlayerName(scanner, "Enter first player's name"));
        Player player2 = new Player(getPlayerName(scanner,"Enter second player's name"));

        playRounds(scanner, player, player2);
    }
}

