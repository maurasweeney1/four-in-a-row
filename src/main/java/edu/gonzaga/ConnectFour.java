/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors:
 * 
 * 
 * Copyright: 2023
 */
package edu.gonzaga;

import java.util.Scanner;

/** Main program class for launching your team's program. */
public class ConnectFour {
    public static void main(String[] args) {

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        Frame frame = new Frame();
        frame.showStartScreen(player1, player2);

        Scanner scanner = new Scanner(System.in);

        Board board = new Board();

        Integer roundCount = 1;

        board.setBoard();

        while (board.checkIfFourInARow()) {
            System.out.println("What column do you want?");
            Integer column = scanner.nextInt();
            if (roundCount % 2 == 1) {
                board.placeToken(player1, column);
            } else {
                board.placeToken(player2, column);
            }
            roundCount++;
            board.printBoard();
        }

    }
}
