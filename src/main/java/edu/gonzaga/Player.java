package edu.gonzaga;

public class Player {
    /** Holds the player's number of wins, throughout each round */
    /** Holds the player's chosen color */
    protected String color;
    /** Holds the player's name */
    protected String name;

    protected Integer playerNum;

    protected boolean currentPlayer = false;

    public Player() {

    }

    public Player(Integer num) {
        this.name = "Unknown Player";
        this.color = "white";
        this.playerNum = num;
    }

    public Player(String name, String color, Integer num) {
        this.name = name;
        this.color = color;
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

    public Integer getPlayerNum() {
        return playerNum;
    }
}
