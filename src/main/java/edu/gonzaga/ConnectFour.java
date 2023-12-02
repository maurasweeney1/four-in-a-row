/*
 * Final project main driver class
 * 
 * 
 * Project Description: This program runs the connect four game and allows multiplayer's to play or a single player.
 * If single player is selected then a computer plays the single player. This program includes a graphical user
 * interface that the users can interact with.
 *
 * Contributors: Maya Stelzer, Maura Sweeney, Drew Fitzpatrick, Abby Hidalgo
 * 
 * 
 * Copyright: 2023
 */

package edu.gonzaga;

import javax.swing.JFrame;

/** Main program class for launching your team's program. */
public class ConnectFour {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Connect Four");
        frame.setVisible(true);

        Board board = new Board();

        board.setBoard();

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        CPU computer = new CPU(3);

        frame.showSelectModeScreen(board, player1, player2, computer);

        frame.addButtonCallbackHandlers(board, player1, player2, computer);
    }
}