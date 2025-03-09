package com.kodilla.kodillatictactoe;

public class Main {
    public static void main(String[] args) {

        GamePresentation.initialScreen();

        GameData game1 = new GameData();
        System.out.println("Game  1 starts");
        while (true) {
            GamePresentation.showGameBoard(game1.getBoard());
            if (game1.gameEnds()) {
                break;
            }
            System.out.println("Circle turn. Please choose field:");
            int circleInput = GamePresentation.chooseField(game1.getBoard());
            game1.addCircle(circleInput);
            GamePresentation.showGameBoard(game1.getBoard());
            if (game1.gameEnds()) {
                break;
            }
            System.out.println("Cross turn. Please choose field:");
            int crossInput = GamePresentation.chooseField(game1.getBoard());
            game1.addCross(crossInput);
        }
        System.out.println("Game ended.");

    }
}
