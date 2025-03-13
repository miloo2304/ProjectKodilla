package com.kodilla.stream.game;
import java.util.Scanner;

public class GameModeOneVsTwoComputers extends BaseGameMode {

    public GameModeOneVsTwoComputers(GameSettings settings) {
        super(settings);
    }

    @Override
    public void startGame(Scanner scanner) {
        Player player = new Player(getPlayerName(scanner, "Enter your name"));
        Player computer1 = new Player("Computer 1");
        Player computer2 = new Player("Computer 2");

        playRounds(scanner, player, computer1, computer2);
    }
}