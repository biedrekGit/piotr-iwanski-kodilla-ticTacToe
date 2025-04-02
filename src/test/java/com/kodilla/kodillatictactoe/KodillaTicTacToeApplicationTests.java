package com.kodilla.kodillatictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class KodillaTicTacToeApplicationTests {

    @Nested
    class TestCircleWins {
        @Test
        void testGameEndsWithCirclesRow() {
            //Given
            GameData game = new StandardGameData();
            game.addCircle(1);
            game.addCircle(2);
            game.addCircle(3);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }

        @Test
        void testGameEndsWithCirclesColumn() {
            //Given
            GameData game = new StandardGameData();
            game.addCircle(7);
            game.addCircle(4);
            game.addCircle(1);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }

        @Test
        void testGameEndsWithCirclesDiagonal() {
            //Given
            GameData game = new StandardGameData();
            game.addCircle(1);
            game.addCircle(5);
            game.addCircle(9);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }
    }

    @Nested
    class TestCrossWins {
        @Test
        void testGameEndsWithCrossesRow() {
            //Given
            GameData game = new StandardGameData();
            game.addCross(1);
            game.addCross(2);
            game.addCross(3);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }

        @Test
        void testGameEndsWithCrossesColumn() {
            //Given
            GameData game = new StandardGameData();
            game.addCross(7);
            game.addCross(4);
            game.addCross(1);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }

        @Test
        void testGameEndsWithCrossesDiagonal() {
            //Given
            GameData game = new StandardGameData();
            game.addCross(1);
            game.addCross(5);
            game.addCross(9);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }

    }

    @Nested
    class TestDraw {
        @Test
        void testGameEndsInDraw() {
            //Given
            GameData game = new StandardGameData();
            game.addCircle(5);
            game.addCross(1);
            game.addCircle(2);
            game.addCross(8);
            game.addCircle(3);
            game.addCross(7);
            game.addCircle(4);
            game.addCross(6);
            game.addCircle(9);

            //When
            boolean test = game.gameEnds();
            boolean result = true;

            //Then
            Assertions.assertEquals(result, test);
        }
    }

    @Nested
    class TestWrongInput {
        @Test
        void testAddCircleWhenIncorrectInput() {
            //Given


            //When


            //Then

        }
    }


}
