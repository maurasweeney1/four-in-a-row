package edu.gonzaga;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;

public class Token {
    /** Holds the player's chosen color */
    private String color;

    BufferedImage yellow, black, green, orange, red;

    public Token() {

    }

    public void setTokens() {
        try {
            yellow = ImageIO.read(new File("images/yellowToken.png/"));
        } catch (IOException e) {
            System.out.println("Cannot find yellow token image");
        }
        try {
            black = ImageIO.read(new File("images/blackToken.png/"));
        } catch (IOException e) {
            System.out.println("Cannot find black token image");
        }
        try {
            green = ImageIO.read(new File("images/greenToken.png/"));
        } catch (IOException e) {
            System.out.println("Cannot find green token image");
        }

        try {
            orange = ImageIO.read(new File("images/orangeToken.png/"));
        } catch (IOException e) {
            System.out.println("Cannot find orange token image");
        }
        try {
            red = ImageIO.read(new File("images/redToken.png/"));
        } catch (IOException e) {
            System.out.println("Cannot find red token image");
        }
    }

    public BufferedImage getPlayerToken(Player player) {
        setTokens();
        if (player.getColor() == "red") {
            return red;
        } else if (player.getColor() == "yellow") {
            return yellow;
        } else if (player.getColor() == "green") {
            return green;
        } else if (player.getColor() == "orange") {
            return orange;
        } else {
            return black;
        }
    }

    public JLabel returnTokenImage(Player player) {
        setTokens();
        JLabel picLabel = null;
        picLabel = new JLabel(new ImageIcon(getPlayerToken(player)));
        picLabel.setBounds(10, 10, 10, 10);
        return picLabel;
    }

    public String getColor() {
        return color;
    }

}