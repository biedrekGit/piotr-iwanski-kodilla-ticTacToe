package com.kodilla.kodillatictactoe;

public interface GamePresentation {

    void initialScreen(int[] board);
    void showGameBoard(int[] board);
    int chooseField(int[] board);

    default void printRow(int[] board) {
        for (int i : board) {
            if (i == 1) {
                System.out.print("|O");
            } else if (i == 4) {
                System.out.print("|X");
            } else {
                System.out.print("| ");
            }
        }
        System.out.print("|\n");
    };

}
