package edu.gonzaga;

public class Player {
    /** Holds the player's chosen color */
    protected String color;
    /** Holds the player's name */
    protected String name;
    /** Holds the player number which is put into the places on the board*/
    protected Integer playerNum;

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

    /**
     * This function gets the private attribute from the player class
     *
     * @return the string holding the players name
     */
    public String getName() {
        return name;
    }
    /**
     * This function sets the private attribute from the player class that indicates the name of the player
     *
     * @param name string holding the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This function gets the private attribute from the player class
     *
     * @return the string holding the color requested by the player
     */
    public String getColor() {
        return color;
    }
    /**
     * This getter gets the private attribute from the player class
     *
     * @param color string input from the player on what color they want
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * This function gets the integer associated with the player
     *
     * @return an integer
     */
    public Integer getPlayerNum() {
        return playerNum;
    }
}
