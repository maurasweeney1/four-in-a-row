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

import javax.swing.JFrame;

/** Main program class for launching your team's program. */
public class ConnectFour {

    public static void main(String[] args) {

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Connect Four");
        frame.setVisible(true);

        frame.showStartScreen(player1, player2);

        Board board = new Board();

        board.setBoard();

        frame.addButtonCallbackHandlers(board, player1, player2);
    }
}