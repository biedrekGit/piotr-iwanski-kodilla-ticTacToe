package com.kodilla.kodillatictactoe;

public class GameData {


    public int[] symbols = new int[9];

    public void addCircle(int number) {
        if (symbols[number - 1] == 0) {
            symbols[number - 1] = 1;
        } else {
            System.out.println("The field is taken. Try again.");
        }
    }

    public void addCross(int number) {
        if (symbols[number - 1] == 0) {
            symbols[number - 1] = 4;
        } else {
            System.out.println("The field is taken. Try again.");
        }
    }

    public int[] getSymbols() {
        return symbols;
    }

    public boolean gameEnds() {
        boolean result = false;
        //scenario 1: there are 3 identical symbols horizontally
        int counter = 0;
        int lineSum = 0;
        for (int i = 0; i < symbols.length; i++) {
            lineSum = lineSum + symbols[i];
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
            columnSum = symbols[i] + symbols[i + 3] + symbols[i + 6];
            if (columnSum == 3 || columnSum == 12) {
                result = true;
                break;
            }
        }
        // scenario 3: there are 3 identical symbols diagonally
        int diagonalSum1 = symbols[0] + symbols[4] + symbols[8];
        int diagonalSum2 = symbols[2] + symbols[4] + symbols[6];
        if ((diagonalSum1 == 3 || diagonalSum1 == 12) || (diagonalSum2 == 3 || diagonalSum2 == 12)) {
            result = true;
        }
        // scenario 4: there are no free fields left
        int zeroCounter = 0;
        for (int i : symbols) {
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
