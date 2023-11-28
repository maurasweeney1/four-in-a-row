package edu.gonzaga;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame {
    private static final int DEFAULT_WIDTH = 715;
    private static final int DEFAULT_HEIGHT = 500;

    // showStartScreen()
    JPanel title = new JPanel();
    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel start = new JPanel();

    JLabel player1Name = new JLabel("Enter Player 1 Name: ");
    JTextField player1NameInput = new JTextField(10);
    JLabel player2Name = new JLabel("Enter Player 2 Name: ");
    JTextField player2NameInput = new JTextField(10);
    JLabel player1Color = new JLabel("Enter Player 1 Color: ");
    JLabel player2Color = new JLabel("Enter Player 2 Color: ");
    JButton startGameButton = new JButton("Start Game");

    // showGameScreen()
    JPanel gamePanel = new JPanel();

    // createGameBoard()
    JPanel board = new JPanel();
    JButton[] columnHeaders = new JButton[7];
    JLabel[][] cells = new JLabel[6][7];

    JButton col1Button = new JButton();
    JButton col2Button = new JButton();
    JButton col3Button = new JButton();
    JButton col4Button = new JButton();
    JButton col5Button = new JButton();
    JButton col6Button = new JButton();
    JButton col7Button = new JButton();

    public Frame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void showStartScreen(Player player1, Player player2) {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        BufferedImage logo;
        JLabel picLabel = null;
        try {
            logo = ImageIO.read(new File("images/Logo.png/"));
            picLabel = new JLabel(new ImageIcon(logo));
            picLabel.setBounds(10, 10, 10, 15);
            title.add(picLabel);
        } catch (IOException e) {
            System.out.println("unable to find image");
            JLabel intro = new JLabel("Welcome to CONNECT4");
            title.add(intro);
        }


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
                getContentPane().removeAll();
                repaint();
                showGameScreen();

            }
        });

        player1Panel.add(player1Name);
        player1Panel.add(player1NameInput);
        player2Panel.add(player2Name);
        player2Panel.add(player2NameInput);
        player1Panel.add(player1Color);
        player1Panel.add(player1ColorInput);
        player2Panel.add(player2Color);
        player2Panel.add(player2ColorInput);
        start.add(startGameButton);

        getContentPane().add(BorderLayout.NORTH, title);
        getContentPane().add(BorderLayout.WEST, player1Panel);
        getContentPane().add(BorderLayout.EAST, player2Panel);
        getContentPane().add(BorderLayout.SOUTH, start);
        setVisible(true);
    }

    public void showGameScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect4");

        Container gameLayout = getContentPane();
        gameLayout.setLayout(new BorderLayout());

        createGameBoard(gamePanel);
        gameLayout.add(gamePanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void hideGameScreen() {

    }

    public void createGameBoard(JPanel panel) {
        board.setLayout(new GridLayout(7, 7, 2, 2));

        col1Button.setText("Column 1");
        columnHeaders[0] = col1Button;
        col1Button.setPreferredSize(new Dimension(50, 50));
        board.add(col1Button);

        col2Button.setText("Column 2");
        columnHeaders[1] = col2Button;
        col2Button.setPreferredSize(new Dimension(50, 50));
        board.add(col2Button);

        col3Button.setText("Column 3");
        columnHeaders[2] = col3Button;
        col3Button.setPreferredSize(new Dimension(50, 50));
        board.add(col3Button);

        col4Button.setText("Column 4");
        columnHeaders[3] = col4Button;
        col4Button.setPreferredSize(new Dimension(50, 50));
        board.add(col4Button);

        col5Button.setText("Column 5");
        columnHeaders[4] = col5Button;
        col5Button.setPreferredSize(new Dimension(50, 50));
        board.add(col5Button);

        col6Button.setText("Column 6");
        columnHeaders[5] = col6Button;
        col6Button.setPreferredSize(new Dimension(50, 50));
        board.add(col6Button);

        col7Button.setText("Column 7");
        columnHeaders[6] = col7Button;
        col7Button.setPreferredSize(new Dimension(50, 50));
        board.add(col7Button);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(50, 50));
                cells[row][col] = label;
                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                label.setBorder(border);
                BufferedImage blank;
                JLabel picLabel = null;
                try {
                    blank = ImageIO.read(new File("images/blank.png/"));
                    picLabel = new JLabel(new ImageIcon(blank));
                    picLabel.setBounds(1, 1, 1, 1);
                    label.add(picLabel);
                } catch (IOException e) {
                    System.out.println("unable to find image");
                }
                board.add(label);
            }
        }

        panel.add(board);
    }

    public void addButtonCallbackHandlers(Board board, Player player1, Player player2) {

        col1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button 1");
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 1);
                /*
                 * cells[][] = getToken
                 * cells[row][col] = label;
                 * Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
                 * label.setBorder(border);
                 * label.add(picLabel);
                 */
            }
        });

        col2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 2);
            }
        });

        col3Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 3);
            }
        });

        col4Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 4);
            }
        });

        col5Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 5);
            }
        });

        col6Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 6);
            }
        });

        col7Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer;
                if (player1.getIsCurrentPlayer()) {
                    currentPlayer = player1;
                } else {
                    currentPlayer = player2;
                }
                board.placeToken(currentPlayer, 7);
            }
        });


    }
}