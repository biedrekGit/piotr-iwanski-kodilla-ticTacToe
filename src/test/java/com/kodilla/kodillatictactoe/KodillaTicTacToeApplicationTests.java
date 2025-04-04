package com.kodilla.kodillatictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class KodillaTicTacToeApplicationTests {

    @Nested
    class TestCircleWins {
        @Test
        void testGameEndsWithCirclesRow() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCircle(1);
            standardGame.addCircle(2);
            standardGame.addCircle(3);
            GameData advancedGame = new AdvancedGameData();
            advancedGame.addCircle(56);
            advancedGame.addCircle(57);
            advancedGame.addCircle(58);
            advancedGame.addCircle(59);
            advancedGame.addCircle(60);
            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
        }

        @Test
        void testGameEndsWithCirclesColumn() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCircle(7);
            standardGame.addCircle(4);
            standardGame.addCircle(1);
            GameData advancedGame = new AdvancedGameData();
            advancedGame.addCircle(50);
            advancedGame.addCircle(60);
            advancedGame.addCircle(70);
            advancedGame.addCircle(80);
            advancedGame.addCircle(90);
            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
        }

        @Test
        void testGameEndsWithCirclesDiagonal() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCircle(1);
            standardGame.addCircle(5);
            standardGame.addCircle(9);
            GameData advancedGame1 = new AdvancedGameData();
            advancedGame1.addCircle(30);
            advancedGame1.addCircle(39);
            advancedGame1.addCircle(48);
            advancedGame1.addCircle(57);
            advancedGame1.addCircle(66);
            GameData advancedGame2 = new AdvancedGameData();
            advancedGame2.addCircle(33);
            advancedGame2.addCircle(42);
            advancedGame2.addCircle(51);
            advancedGame2.addCircle(60);
            advancedGame2.addCircle(69);

            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame1.gameEnds();
            boolean testAdvanced2 = advancedGame2.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
            Assertions.assertFalse(testAdvanced2);
        }
    }

    @Nested
    class TestCrossWins {
        @Test
        void testGameEndsWithCrossesRow() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCross(4);
            standardGame.addCross(5);
            standardGame.addCross(6);
            GameData advancedGame = new AdvancedGameData();
            advancedGame.addCross(96);
            advancedGame.addCross(97);
            advancedGame.addCross(98);
            advancedGame.addCross(99);
            advancedGame.addCross(100);
            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
        }

        @Test
        void testGameEndsWithCrossesColumn() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCross(8);
            standardGame.addCross(5);
            standardGame.addCross(2);
            GameData advancedGame = new AdvancedGameData();
            advancedGame.addCross(60);
            advancedGame.addCross(70);
            advancedGame.addCross(80);
            advancedGame.addCross(90);
            advancedGame.addCross(100);
            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
        }

        @Test
        void testGameEndsWithCrossesDiagonal() {
            //Given
            GameData standardGame = new StandardGameData();
            standardGame.addCross(7);
            standardGame.addCross(5);
            standardGame.addCross(3);
            GameData advancedGame = new AdvancedGameData();
            advancedGame.addCross(6);
            advancedGame.addCross(15);
            advancedGame.addCross(24);
            advancedGame.addCross(33);
            advancedGame.addCross(42);
            GameData advancedGame2 = new AdvancedGameData();
            advancedGame2.addCross(33);
            advancedGame2.addCross(42);
            advancedGame2.addCross(51);
            advancedGame2.addCross(60);
            advancedGame2.addCross(69);

            //When
            boolean testStandard = standardGame.gameEnds();
            boolean testAdvanced = advancedGame.gameEnds();
            boolean testAdvanced2 = advancedGame2.gameEnds();
            //Then
            Assertions.assertTrue(testStandard);
            Assertions.assertTrue(testAdvanced);
            Assertions.assertFalse(testAdvanced2);
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
        void testWhenIncorrectInput() {
            //Given
            GameData standardGame = new StandardGameData();
            GameData advancedGame = new AdvancedGameData();
            //When & Then
            Assertions.assertThrows(Exception.class, () -> standardGame.addCircle(11));
            Assertions.assertThrows(Exception.class, () -> advancedGame.addCross(101));
        }
    }

}
