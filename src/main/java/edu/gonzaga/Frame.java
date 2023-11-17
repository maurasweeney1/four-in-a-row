package edu.gonzaga;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;


    public Frame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setMinimumSize(new Dimension(600,600));
        setMaximumSize(new Dimension(600,600));
    }

    public void showStartScreen(Player player1, Player player2) {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Connect Four");
        frame.setVisible(true);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JPanel title = new JPanel();
        JPanel player1Panel = new JPanel();
        JPanel player2Panel = new JPanel();
        JPanel start = new JPanel();

        JLabel intro = new JLabel("Welcome to CONNECT4");
        BufferedImage logo;
        JLabel picLabel = null;
        try {
            logo = ImageIO.read(new File("/images/Logo.png"));
            picLabel = new JLabel(new ImageIcon(logo));
            picLabel.setBounds(50, 130, 100, 150);
            title.add(picLabel);
        } catch (IOException e) {
            System.out.println("unable to find image");
        }

        JLabel player1Name = new JLabel("Enter Player 1 Name: ");
        JTextField player1NameInput = new JTextField(10);
        JLabel player2Name = new JLabel("Enter Player 2 Name: ");
        JTextField player2NameInput = new JTextField(10);
        JLabel player1Color = new JLabel("Enter Player 1 Color: ");
        JLabel player2Color = new JLabel("Enter Player 2 Color: ");
        JButton startGameButton = new JButton("Start Game");

        String[] choices = { "{ SELECT COLOR }", "red", "yellow", "green", "orange", "black" };
        final JComboBox<String> player1ColorInput = new JComboBox<String>(choices);
        player1ColorInput.setVisible(true);

        final JComboBox<String> player2ColorInput = new JComboBox<String>(choices);
        player2ColorInput.setVisible(true);

        startGameButton.setBackground(Color.green);
        startGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                player1.setName(player1NameInput.getText());
                player2.setName(player2NameInput.getText());
                player2.setColor((String) player1ColorInput.getSelectedItem());
                player2.setColor((String) player2ColorInput.getSelectedItem());
                frame.getContentPane().removeAll();
                frame.repaint();
            }
        });

        title.add(intro);
        player1Panel.add(player1Name);
        player1Panel.add(player1NameInput);
        player2Panel.add(player2Name);
        player2Panel.add(player2NameInput);
        player1Panel.add(player1Color);
        player1Panel.add(player1ColorInput);
        player2Panel.add(player2Color);
        player2Panel.add(player2ColorInput);
        start.add(startGameButton);

        frame.getContentPane().add(BorderLayout.NORTH, title);
        frame.getContentPane().add(BorderLayout.WEST, player1Panel);
        frame.getContentPane().add(BorderLayout.EAST, player2Panel);
        frame.getContentPane().add(BorderLayout.SOUTH, start);
        frame.setVisible(true);
    }

    public void showGameScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect4");

        Container gameLayout = getContentPane();
        gameLayout.setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        createGameBoard(gamePanel);
        gameLayout.add(gamePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void hideGameScreen() {
        
    }

    public void createGameBoard(JPanel panel) {
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(7,7,1,1));

        JButton[][] cells = new JButton[7][7];

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));

                if (row == 0) {
                    button.setText("Column " + (col + 1));
                }

                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                button.setBorder(border);

                cells[row][col] = button;
                board.add(button);
            }
        }
        panel.add(board);
    }
}