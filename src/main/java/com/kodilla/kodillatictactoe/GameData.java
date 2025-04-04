package com.kodilla.kodillatictactoe;

public interface GameData {

    void addCircle(int number);
    void addCross(int number);
    int[] getBoard();
    boolean gameEnds();
    default boolean checkIfDraw(int[] board) {
        boolean result = false;
        int zeroCounter = 0;
        for (int i : board) {
            if (i == 0) {
                zeroCounter++;
            }
        }
        if (zeroCounter == 0) {
            result = true;
            System.out.println("Draw!");
        }
        return result;
    }
}
