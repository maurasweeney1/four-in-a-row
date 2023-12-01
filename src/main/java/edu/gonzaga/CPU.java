package edu.gonzaga;

import java.util.Random;

public class CPU extends Player{

    public CPU(Integer num) {
        color = "purple";
        name = "CPU";
        playerNum = 2;
    }

    /**
    * getter for computer color
    *
    * @param none
    * @return color
    */
    public String getColor() {
        return color;
    }

    /**
    * picks a random column to place a token
    *
    * @param none
    * @return column
    */
    public int placeToken() {
        Random rand = new Random();
        int randCol = rand.nextInt(7);
        randCol++;
        return randCol;
    }

}
