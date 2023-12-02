package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    /* checks that a Player's name can be set and returns the correct value */
    @Test
    void testSetName() {
        String expectedName = "Player 1";
        Player testPlayer = new Player();
        testPlayer.setName("Player 1");
        Assertions.assertEquals(expectedName, testPlayer.getName());
    }

    /* checks that Player's color can be set and returns the correct value */
    @Test
    void testSetColor() {
        String expectedColor = "Red";
        Player testPlayer = new Player();
        testPlayer.setColor("Red");
        Assertions.assertEquals(expectedColor, testPlayer.getColor());
    }

    /* checks that a Player's number is correctly set with the constructor and correctly returned */
    @Test
    void testSetNumber() {
        Integer expectedNumber = 2;
        Player testPlayer = new Player("Player 2", "Red", 2);
        Assertions.assertEquals(expectedNumber, testPlayer.getPlayerNum());
    }

}
