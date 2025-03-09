package com.kodilla.kodillatictactoe;

public class GameData {


    public int[] board = new int[9];

    public void addCircle(int number) {
        if (board[number - 1] == 0) {
            board[number - 1] = 1;
        } else {
            System.out.println("The field is taken. Try again.");
        }
    }

    public void addCross(int number) {
        if (board[number - 1] == 0) {
            board[number - 1] = 4;
        } else {
            System.out.println("The field is taken. Try again.");
        }
    }

    public int[] getBoard() {
        return board;
    }

    public boolean gameEnds() {
        boolean result = false;
        //scenario 1: there are 3 identical symbols horizontally
        int counter = 0;
        int lineSum = 0;
        for (int i = 0; i < board.length; i++) {
            lineSum = lineSum + board[i];
            counter++;
            if (counter == 3) {
                if (lineSum == 3 || lineSum == 12) {
                    result = true;
                    break;
                } else {
                    counter = 0;
                    lineSum = 0;
                }
            }
        }
        //scenario 2: there are 3 identical symbols vertically
        int columnSum;
        for (int i = 0; i < 3; i++) {
            columnSum = board[i] + board[i + 3] + board[i + 6];
            if (columnSum == 3 || columnSum == 12) {
                result = true;
                break;
            }
        }
        // scenario 3: there are 3 identical symbols diagonally
        int diagonalSum1 = board[0] + board[4] + board[8];
        int diagonalSum2 = board[2] + board[4] + board[6];
        if ((diagonalSum1 == 3 || diagonalSum1 == 12) || (diagonalSum2 == 3 || diagonalSum2 == 12)) {
            result = true;
        }
        // scenario 4: there are no free fields left
        int zeroCounter = 0;
        for (int i : board) {
            if (i == 0) {
                zeroCounter++;
            }
        }
        if (zeroCounter == 0) {
            result = true;
        }

        return result;
    }


}
