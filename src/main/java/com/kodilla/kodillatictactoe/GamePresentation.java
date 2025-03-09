package com.kodilla.kodillatictactoe;

import java.util.Scanner;

public class GamePresentation {

    public static void initialScreen() {
        System.out.println("TIC-TAC-TOE");
        System.out.println("Rules are simple. There is board with 9 empty fields ordered as below. You play either 'X' or 'O'");
        char[] arr = new char[]{'1','2','3','4','5','6','7','8','9',};
        int counter = 0;
        for (char c : arr) {
            System.out.print("|" + c);
            counter++;
            if (counter == 3) {
                System.out.print("|\n");
                counter = 0;
            }
        }
        System.out.println("In turns you choose 1 field to be taken by your symbol");
        System.out.println("First player who gets 3 symbols in straight line wins.");
        System.out.println("Have fun and good luck!");
    }

    public static void showGameBoard(int[] board) {
        int counter = 0;
        for (int i : board) {
            if (i == 1) {
                System.out.print("|O");
            } else if (i == 4) {
                System.out.print("|X");
            } else {
                System.out.print("| ");
            }
            counter++;
            if (counter == 3) {
                System.out.print("|\n");
                counter = 0;
            }
        }
    }

    public static int chooseField(int[] board) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                int number = scanner.nextInt();
                if (number > 0 && number <= 9) {
                    if (board[number - 1] == 0) {
                        result = number;
                        break;
                    } else {
                        System.out.println("The field is already occupied. Try again.");
                    }
                } else {
                    System.out.println("Error! Incorrect Input. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error! Incorrect Input. Try again.");
            } finally {
                scanner.nextLine();
            }
        }
        return result;
    }
}
