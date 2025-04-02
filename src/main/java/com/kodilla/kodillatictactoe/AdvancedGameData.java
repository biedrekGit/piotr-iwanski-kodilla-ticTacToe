package com.kodilla.kodillatictactoe;

public class AdvancedGameData implements GameData {

    public int[] board = new int[100];

    @Override
    public void addCircle(int number) {
        board[number - 1] = 1;
    }

    @Override
    public void addCross(int number) {
        board[number - 1] = 4;
    }

    @Override
    public int[] getBoard() {
        return board;
    }

    @Override
    public boolean gameEnds() {
        return false;
    }
}
