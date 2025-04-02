package com.kodilla.kodillatictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class AdvancedGamePresentation implements GamePresentation {


    @Override
    public void initialScreen(int[] board) {
        System.out.println("TIC-TAC-TOE");
        System.out.println("Rules are simple. There is a board with 100 empty fields ordered as below.");
        System.out.println("There are 10 columns (from A to J) and 10 rows (from 01 to 10).");
        showGameBoard(board);
        System.out.println("You play either circle 'O' or cross 'X'.");
        System.out.println("In turns you choose 1 field to be taken by your symbol.");
        System.out.println("Choose field by typing a column letter followed be a row number (ex. d05 or D05).");
        System.out.println("First player who gets 5 symbols in straight line wins.");
        System.out.println("Have fun and good luck!");
    }

    @Override
    public void showGameBoard(int[] board) {
        int[] rowOne = Arrays.copyOfRange(board, 0,10);
        int[] rowTwo = Arrays.copyOfRange(board, 10, 20);
        int[] rowThree = Arrays.copyOfRange(board, 20, 30);
        int[] rowFour = Arrays.copyOfRange(board, 30, 40);
        int[] rowFive = Arrays.copyOfRange(board, 40, 50);
        int[] rowSix = Arrays.copyOfRange(board, 50, 60);
        int[] rowSeven = Arrays.copyOfRange(board, 60, 70);
        int[] rowEight = Arrays.copyOfRange(board, 70, 80);
        int[] rowNine = Arrays.copyOfRange(board, 80, 90);
        int[] rowTen = Arrays.copyOfRange(board, 90, 100);

        System.out.println("    A B C D E F G H I J ");
        System.out.print("01 ");
        printRow(rowOne);
        System.out.print("02 ");
        printRow(rowTwo);
        System.out.print("03 ");
        printRow(rowThree);
        System.out.print("04 ");
        printRow(rowFour);
        System.out.print("05 ");
        printRow(rowFive);
        System.out.print("06 ");
        printRow(rowSix);
        System.out.print("07 ");
        printRow(rowSeven);
        System.out.print("08 ");
        printRow(rowEight);
        System.out.print("09 ");
        printRow(rowNine);
        System.out.print("10 ");
        printRow(rowTen);
    }

    @Override
    public int chooseField(int[] board) {
        int result = 0;
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        // validating user input
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            // checking if the input has exactly 3 characters
            if (string.length() > 3) {
                System.out.println("Wrong input. Too many characters. Try again.");
                continue;
            } else {
                // checking if 1st character is a letter within range a-j (not case-sensitive)
                if (!"AaBbCcDdEeFfGgHhIiJj".contains(Character.toString(string.charAt(0)))) {
                    System.out.println("Wrong input. There only 10 columns (from A to J). Try again.");
                    continue;
                } else {
                    String columnLetter = Character.toString(string.charAt(0)).toLowerCase();
                    try {
                        // checking if 2nd and 3rd characters form an integer within range 01-10
                        int tempNumber = Integer.parseInt(string.substring(1, 3));
                        if (tempNumber > 10) {
                            System.out.println("Wrong input. There are only 10 rows from (01 to 10). Try again.");
                            continue;
                        } else {
                            // assigning board number based on the input
                            switch (columnLetter) {
                                case "a" :
                                    number = tempNumber * 10 - 9; break;
                                case "b" :
                                    number = tempNumber * 10 - 8; break;
                                case "c" :
                                    number = tempNumber * 10 - 7; break;
                                case "d" :
                                    number = tempNumber * 10 - 6; break;
                                case "e" :
                                    number = tempNumber * 10 - 5; break;
                                case "f" :
                                    number = tempNumber * 10 - 4; break;
                                case "g" :
                                    number = tempNumber * 10 - 3; break;
                                case "h" :
                                    number = tempNumber * 10 - 2; break;
                                case "i" :
                                    number = tempNumber * 10 - 1; break;
                                case "j" :
                                    number = tempNumber * 10; break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input. Column letter should be followed by two digits (ex. d05). Try again.");
                        continue;
                    }
                }
            }
            // checking if chosen board number is available
            if (board[number - 1] == 0) {
                result = number;
                break;
            } else {
                System.out.println("The field is already occupied. Try again.");
            }
        }
        return result;
    }
}
