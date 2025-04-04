package com.kodilla.kodillatictactoe;

public class AdvancedGameData implements GameData {

    public int[] board = new int[100];

    @Override
    public void addCircle(int number) {
        board[number - 1] = 1;
    }

    @Override
    public void addCross(int number) {
        board[number - 1] = 10;
    }

    @Override
    public int[] getBoard() {
        return board;
    }

    @Override
    public boolean gameEnds() {
        boolean result = false;

        //scenario 1: there are 5 identical symbols horizontally
        for (int i = 0; i < 100; i += 10) {
            for (int j = 0; j < 6; j++) {
                if ((board[j+i] + board[j+i+1] + board[j+i+2] + board[j+i+3] + board[j+i+4]) == 50) {
                    result = true;
                    System.out.println("Cross wins!");
                    break;
                } else if ((board[j+i] + board[j+i+1] + board[j+i+2] + board[j+i+3] + board[j+i+4]) == 5) {
                    result = true;
                    System.out.println("Circle wins!");
                    break;
                }
            }
        }

        //scenario 2: there are 5 identical symbols vertically
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 60; j += 10) {
                if (board[j+i] == 10) {
                    if ((board[j+i] + board[j+i+10] + board[j+i+20] + board[j+i+30] + board[j+i+40]) == 50) {
                        result = true;
                        System.out.println("Cross wins!");
                        break;
                    }
                } else if (board[j+i] == 1) {
                    if ((board[j+i] + board[j+i+10] + board[j+i+20] + board[j+i+30] + board[j+i+40]) == 5) {
                        result = true;
                        System.out.println("Circle wins!");
                        break;
                    }
                }
            }
        }

        //scenario 3: there are 5 identical symbols diagonally
        //top right corner of the board
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 66 - (11*i); j = j + 11) {
                if ((board[j+i] + board[j+i+11] + board[j+i+22] + board[j+i+33] + board[j+i+44]) == 50) {
                    result = true;
                    System.out.println("Cross wins!");
                    break;
                } else if ((board[j+i] + board[j+i+11] + board[j+i+22] + board[j+i+33] + board[j+i+44]) == 5) {
                    result = true;
                    System.out.println("Circle wins!");
                    break;
                }
            }
        }
        //bottom left corner of the board
        for (int i = 10; i < 60; i = i + 10) {
            for (int j = 0; j < 66 - (11*(i/10)); j = j + 11) {
                if ((board[j+i] + board[j+i+11] + board[j+i+22] + board[j+i+33] + board[j+i+44]) == 50) {
                    result = true;
                    System.out.println("Cross wins!");
                    break;
                } else if ((board[j+i] + board[j+i+11] + board[j+i+22] + board[j+i+33] + board[j+i+44]) == 5) {
                    result = true;
                    System.out.println("Circle wins!");
                    break;
                }
            }
        }
        //top left corner
        for (int i = 0; i < 6; i++) {
            for (int j = 9; j <= 54 - (9*i); j = j + 9 ) {
                if ((board[j-i] + board[j-i+9] + board[j-i+18] + board[j-i+27] + board[j-i+36]) == 50) {
                    result = true;
                    System.out.println("Cross wins!");
                    break;
                } else if ((board[j-i] + board[j-i+9] + board[j-i+18] + board[j-i+27] + board[j-i+36]) == 5) {
                    result = true;
                    System.out.println("Circle wins!");
                    break;
                }
            }
        }
        //bottom right corner
        for (int i = 0; i < 60; i+=10) {
            for (int j = 9; j <= 54 - (9*(i/10)); j = j + 9 ) {
                if ((board[j+i] + board[j+i+9] + board[j+i+18] + board[j+i+27] + board[j+i+36]) == 50) {
                    result = true;
                    System.out.println("Cross wins!");
                    break;
                } else if ((board[j+i] + board[j+i+9] + board[j+i+18] + board[j+i+27] + board[j+i+36]) == 5) {
                    result = true;
                    System.out.println("Circle wins!");
                    break;
                }
            }
        }

        // scenario 4: there are no empty fields left
        if(checkIfDraw(board)) {
            result = true;
        }

        return result;
    }
}
