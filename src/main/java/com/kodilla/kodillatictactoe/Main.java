package com.kodilla.kodillatictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean appRuns = true;

        while (appRuns) {
            System.out.println("Choose game mode:");
            System.out.println("1 - standard (3x3) - 2 players");
            System.out.println("2 - standard (3x3) - vs computer");
            System.out.println("3 - advanced (10x10) - 2 players");
            System.out.println("4 - advanced (10x10) - vs computer");
            System.out.println("5 - exit");
            int gameMode = 0;
            while (scanner.hasNextLine()) {
                try {
                    int number = scanner.nextInt();
                    if (number > 0 && number <= 5) {
                        gameMode = number;
                        break;
                    } else {
                        System.out.println("Wrong input. Try again. Enter '1','2','3, '4' or '5'.");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input. Try again. Enter '1','2','3, '4' or '5'.");
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
                    gameRunnerVsPlayer(standardGameData, standardGamePresentation);
                    System.out.println("Game ended.");
                    break;
                case 2:
                    GameData standardGameDataVsComp = new StandardGameData();
                    GamePresentation standardGamePresentationVsComp = new StandardGamePresentation();
                    standardGamePresentationVsComp.initialScreen(standardGameDataVsComp.getBoard());
                    System.out.println("Game starts.");
                    gameRunnerVsComp(standardGameDataVsComp, standardGamePresentationVsComp);
                    System.out.println("Game ended.");
                    break;
                case 3:
                    GameData advancedGameData = new AdvancedGameData();
                    GamePresentation advancedGamePresentation = new AdvancedGamePresentation();
                    advancedGamePresentation.initialScreen(advancedGameData.getBoard());
                    System.out.println("Game starts.");
                    gameRunnerVsPlayer(advancedGameData, advancedGamePresentation);
                    System.out.println("Game ended.");
                    break;
                case 4:
                    GameData advancedGameDataVsComp = new AdvancedGameData();
                    GamePresentation advancedGamePresentationVsComp = new AdvancedGamePresentation();
                    advancedGamePresentationVsComp.initialScreen(advancedGameDataVsComp.getBoard());
                    System.out.println("Game starts.");
                    gameRunnerVsComp(advancedGameDataVsComp, advancedGamePresentationVsComp);
                    System.out.println("Game ended.");
                    break;
                case 5:
                    appRuns = false;
                    break;

            }
        }
    }

    private static boolean gameRunner(GameData gameData, GamePresentation gamePresentation) {
        gamePresentation.showGameBoard(gameData.getBoard());
        if (gameData.gameEnds()) {
            return false;
        }
        System.out.println("Circle turn. Please choose field and press 'Enter':");
        int circleInput = gamePresentation.chooseField(gameData.getBoard());
        gameData.addCircle(circleInput);
        gamePresentation.showGameBoard(gameData.getBoard());
        return !gameData.gameEnds();
    }

    private static void gameRunnerVsComp(GameData gameData, GamePresentation gamePresentation) {
        while (gameRunner(gameData, gamePresentation)) {
            System.out.println("Cross turn. Computer chooses:");
            int crossInput;
            while (true) {
                Random random = new Random();
                int randomInt = random.nextInt(gameData.getBoard().length);
                if (gameData.getBoard()[randomInt] == 0) {
                    crossInput = randomInt + 1;
                    break;
                }
            }
            gameData.addCross(crossInput);
        }
    }

    private static void gameRunnerVsPlayer(GameData gameData, GamePresentation gamePresentation) {
        while (gameRunner(gameData, gamePresentation)) {
            System.out.println("Cross turn. Please choose field and press 'Enter':");
            int crossInput = gamePresentation.chooseField(gameData.getBoard());
            gameData.addCross(crossInput);
        }
    }

}
