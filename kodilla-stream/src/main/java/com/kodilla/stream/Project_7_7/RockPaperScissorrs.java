    /* Gra w kamień, papier i nożyce. Gra daje możliwość wyboru dwóch języków, zagranie
    w jeden z pięciu możliwych trybów gry, wybór ustawień w postaci liczby rund.
    */

    package com.kodilla.stream.Project_7_7;
    import java.util.*;
    import java.util.Random;
    import java.util.Scanner;

    class RockPaperScissors {
        private static final String[] choicesPL = {"Kamień", "Papier", "Nożyce"};
        private static final String[] choicesEN = {"Rock", "Paper", "Scissors"};
        private static int userScore = 0, user2Score = 0, user3Score = 0,
                computer1Score = 0, computer2Score = 0, computer3Score = 0, ties = 0;
        private static int winningScore = 3;
        private static String language;
        private static String[] choices;
        private static int[] scores; // Wyniki wszystkich uczestników gry


        private static String playerName; // Zmienna na imię gracza

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            try {
                // Wybierz język
                chooseLanguage(scanner);

                while (true) {
                    // Użytkownik wybiera tryb gry
                    int gameMode = chooseGameMode(scanner);

                    if (gameMode == 7) {
                        System.out.println(getString("Powrócono do wyboru rund."));
                        setWinningScore(scanner);
                        continue;
                    } else if (gameMode == 8) {
                        System.out.println(getString("Powrócono do menu głównego."));
                        chooseLanguage(scanner);
                        continue;
                    } else if (gameMode == 9) {
                        System.out.println(getString("Dziękujemy za grę! Do zobaczenia!"));
                        break;
                    } else if (gameMode == 10) {
                        System.out.println(getString("Powrót do wyboru języka."));
                        chooseLanguage(scanner);
                        continue;
                    }

                    // Wywołanie odpowiedniego trybu gry
                    switch (gameMode) {
                        case 1 -> {
                            resetScores(2); // Gracz i Komputer
                            playOneVsComputer(scanner);
                        }
                        case 2 -> {
                            resetScores(3); // Gracz i 2 Komputery
                            playOneVsTwoComputers(scanner);
                        }
                        case 3 -> {
                            resetScores(4); // Gracz i 3 Komputery
                            playOneVsThreeComputers(scanner);
                        }
                        case 4 -> {
                            resetScores(2); // 2 Graczy
                            playTwoPlayers(scanner);
                        }
                        case 5 -> {
                            resetScores(3); // 3 Graczy
                            playThreePlayers(scanner);
                        }
                        default -> System.out.println(getString("Nieznany tryb gry."));
                    }

                    // Zapytanie, czy gracz chce kontynuować
                    System.out.println(getString("Czy chcesz zagrać ponownie? (tak/nie)"));
                    String playAgain = scanner.nextLine().toLowerCase();
                    if (playAgain.equals(getString("nie"))) {
                        System.out.println(getString("Dziękujemy za grę! Do zobaczenia!"));
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(getString("Wystąpił nieoczekiwany błąd: ") + e.getMessage());
            } finally {
                System.out.println(getString("Dziękujemy za grę!"));
            }
        }




        // Wybór języka
        private static void chooseLanguage(Scanner scanner) {
            try {
                System.out.println("Choose language / Wybierz język:");
                System.out.println("1. Polish / Polski");
                System.out.println("2. English / Angielski");

                int languageChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (languageChoice == 1) {
                    language = "PL";
                    choices = choicesPL;
                } else {
                    language = "EN";
                    choices = choicesEN;
                }
            } catch (Exception e) {
                // In case of an exception, default to English
                System.out.println("You should choose language. Defaulting to English.");
                language = "EN";
                choices = choicesEN;
            }
        }


        // Funkcja tłumacząca napisy w zależności od wybranego języka
        private static String getString(String key) {
            if (language.equals("PL")) {
                switch (key) {
                    case "Witaj w grze Kamień, Papier, Nożyce!":
                        return "Witaj w grze Kamień, Papier, Nożyce!";
                    case "Nieznany tryb gry.":
                        return "Nieznany tryb gry.";
                    case "Czy chcesz zagrać ponownie? (tak/nie)":
                        return "Czy chcesz zagrać ponownie? (tak/nie)";
                    case "nie":
                        return "nie";
                    case "Dziękujemy za grę! Do zobaczenia!":
                        return "Dziękujemy za grę! Do zobaczenia!";
                    case "Wystąpił nieoczekiwany błąd: ":
                        return "Wystąpił nieoczekiwany błąd: ";
                    case "Dziękujemy za grę!":
                        return "Dziękujemy za grę!";
                    case "Podaj liczbę punktów potrzebnych do wygranej (np. 3): ":
                        return"Podaj liczbę punktów potrzebnych do wygranej (np. 3): ";
                    case "Wprowadzono nieprawidłową liczbę, domyślnie ustawiamy 3 punkty.":
                        return "Wprowadzono nieprawidłową liczbę, domyślnie ustawiamy 3 punkty.";
                    case "Wybierz tryb gry:":
                        return "Wybierz tryb gry.";
                    case "1. Gracz vs Komputer":
                        return "1. Gracz vs Komputer";
                    case "2. Gracz vs 2 Komputery":
                        return "2. Gracz vs 2 Komputery";
                    case "3. Gracz vs 3 Komputery":
                        return "3. Gracz vs 3 Komputery";
                    case "4. 2 Graczy":
                        return "4. 2 Graczy";
                    case "5. 3 Graczy":
                        return "5. 3 Graczy";
                    case "Podaj swoje imię: ":
                        return "Podaj swoje imię: ";
                    case "Wybierz swój ruch:":
                        return "Wybierz swój ruch:";
                    case "\nRozpoczynamy nową rundę!":
                        return "\nRozpoczynamy nową rundę!";
                    case " wybiera: ":
                        return " wybiera: ";


                    default:
                        return key;
                }
            } else {
                switch (key) {
                    case "Witaj w grze Kamień, Papier, Nożyce!":
                        return "Welcome to Rock, Paper, Scissors!";
                    case "Nieznany tryb gry.":
                        return "Unknown game mode.";
                    case "Czy chcesz zagrać ponownie? (tak/nie)":
                        return "Do you want to play again? (yes/no)";
                    case "nie":
                        return "no";
                    case "Dziękujemy za grę! Do zobaczenia!":
                        return "Thank you for playing! Goodbye!";
                    case "Wystąpił nieoczekiwany błąd: ":
                        return "An unexpected error occurred: ";
                    case "Dziękujemy za grę!":
                        return "Thank you for playing!";
                    case "Podaj liczbę punktów potrzebnych do wygranej (np. 3): ":
                        return "Please type how many games till win you want to play? (default = 3): ";
                    case "Wprowadzono nieprawidłową liczbę, domyślnie ustawiamy 3 punkty":
                        return "You type incorret number, default = 3";
                    case "Wybierz tryb gry:":
                        return "Choose game mode:";
                    case "1. Gracz vs Komputer":
                        return "1. Player vs Computer";
                    case "2. Gracz vs 2 Komputery":
                        return "2. Player vs 2 Computers";
                    case "3. Gracz vs 3 Komputery":
                        return "3. Player vs 3 Computers";
                    case "4. 2 Graczy":
                        return "4. 2 Players";
                    case "5. 3 Graczy":
                        return "5. 3 Players";
                    case "Podaj swoje imię: ":
                        return "Please type your name: ";
                    case "Wybierz swój ruch:":
                        return "Take your move: ";
                    case "\nRozpoczynamy nową rundę!":
                        return "\nStarting new round!";
                    case " wybiera: ":
                        return " is chosing: ";
                    default:
                        return key;
                }
            }
        }

        // Ustawienie liczby punktów do wygranej przed rozpoczęciem gry
        private static void setWinningScore(Scanner scanner) {
            while (true) {
                try {
                    System.out.println(getString("Podaj liczbę punktów potrzebnych do wygranej (np. 3): "));
                    winningScore = Integer.parseInt(scanner.nextLine());
                    if (winningScore > 0) break;
                    System.out.println(getString("Podano niewłaściwą wartość."));
                } catch (NumberFormatException e) {
                    System.out.println(getString("Podano niewłaściwą wartość."));
                }
            }
        }


        // Wybór trybu gry
        private static int chooseGameMode(Scanner scanner) {
            while (true) {
                try {
                    System.out.println(getString("Wybierz tryb gry:"));
                    System.out.println("1. Gracz vs Komputer");
                    System.out.println("2. Gracz vs 2 Komputery");
                    System.out.println("3. Gracz vs 3 Komputery");
                    System.out.println("4. 2 Graczy");
                    System.out.println("5. 3 Graczy");
                    System.out.println("7. Powrót do wyboru liczby rund");
                    System.out.println("8. Powrót do menu głównego");
                    System.out.println("9. Wyjście z gry");
                    System.out.println("10. Powrót do wyboru języka");

                    int gameMode = Integer.parseInt(scanner.nextLine());
                    if (gameMode >= 1 && gameMode <= 10) return gameMode;

                    System.out.println(getString("Niepoprawny wybór, wybierz ponownie:"));
                } catch (NumberFormatException e) {
                    System.out.println(getString("Niepoprawny wybór, wybierz ponownie:"));
                }
            }
        }


        // Gra 1 gracz vs komputer
        private static void playOneVsComputer(Scanner scanner) {
            System.out.println(getString("Podaj swoje imię: "));
            String playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) {
                playerName = "Player";
            }

            resetScores(2); // Gracz i Komputer

            while (true) {
                System.out.println(getString("\nRozpoczynamy nową rundę!"));
                System.out.print(playerName + ": ");
                String playerMove = getValidatedMove(scanner);

                String computerMove = getRandomChoice();
                System.out.println(getString("Komputer wybiera: ") + computerMove);

                String result = determineResult(playerMove, computerMove);
                if (result.equalsIgnoreCase("tie")) {
                    ties++;
                    System.out.println(getString("Remis!"));
                } else if (result.equalsIgnoreCase("player1")) {
                    scores[0]++;
                    System.out.println(playerName + " wygrywa rundę!");
                } else {
                    scores[1]++;
                    System.out.println(getString("Komputer wygrywa rundę!"));
                }

                showScores(new String[]{playerName, getString("Komputer")}, scores, ties);

                if (scores[0] == winningScore || scores[1] == winningScore) {
                    System.out.println(getString("\nGra zakończona! Wynik końcowy:"));
                    showScores(new String[]{playerName, getString("Komputer")}, scores, ties);
                    break;
                }
            }
        }


        // Gra 1 gracz vs 2 komputery
        private static void playOneVsTwoComputers(Scanner scanner) {
            System.out.println(getString("Podaj swoje imię: "));
            String playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) {
                playerName = "Player"; // Domyślna nazwa gracza
            }

            resetScores(3); // Gracz i 2 Komputery (Tablica wyników zawiera 3 elementy)

            while (true) {
                System.out.println(getString("\nRozpoczynamy nową rundę!"));

                // Pobierz ruch gracza
                System.out.print(playerName + ": ");
                String playerMove = getValidatedMove(scanner);

                // Generowanie ruchów komputerów
                String computer1Move = getRandomChoice();
                String computer2Move = getRandomChoice();

                // Wyświetlenie wyborów
                System.out.println("Komputer 1 wybiera: " + computer1Move);
                System.out.println("Komputer 2 wybiera: " + computer2Move);

                // Wynik rundy
                String result = getRoundResultForOneVsTwo(playerMove, computer1Move, computer2Move);

                // Aktualizacja wyników na podstawie rezultatu
                switch (result) {
                    case "player":
                        scores[0]++; // Gracz zdobywa punkt
                        System.out.println(playerName + " wygrywa rundę, pokonując oba komputery!");
                        break;
                    case "computer1":
                        scores[1]++; // Komputer 1 zdobywa punkt
                        System.out.println("Komputer 1 wygrywa rundę!");
                        break;
                    case "computer2":
                        scores[2]++; // Komputer 2 zdobywa punkt
                        System.out.println("Komputer 2 wygrywa rundę!");
                        break;
                    case "player_and_computer1":
                        scores[0]++;
                        scores[1]++;
                        System.out.println(playerName + " i Komputer 1 wygrywają rundę!");
                        break;
                    case "player_and_computer2":
                        scores[0]++;
                        scores[2]++;
                        System.out.println(playerName + " i Komputer 2 wygrywają rundę!");
                        break;
                    case "computer1_and_computer2":
                        scores[1]++;
                        scores[2]++;
                        System.out.println("Komputer 1 i Komputer 2 wygrywają rundę!");
                        break;
                    case "tie":
                        ties++; // Remis
                        System.out.println("Remis! Nikt nie wygrywa tej rundy.");
                        break;
                    default:
                        System.out.println("Nieprawidłowy wynik rundy!");
                        break;
                }

                // Wyświetlenie wyników rundy
                showScores(new String[]{playerName, "Komputer 1", "Komputer 2"}, scores, ties);

                // Sprawdzenie, czy ktoś osiągnął wymagany wynik
                for (int score : scores) {
                    if (score >= winningScore) {
                        System.out.println(getString("\nGra zakończona! Wynik końcowy:"));
                        showScores(new String[]{playerName, "Komputer 1", "Komputer 2"}, scores, ties);
                        return; // Zakończ grę
                    }
                }
            }
        }


        private static boolean isGroupTie(String... moves) {
            Map<String, Integer> counts = new HashMap<>();
            for (String move : moves) {
                counts.put(move, counts.getOrDefault(move, 0) + 1);
            }
            return counts.size() > 1 && counts.values().stream().allMatch(count -> count == 1);
        }




        /**
         * Sprawdza, czy pierwszy ruch wygrywa nad drugim.
         */








        // Gra 1 gracz vs 3 komputery
        private static void playOneVsThreeComputers(Scanner scanner) {
            Random random = new Random();
            scores = new int[4]; // Gracz + 3 komputery
            ties = 0;

            System.out.println(getString("Rozpoczynamy grę: ") + playerName + " vs 3 Komputery!");
            while (true) {
                System.out.println(getString("\nRozpoczynamy nową rundę!"));

                // Ruch gracza
                String userChoice = getUserMove(scanner);

                // Ruchy komputerów
                String computer1Choice = choices[random.nextInt(choices.length)].toLowerCase();
                String computer2Choice = choices[random.nextInt(choices.length)].toLowerCase();
                String computer3Choice = choices[random.nextInt(choices.length)].toLowerCase();

                System.out.println(getString("Komputer 1 wybiera: ") + computer1Choice);
                System.out.println(getString("Komputer 2 wybiera: ") + computer2Choice);
                System.out.println(getString("Komputer 3 wybiera: ") + computer3Choice);

                // Sprawdzenie remisu grupowego
                if (isGroupTie(userChoice, computer1Choice, computer2Choice, computer3Choice)) {
                    System.out.println(getString("Remis grupowy!"));
                    ties++;
                    continue; // Przejdź do następnej rundy
                }

                // Logika wyniku: kto wygrywa
                if (doesPlayerWin(userChoice, computer1Choice)) scores[0]++;
                if (doesPlayerWin(userChoice, computer2Choice)) scores[0]++;
                if (doesPlayerWin(userChoice, computer3Choice)) scores[0]++;
                if (doesComputerWin(computer1Choice, userChoice)) scores[1]++;
                if (doesComputerWin(computer2Choice, userChoice)) scores[2]++;
                if (doesComputerWin(computer3Choice, userChoice)) scores[3]++;

                // Wywołanie zaktualizowanej metody showScores
                showScores(
                        new String[]{playerName, "Komputer 1", "Komputer 2", "Komputer 3"},
                        scores,
                        ties
                );

                // Sprawdzenie końca gry: jeśli którykolwiek gracz osiągnął wymagany wynik
                for (int score : scores) {
                    if (score >= winningScore) {
                        System.out.println(getString("Gra zakończona! Wynik końcowy:"));
                        showScores(
                                new String[]{playerName, "Komputer 1", "Komputer 2", "Komputer 3"},
                                scores,
                                ties
                        );
                        return; // Zakończenie gry
                    }
                }
            }
        }






        // Gra 2 graczy
        private static void playTwoPlayers(Scanner scanner) {
            scores = new int[2]; // Dla 2 graczy
            ties = 0; // Reset remisów

            // Ustalanie imion graczy
            System.out.print(getString("Podaj imię Gracza 1: "));
            String player1Name = scanner.nextLine().trim();
            if (player1Name.isEmpty()) player1Name = getString("Gracz 1");

            System.out.print(getString("Podaj imię Gracza 2: "));
            String player2Name = scanner.nextLine().trim();
            if (player2Name.isEmpty()) player2Name = getString("Gracz 2");

            // Główna pętla gry
            while (true) {
                System.out.println(getString("\nRozpoczynamy nową rundę!"));

                // Pobranie ruchów
                System.out.print(player1Name + ": ");
                String player1Move = getUserMove(scanner);

                System.out.print(player2Name + ": ");
                String player2Move = getUserMove(scanner);

                // Wynik rundy
                System.out.println(player1Name + getString(" wybiera: ") + player1Move);
                System.out.println(player2Name + getString(" wybiera: ") + player2Move);

                String result = getRoundResult(player1Move, player2Move);

                // Aktualizacja wyników
                if ("tie".equals(result)) {
                    ties++;
                    System.out.println(getString("Remis!"));
                } else if ("player1".equals(result)) {
                    scores[0]++;
                    System.out.println(player1Name + " " + getString("wygrywa rundę!"));
                } else {
                    scores[1]++;
                    System.out.println(player2Name + " " + getString("wygrywa rundę!"));
                }

                // Wyświetlanie wyników po każdej rundzie
                showScores(new String[]{player1Name, player2Name}, scores, ties);

                // Sprawdzenie warunku zwycięstwa
                if (scores[0] == winningScore || scores[1] == winningScore) {
                    System.out.println(getString("Gra zakończona! Wynik końcowy:"));
                    showScores(new String[]{player1Name, player2Name}, scores, ties);
                    break;
                }
            }
        }



        // Gra 3 graczy
        private static void playThreePlayers(Scanner scanner) {
            scores = new int[3]; // Dla 3 graczy
            ties = 0; // Reset remisów

            // Ustalanie imion graczy
            System.out.print(getString("Podaj imię Gracza 1: "));
            String player1Name = scanner.nextLine().trim();
            if (player1Name.isEmpty()) player1Name = getString("Gracz 1");

            System.out.print(getString("Podaj imię Gracza 2: "));
            String player2Name = scanner.nextLine().trim();
            if (player2Name.isEmpty()) player2Name = getString("Gracz 2");

            System.out.print(getString("Podaj imię Gracza 3: "));
            String player3Name = scanner.nextLine().trim();
            if (player3Name.isEmpty()) player3Name = getString("Gracz 3");

            // Główna pętla gry
            while (true) {
                System.out.println(getString("\nRozpoczynamy nową rundę!"));

                // Pobranie ruchów
                System.out.print(player1Name + ": ");
                String player1Move = getUserMove(scanner);

                System.out.print(player2Name + ": ");
                String player2Move = getUserMove(scanner);

                System.out.print(player3Name + ": ");
                String player3Move = getUserMove(scanner);

                // Wyniki rundy pomiędzy graczami
                String result12 = getRoundResult(player1Move, player2Move); // Gracz 1 kontra Gracz 2
                String result23 = getRoundResult(player2Move, player3Move); // Gracz 2 kontra Gracz 3
                String result31 = getRoundResult(player3Move, player1Move); // Gracz 3 kontra Gracz 1

                // Aktualizacja wyników
                if ("tie".equals(result12) && "tie".equals(result23) && "tie".equals(result31)) {
                    ties++;
                    System.out.println(getString("Remis grupowy!"));
                } else {
                    if ("player1".equals(result12)) scores[0]++;
                    if ("player2".equals(result12)) scores[1]++;

                    if ("player2".equals(result23)) scores[1]++;
                    if ("player3".equals(result23)) scores[2]++;

                    if ("player3".equals(result31)) scores[2]++;
                    if ("player1".equals(result31)) scores[0]++;
                }

                // Wyświetlanie wyników po każdej rundzie
                showScores(new String[]{player1Name, player2Name, player3Name}, scores, ties);

                // Sprawdzenie warunku zwycięstwa
                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] == winningScore) {
                        System.out.println(getString("Gra zakończona! Wynik końcowy:"));
                        showScores(new String[]{player1Name, player2Name, player3Name}, scores, ties);
                        return;
                    }
                }
            }
        }




        // Funkcja pomocnicza do wyświetlania dostępnych wyborów
        private static void displayChoices() {
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ". " + choices[i]);
            }
        }

        // Funkcja wybierająca ruch gracza
        private static String getUserMove(Scanner scanner) {
            while (true) {
                try {
                    int userChoice = Integer.parseInt(scanner.nextLine().trim()); // Użycie nextLine() i parsowanie liczby

                    if (userChoice < 1 || userChoice > 3) { // Sprawdzenie poprawności wyboru
                        System.out.println(getString("Niepoprawny wybór, wybierz 1, 2 lub 3!"));
                        displayChoices(); // Wyświetl dostępne opcje
                        continue; // Poproś o wybór ponownie
                    }

                    return choices[userChoice - 1]; // Zwróć ruch odpowiadający wyborowi
                } catch (NumberFormatException e) {
                    System.out.println(getString("Niepoprawny wybór, wpisz liczbę 1, 2 lub 3!"));
                    displayChoices(); // Wyświetl dostępne opcje
                }
            }
        }

        // Funkcja generująca losowy ruch komputera
        private static String getComputerMove() {
            Random rand = new Random();
            int move = rand.nextInt(3); // 0, 1, 2
            return choices[move];
        }
        private static boolean isValidMove(String move) {
            return move.equalsIgnoreCase("rock") || move.equalsIgnoreCase("paper") || move.equalsIgnoreCase("scissors");
        }

        // Funkcja sprawdzająca wynik rundy
        private static String getRoundResult(String move1, String move2) {
            if (move1.equalsIgnoreCase(move2)) {
                return "tie"; // Remis
            }

            // Logika wygranej dla gracza lub komputera
            boolean player1Wins =
                    (move1.equalsIgnoreCase("rock") && move2.equalsIgnoreCase("scissors")) ||
                            (move1.equalsIgnoreCase("scissors") && move2.equalsIgnoreCase("paper")) ||
                            (move1.equalsIgnoreCase("paper") && move2.equalsIgnoreCase("rock"));

            return player1Wins ? "player1" : "computer1";
        }





        // Funkcja aktualizująca wynik gry
        // Funkcja aktualizująca wynik gry dla wielu graczy lub komputerów
        private static void updateScores(String result, int winnerIndex, String[] playerNames) {
            if ("tie".equalsIgnoreCase(result)) {
                ties++;
                System.out.println(getString("Remis!"));
            } else if (winnerIndex >= 0 && winnerIndex < scores.length) {
                scores[winnerIndex]++;
                System.out.println(playerNames[winnerIndex] + " wygrywa rundę!");
            } else {
                System.out.println("Nieprawidłowy wynik rundy: " + result);
            }
        }





        // Funkcja wyświetlająca wyniki
        private static void showScores(String[] playerNames, int[] scores, int ties) {
            System.out.println("\n===== Wyniki =====");
            for (int i = 0; i < playerNames.length; i++) {
                System.out.println(playerNames[i] + ": " + scores[i]);
            }
            System.out.println("Remisy: " + ties);
            System.out.println("===================");
        }
        private static String getRandomChoice() {
            Random random = new Random();
            return choices[random.nextInt(choices.length)];
        }

        private static String getValidatedMove(Scanner scanner) {
            displayChoices();
            while (true) {
                try {
                    int move = Integer.parseInt(scanner.nextLine());
                    if (move > 0 && move <= choices.length) {
                        return choices[move - 1];
                    } else {
                        System.out.println(getString("Niepoprawny wybór, wpisz liczbę od 1 do 3: "));
                    }
                } catch (NumberFormatException e) {
                    System.out.println(getString("Niepoprawny wybór, wpisz liczbę od 1 do 3: "));
                }
            }
        }

        private static String determineResult(String move1, String move2) {
            if (move1.equals(move2)) {
                return "tie";
            }
            if ((move1.equalsIgnoreCase("kamień") && move2.equalsIgnoreCase("nożyce")) ||
                    (move1.equalsIgnoreCase("papier") && move2.equalsIgnoreCase("kamień")) ||
                    (move1.equalsIgnoreCase("nożyce") && move2.equalsIgnoreCase("papier"))) {
                return "player1";
            }
            return "player2";
        }


        private static boolean doesPlayerWin(String playerMove, String computerMove) {
            return (playerMove.equalsIgnoreCase("rock") && computerMove.equalsIgnoreCase("scissors")) ||
                    (playerMove.equalsIgnoreCase("scissors") && computerMove.equalsIgnoreCase("paper")) ||
                    (playerMove.equalsIgnoreCase("paper") && computerMove.equalsIgnoreCase("rock"));
        }

        private static boolean doesComputerWin(String computerMove, String playerMove) {
            return (computerMove.equalsIgnoreCase("rock") && playerMove.equalsIgnoreCase("scissors")) ||
                    (computerMove.equalsIgnoreCase("scissors") && playerMove.equalsIgnoreCase("paper")) ||
                    (computerMove.equalsIgnoreCase("paper") && playerMove.equalsIgnoreCase("rock"));
        }


        private static String getRoundResultForOneVsTwo(String playerMove, String computer1Move, String computer2Move) {
            // Sprawdzanie kto pokonuje kogo
            boolean playerBeatsComp1 = doesPlayerWin(playerMove, computer1Move);
            boolean playerBeatsComp2 = doesPlayerWin(playerMove, computer2Move);
            boolean comp1BeatsPlayer = doesComputerWin(computer1Move, playerMove);
            boolean comp2BeatsPlayer = doesComputerWin(computer2Move, playerMove);
            boolean comp1BeatsComp2 = doesComputerWin(computer1Move, computer2Move);
            boolean comp2BeatsComp1 = doesComputerWin(computer2Move, computer1Move);

            // Wszyscy wybierają ten sam ruch (pełny remis)
            if (playerMove.equals(computer1Move) && playerMove.equals(computer2Move)) {
                return "tie"; // Remis
            }

            // Gracz wygrywa z oboma komputerami
            if (playerBeatsComp1 && playerBeatsComp2) {
                return "player"; // Milo zdobywa punkt
            }

            // Komputer 1 wygrywa z graczem i Komputerem 2
            if (comp1BeatsPlayer && comp1BeatsComp2) {
                return "computer1"; // Komputer 1 zdobywa punkt
            }

            // Komputer 2 wygrywa z graczem i Komputerem 1
            if (comp2BeatsPlayer && comp2BeatsComp1) {
                return "computer2"; // Komputer 2 zdobywa punkt
            }

            // Gracz i Komputer 1 wygrywają swoje pojedynki
            if (playerBeatsComp2 && comp1BeatsPlayer) {
                return "player_and_computer1"; // Milo i Komputer 1 wygrywają
            }

            // Gracz i Komputer 2 wygrywają swoje pojedynki
            if (playerBeatsComp1 && comp2BeatsPlayer) {
                return "player_and_computer2"; // Milo i Komputer 2 wygrywają
            }

            // Oba komputery wygrywają nad graczem
            if (comp1BeatsPlayer && comp2BeatsPlayer) {
                return "computer1_and_computer2"; // Komputer 1 i Komputer 2 zdobywają punkty
            }

            // Domyślnie remis
            return "tie";
        }






        // Funkcja resetująca wyniki
        private static void resetScores(int numberOfPlayers) {
            userScore = 0;
            user2Score = 0;
            user3Score = 0;
            computer1Score = 0;
            computer2Score = 0;
            computer3Score = 0;
            ties = 0;
            scores = new int[numberOfPlayers];

        }

    }
