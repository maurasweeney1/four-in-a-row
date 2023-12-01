package edu.gonzaga;

import java.util.Random;

public class CPU extends Player{

    public CPU(Integer num) {
        color = "purple";
        name = "CPU";
        playerNum = 2;
    }

    public String getColor() {
        return color;
    }

    public int placeToken(Integer column) {
        Random rand = new Random();
        int randCol = rand.nextInt(7);
        return randCol;
    }

}
