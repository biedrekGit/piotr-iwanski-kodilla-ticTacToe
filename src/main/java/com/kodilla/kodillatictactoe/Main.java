package com.kodilla.kodillatictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean appRuns = true;

        while (appRuns) {
            System.out.println("Choose game mode:");
            System.out.println("1 - standard (3x3)");
            System.out.println("2 - advanced (10x10)");
            System.out.println("3 - exit");
            int gameMode = 0;
            while (scanner.hasNextLine()) {
                try {
                    int number = scanner.nextInt();
                    if (number > 0 && number <= 3) {
                        gameMode = number;
                        break;
                    } else {
                        System.out.println("Wrong input. Try again. Enter '1','2' or '3'.");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Try again. Enter '1', '2' or '3'.");
                } finally {
                    scanner.nextLine();
                }
            }
            switch (gameMode) {
                case 1 :
                    GameData standardGameData = new StandardGameData();
                    GamePresentation standardGamePresentation = new StandardGamePresentation();
                    standardGamePresentation.initialScreen(standardGameData.getBoard());
                    System.out.println("Game starts.");
                    while (true) {
                        standardGamePresentation.showGameBoard(standardGameData.getBoard());
                        if (standardGameData.gameEnds()) {
                            break;
                        }
                        System.out.println("Circle turn. Please choose field and press 'Enter':");
                        int circleInput = standardGamePresentation.chooseField(standardGameData.getBoard());
                        standardGameData.addCircle(circleInput);
                        standardGamePresentation.showGameBoard(standardGameData.getBoard());
                        if (standardGameData.gameEnds()) {
                            break;
                        }
                        System.out.println("Cross turn. Please choose field and press 'Enter':");
                        int crossInput = standardGamePresentation.chooseField(standardGameData.getBoard());
                        standardGameData.addCross(crossInput);
                    }
                    System.out.println("Game ended.");
                    break;
                case 2:
                    System.out.println("to be implemented");
                    GameData advancedGameData = new AdvancedGameData();
                    GamePresentation adancedGamePresentation = new AdvancedGamePresentation();
                    adancedGamePresentation.initialScreen(advancedGameData.getBoard());
                    System.out.println("Game starts.");
                    while (true) {
                        adancedGamePresentation.showGameBoard(advancedGameData.getBoard());
                        if (advancedGameData.gameEnds()) {
                            break;
                        }
                        System.out.println("Circle turn. Please choose field and press 'Enter':");
                        int circleInput = adancedGamePresentation.chooseField(advancedGameData.getBoard());
                        advancedGameData.addCircle(circleInput);
                        adancedGamePresentation.showGameBoard(advancedGameData.getBoard());
                        if (advancedGameData.gameEnds()) {
                            break;
                        }
                        System.out.println("Cross turn. Please choose field and press 'Enter':");
                        int crossInput = adancedGamePresentation.chooseField(advancedGameData.getBoard());
                        advancedGameData.addCross(crossInput);
                    }
                    System.out.println("Game ended.");
                    break;

                case 3:
                    appRuns = false;
                    break;

            }
        }
    }
}
