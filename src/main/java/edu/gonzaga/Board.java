package edu.gonzaga;

public class Board {
    /** A 2D array for the columns and rows of the board */
    private Integer[][] board = new Integer[6][7];

    public Board() {
    }

    public void setBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    public boolean placeToken(Player player, int column) {
        int index = checkIfValidPlace(column);
        if (index == 5) {
            return false;
        } else {
            board[index][column] = player.getPlayerNum();
            return true;
        }
    }

    private int checkIfValidPlace(int column) {
        int index = -1;
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == 0) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public boolean checkIfFourInARow() {
        return true;
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
