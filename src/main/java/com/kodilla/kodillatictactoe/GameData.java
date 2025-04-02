package com.kodilla.kodillatictactoe;

public interface GameData {

    void addCircle(int number);
    void addCross(int number);
    int[] getBoard();
    boolean gameEnds();
}
