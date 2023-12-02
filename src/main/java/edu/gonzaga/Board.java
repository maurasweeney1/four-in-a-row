package edu.gonzaga;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class Board {
    /** A 2D array for the columns and rows of the board */
    private Integer[][] board = new Integer[6][7];
    /** all tokens a player can have, holds player's color's token on the board */
    private Token token;
    /** keeps track of the number of rounds to determine current player */
    private Integer roundCount;

    public Board() {
        token = new Token();
        roundCount = 0;
    }
    /**
    * getter for roundCount
    *
    * @param none
    * @return Integer of roundCount
    */
    public Integer getRoundCount() {
        return roundCount;
    }

    /**
    * gets the token image of the player
    *
    * @param none
    * @return BufferedImage of token
    */
    public BufferedImage getPlayerToken(Player player) {
        return token.getPlayerToken(player);
    }

    
    /**
    * sets empty board
    *
    * @param none
    * @return none
    */
    public void setBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }
  
    public Integer[][] getBoard() {
        return this.board;
    }


    

    /**
    * checks if column has room to place a token, places token
    *
    * @param player is who is taking turn, column is where the token is trying to go
    * @return int of index of row heigh
    */

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

    /**
     * allows for manually placing a token for testing purposes
     * 
     * @return none
     * @param player
     * @param row
     * @param column
     */
    public void manuallyPlaceToken(Player player, int row, int column){
        board[row - 1][column - 1] = player.getPlayerNum();
    }


    /**
    * checks if column is full, if not returns index of row the token will be in
    *
    * @param column is the column it is checking
    * @return index of row
    */

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

    /**
    * checks if there is a four in a row
    *
    * @param none
    * @return there is a four in a row
    */
    public boolean checkIfFourInARow() {
        int width = 7;
        int height = 6;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int placeOnBoard = board[i][j];
                if (placeOnBoard == 0) {
                    continue;
                }
                // checks for horizontal four in a row
                if (((j + 3) < width) && placeOnBoard == board[i][j + 1] && placeOnBoard == board[i][j + 2]
                        && placeOnBoard == board[i][j + 3]) {
                    return true;
                }
                // checks for vertical four in a row
                if ((i > 2) && (placeOnBoard == board[i - 1][j]) && (placeOnBoard == board[i - 2][j])
                        && (placeOnBoard == board[i - 3][j])) {
                    return true;
                }
                if (((j + 3) < width) && (i > 2) && (placeOnBoard == board[i - 1][j + 1])
                        && (placeOnBoard == board[i - 2][j + 2])
                        && (placeOnBoard == board[i - 3][j + 3])) {
                    return true;
                }
                if ((j > 2) && (i > 2)
                        && ((placeOnBoard == board[i - 1][j - 1]) && (placeOnBoard == board[i - 2][j - 2])
                                && (placeOnBoard == board[i - 3][j - 3]))) {
                    return true;
                }
            }
        }
        return false;
    }
}