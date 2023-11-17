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
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();

        Integer roundCount = 1;

        System.out.println("What is player 1's name?");
        String player1Name = scanner.nextLine();
        System.out.println("Pick a color");
        String player1Color = scanner.nextLine();


        System.out.println("What is player 2's name? ");
        String player2Name = scanner.nextLine();
        System.out.println("Pick a different color");
        String player2Color = scanner.nextLine();

        Player player1 = new Player(player1Name, player1Color, 1);

        Player player2 = new Player(player2Name, player2Color, 2);

        board.setBoard();

        while (!board.checkIfFourInARow()) {
            System.out.println("What column do you want?");
            Integer column = scanner.nextInt();
            if (roundCount % 2 == 1) {
                board.placeToken(player1.getPlayerNum(), column);
            }
            else {
                board.placeToken(player2.getPlayerNum(), column);
            }
            roundCount++;
            board.printBoard();
        }
        if (roundCount % 2 == 1){
            System.out.println(player1.getName() + " you won!");
        }
        else {
            System.out.println(player2.getName() + " you won!");
        }



    }
}
