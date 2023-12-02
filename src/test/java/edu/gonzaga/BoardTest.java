package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    /* checks that the placeToken() method returns the correct value */
    @Test 
    void checkPlaceToken() {
        Board testBoard = new Board();
        Player testPlayer = new Player(1);
        testBoard.setBoard();
        Integer[][] checkBoard = testBoard.getBoard();

        testBoard.placeToken(testPlayer, 1);

        Integer expectedToken = 1;
        Integer actualToken = checkBoard[5][0];
        // check token is in the correct place
        Assertions.assertEquals(expectedToken, actualToken);
    }

    /* checks that the row returned from placeToken() is -1 when the column is full */
    @Test 
    void testFullColumn() {
        Board testBoard = new Board();
        Player testPlayer = new Player(1);
        testBoard.setBoard();

        //fill column
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 3);

        Integer actualIndex = testBoard.placeToken(testPlayer, 3);
        Integer expectedIndex = -1;

        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    /* checks that the method checkIfFourInARow correctly identifies that there
     * are four in a row in the verticle orientation
     */
    @Test 
    void checkFourInARowVerticle() {
        Board testBoard = new Board();
        Player testPlayer = new Player(1);
        testBoard.setBoard();

        // make four in a row
        testBoard.placeToken(testPlayer, 1);
        testBoard.placeToken(testPlayer, 1);
        testBoard.placeToken(testPlayer, 1);
        testBoard.placeToken(testPlayer, 1);

        Boolean actualCheck = testBoard.checkIfFourInARow();
        Assertions.assertTrue(actualCheck);
    }

    /* checks that the method checkIfFourInARow correctly identifies that there
     * are four in a row in the horizontal orientation
     */
    @Test 
    void checkFourInARowHorizontal() {
        Board testBoard = new Board();
        Player testPlayer = new Player(1);
        testBoard.setBoard();

        // make four in a row
        testBoard.placeToken(testPlayer, 1);
        testBoard.placeToken(testPlayer, 2);
        testBoard.placeToken(testPlayer, 3);
        testBoard.placeToken(testPlayer, 4);

        Boolean actualCheck = testBoard.checkIfFourInARow();
        Assertions.assertTrue(actualCheck);
    }

    /* checks that the method checkIfFourInARow correctly identifies that there
     * are four in a row in a diagonal orientation
     */
    @Test 
    void checkFourInARowDiagonal() {
        Board testBoard = new Board();
        Player testPlayer = new Player(1);
        testBoard.setBoard();

        // make four in a row
        testBoard.manuallyPlaceToken(testPlayer, 1, 1);
        testBoard.manuallyPlaceToken(testPlayer, 2, 2);
        testBoard.manuallyPlaceToken(testPlayer, 3, 3);
        testBoard.manuallyPlaceToken(testPlayer, 4, 4);

        Boolean actualCheck = testBoard.checkIfFourInARow();
        Assertions.assertTrue(actualCheck);
    }
}
