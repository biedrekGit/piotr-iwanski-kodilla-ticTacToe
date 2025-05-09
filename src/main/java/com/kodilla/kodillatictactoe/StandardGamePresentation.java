package com.kodilla.kodillatictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class StandardGamePresentation implements GamePresentation {

    @Override
    public void initialScreen(int[] board) {
        System.out.println("TIC-TAC-TOE");
        System.out.println("Rules are simple. There is a board with 9 empty fields ordered as below.");
        char[] arr = new char[]{'7','8','9','4','5','6','1','2','3',};
        int counter = 0;
        for (char c : arr) {
            System.out.print("|" + c);
            counter++;
            if (counter == 3) {
                System.out.print("|\n");
                counter = 0;
            }
        }
        System.out.println("Fields order corresponds to numbers order on keyboard's numpad.");
        System.out.println("You play either circle 'O' or cross 'X'.");
        System.out.println("In turns you choose 1 field to be taken by your symbol");
        System.out.println("First player who gets 3 symbols in straight line wins.");
        System.out.println("Have fun and good luck!");
    }

    @Override
    public void showGameBoard(int[] board) {
        int[] rowOne = Arrays.copyOfRange(board, 0,3);
        int[] rowTwo = Arrays.copyOfRange(board, 3, 6);
        int[] rowThree = Arrays.copyOfRange(board, 6, 9);

        printRow(rowThree);
        printRow(rowTwo);
        printRow(rowOne);
    }

    @Override
    public int chooseField(int[] board) {
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
                    System.out.println("Error! Incorrect number. Try again.");
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
