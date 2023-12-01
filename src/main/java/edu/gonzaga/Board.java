package edu.gonzaga;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class Board {
    /** A 2D array for the columns and rows of the board */
    private Integer[][] board = new Integer[6][7];
    /**
     * all tokens a player can have, holds each player's color's token on the board
     */
    private Token token;
    /** keeps track of the number of rounds to determine current player */

    private Integer roundCount;

    public Board() {
        token = new Token();
        roundCount = 0;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public BufferedImage getPlayerToken(Player player) {
        return token.getPlayerToken(player);
    }

    public void setBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int placeToken(Player player, int column) {
        int index = checkIfValidPlace(column);
        if (index == -1) {
            System.out.println(false);
        } else {
            board[index][column - 1] = player.getPlayerNum();
        }
        roundCount++;
        return index;

    }

    public JLabel getToken(Player player) {
        return token.returnTokenImage(player);
    }

    private int checkIfValidPlace(int column) {
        int index = -1;
        for (int i = 5; i >= 0; i--) {
            if (board[i][column - 1] == 0) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public boolean checkIfFourInARow() {
        int width = 7;
        int height = 6;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int placeOnBoard = board[i][j];
                if (placeOnBoard == 0) {
                    continue;
                } else if (j + 3 < width && placeOnBoard == board[i][j + 1] && placeOnBoard == board[i][j + 2]

                        && placeOnBoard == board[i][j + 3]) { // looks right to see if there is four in a row
                    return true;
                } else if (i > 0 && placeOnBoard == board[i - 1][j] && placeOnBoard == board[i - 2][j]
                        && placeOnBoard == board[i - 3][j]) { // looks up
                    return true;
                } else if (j + 3 < width && i > 0 && placeOnBoard == board[i - 1][j + 1]
                        && placeOnBoard == board[i - 2][j + 2]
                        && placeOnBoard == board[i - 3][j + 3]) { // looks up and to the right
                    return true;
                } else if (j - 3 >= 0 && i > 0 && placeOnBoard == board[i - 1][j - 1]
                        && placeOnBoard == board[i - 2][j - 2]
                        && placeOnBoard == board[i - 3][j - 3]) { // looks up and to the left

                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}