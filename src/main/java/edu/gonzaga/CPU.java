package edu.gonzaga;

import java.util.Random;

public class CPU {
    /** Holds the CPU's set color */
    private String color = "purple";
    /** Holds the CPU's number of wins, throughout each round */
    private Integer score = 0;

    public CPU() {
    }

    public String getColor() {
        return color;
    }

    public void updateScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public int placeToken(Integer column) {
        Random rand = new Random();
        int randCol = rand.nextInt(7);
        return randCol;
    }

}
