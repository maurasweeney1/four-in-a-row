package edu.gonzaga;

public class Player {
    /** Holds the player's number of wins, throughout each round */
    private Integer score = 0;
    /** Holds the player's chosen color */
    private String color;
    /** Holds the player's name */
    private String name;
    /** Holds whether the player is first or second */
    private Integer playerNum;
    /** Holds whether or not this player is currently taking their turn */
    private boolean currentPlayer = false;

    public Player(Integer num) {
        this.name = "Unknown Player";
        this.color = "white";
        score = 0;
        this.playerNum = num;
    }

    public Player(String name, String color, Integer num) {
        this.name = name;
        this.color = color;
        score = 0;
        this.playerNum = num;
    }

    public boolean getIsCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(boolean currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getPlayerNum() {
        return playerNum;
    }
}
