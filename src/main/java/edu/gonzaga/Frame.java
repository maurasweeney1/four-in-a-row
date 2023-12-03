package edu.gonzaga;

import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Frame extends JFrame {
    /** the default width for all the windows */
    private static final int DEFAULT_WIDTH = 800;
    /** the default height for all the windows */
    private static final int DEFAULT_HEIGHT = 600;

    // showStartScreen()
    /** panel which holds the title of the game in the intro screens */
    JPanel title = new JPanel();
    /** panel that holds the first players information in the intro screens */
    JPanel player1Panel = new JPanel();
    /** panel that holds the second players information in the intro screens */
    JPanel player2Panel = new JPanel();
    /** panel that holds the start button in the intro screens */
    JPanel start = new JPanel();
    /** label to enter the first players name in the intro screens */
    JLabel player1Name = new JLabel("Enter Player 1 Name: ");
    /** text field to hold the second players name in the intro screens */
    JTextField player1NameInput = new JTextField(10);
    /** label to enter the second players name in the intro screens */
    JLabel player2Name = new JLabel("Enter Player 2 Name: ");
    /** text field to hold the first players name in the intro screens */
    JTextField player2NameInput = new JTextField(10);
    /** label to enter the first players colorin the intro screens */
    JLabel player1Color = new JLabel("Enter Player 1 Color: ");
    /** label to enter the second players color in the intro screens */
    JLabel player2Color = new JLabel("Enter Player 2 Color: ");
    /** button to move to she show game screen screen in the intro screens */
    JButton startGameButton = new JButton("Start Game");

    // showSelectModeScreen()
    /*panel to show if it is player vs cpu or player vs player*/
    JPanel modePanel = new JPanel();
    /*panel to show the player vs player mode */
    JPanel playerPanel = new JPanel();
    /*panel to show if it is cpu vs player mode */
    JPanel cpuPanel = new JPanel();
    /* allows player to pick game mode */
    JButton playerVSplayerButton = new JButton("Player vs Player");
    /*allows player to pick game mode */
    JButton playerVsCPUButton = new JButton("Player vs CPU");

    // showGameScreen()
    /** label to show a message after player 1's turn */
    JLabel player1InspirationMessage = new JLabel();
    /** label to show a message after player 1's token */
    JLabel player1pic = new JLabel();
    /** label to show it is player 1's turn */
    JLabel player1Turn = new JLabel();
    /** label to show a message after player 2's or CPU's token */
    JLabel player2CPUpic = new JLabel();
    /** label to show a message after player 2's or CPU'sturn */
    JLabel player2CPUTurn = new JLabel();
    /** label to show a message after player 2's or CPU'sturn */
    JLabel player2InspirationMessage = new JLabel();


    // createGameBoard()
    /** a 2D array of labels for the grid where tokens are placed */
    JLabel[][] cells = new JLabel[6][7];
    /** Button to place token in column 1 */
    JButton col1Button = new JButton();
    /** Button to place token in column 2 */
    JButton col2Button = new JButton();
    /** Button to place token in column 3 */
    JButton col3Button = new JButton();
    /** Button to place token in column 4 */
    JButton col4Button = new JButton();
    /** Button to place token in column 5 */
    JButton col5Button = new JButton();
    /** Button to place token in column 6 */
    JButton col6Button = new JButton();
    /** Button to place token in column 7 */
    JButton col7Button = new JButton();
    /** Holds the row where a token is placed */
    Integer buttonCallbackRow = 0;
    Player currentPlayer;
    Integer numButtons = 7;

    /** holds whether or not the game is multiplayer */
    boolean isMulti;

    public Frame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    /**
     * Sets up and opens the select mode screen where the user can either choose
     * multiplayer or singleplayer mode
     *
     * @param board, players 1 and 2, and the CPU
     * @return a boolean for whether or not the game is multiplayer
     */
    public boolean showSelectModeScreen(Board board, Player player1, Player player2, CPU computer) {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        BufferedImage logo;
        JLabel picLabel = null;
        try {
            logo = ImageIO.read(new File("images/Logo.png/"));
            picLabel = new JLabel(new ImageIcon(logo));
            picLabel.setBounds(10, 10, 10, 15);
            modePanel.add(picLabel);
        } catch (IOException e) {
            System.out.println("unable to find image");
            JLabel intro = new JLabel("Welcome to CONNECT4");
            modePanel.add(intro);
        }

        playerPanel.add(playerVSplayerButton);
        cpuPanel.add(playerVsCPUButton);

        playerVSplayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isMulti = true;
                getContentPane().removeAll();
                repaint();
                showStartScreen(board, player1, player2, computer);
            }
        });

        playerVsCPUButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isMulti = false;
                getContentPane().removeAll();
                repaint();
                showStartScreenSinglePlayer(board, player1, player2, computer);
            }
        });

        getContentPane().add(BorderLayout.CENTER, modePanel);
        getContentPane().add(BorderLayout.CENTER, playerPanel);
        getContentPane().add(BorderLayout.CENTER, cpuPanel);
        setVisible(true);

        return isMulti;
    }
    /**
     * displays the multiplayer start screen where the player's can enter their
     * names and colors
     *
     * @param board, players 1 and 2, and the CPU
     * @return displays the screen, takes in the players names and colors
     */
    public void showStartScreen(Board board, Player player1, Player player2, CPU computer) {
        JPanel multiInstruction = new JPanel();
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

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

        JLabel errorLabel = new JLabel();

        startGameButton.setBackground(Color.green);
        startGameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if ((String) player2ColorInput.getSelectedItem() == "{ SELECT COLOR }"
                        || (String) player1ColorInput.getSelectedItem() == "{ SELECT COLOR }") {
                    errorLabel.setText("Please choose a color");
                } else if ((String) player2ColorInput.getSelectedItem() == (String) player1ColorInput
                        .getSelectedItem()) {
                    errorLabel.setText("You cannot choose the same color");
                } else {
                    if (player1NameInput.getText().isEmpty()) {
                        player1.setName("Player " + player1.getPlayerNum());
                    } else {
                        player1.setName(player1NameInput.getText());
                    }
                    if (player2NameInput.getText().isEmpty()) {
                        player2.setName("Player " + player2.getPlayerNum());
                    } else {
                        player2.setName(player2NameInput.getText());
                    }
                    player1.setColor((String) player1ColorInput.getSelectedItem());
                    player2.setColor((String) player2ColorInput.getSelectedItem());
                    getContentPane().removeAll();
                    repaint();
                    showGameScreen(board, player1, player2, computer);
                }
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
        start.add(errorLabel);
        start.add(startGameButton);

        BufferedImage multiPlayerInstruction;
        JLabel label = null;
        try {
            multiPlayerInstruction = ImageIO.read(new File("images/MultiPlayerInstructions.png/"));
            label = new JLabel(new ImageIcon(
                    new ImageIcon(multiPlayerInstruction).getImage().getScaledInstance(600, 100, Image.SCALE_DEFAULT)));
            label.setBounds(0, 0, 2, 10);
            multiInstruction.add(label);
        } catch (IOException e) {
            System.out.println("unable to find image");
            JLabel label2 = new JLabel("Welcome to CONNECT4");
            multiInstruction.add(label2);
        }

        getContentPane().add(BorderLayout.CENTER, title);
        getContentPane().add(BorderLayout.CENTER, player1Panel);
        getContentPane().add(BorderLayout.CENTER, player2Panel);
        getContentPane().add(BorderLayout.CENTER, multiInstruction);
        getContentPane().add(BorderLayout.CENTER, start);
        setVisible(true);
    }

    /**
     * displays the singleplayer start screen where the player can enter their name
     * and color
     *
     * @param board, players 1 and 2, and the CPU
     * @return displays the screen, takes in the player's name and color
     */
    public void showStartScreenSinglePlayer(Board board, Player player1, Player player2, CPU computer) {
        JPanel singleInstruction = new JPanel();
        setPlayerIcons(board, player1, computer);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

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

        JLabel errorLabel = new JLabel();

        startGameButton.setBackground(Color.green);
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((String) player1ColorInput.getSelectedItem() == "{ SELECT COLOR }") {
                    errorLabel.setText("Please choose a color");

                } else {
                    if (player1NameInput.getText().isEmpty()) {
                        player1.setName("Player " + player1.getPlayerNum());
                    } else {
                        player1.setName(player1NameInput.getText());
                    }
                    player1.setColor((String) player1ColorInput.getSelectedItem());
                    getContentPane().removeAll();
                    repaint();

                    showGameScreen(board, player1, player2, computer);
                }
            }
        });

        player1Panel.add(player1Name);
        player1Panel.add(player1NameInput);
        player1Panel.add(player1Color);
        player1Panel.add(player1ColorInput);
        start.add(errorLabel);
        start.add(startGameButton);

        BufferedImage singlePlayerInstruction;
        JLabel label = null;
        try {
            singlePlayerInstruction = ImageIO.read(new File("images/SinglePlayerInstructions.png/"));
            label = new JLabel(new ImageIcon(new ImageIcon(singlePlayerInstruction).getImage().getScaledInstance(700,
                    150, Image.SCALE_DEFAULT)));
            label.setBounds(0, 0, 2, 10);
            singleInstruction.add(label);
        } catch (IOException e) {
            System.out.println("unable to find image");
            JLabel label2 = new JLabel("Welcome to CONNECT4");
            singleInstruction.add(label2);
        }

        getContentPane().add(BorderLayout.CENTER, title);
        getContentPane().add(BorderLayout.CENTER, player1Panel);
        getContentPane().add(BorderLayout.CENTER, player2Panel);
        getContentPane().add(BorderLayout.CENTER, singleInstruction);
        getContentPane().add(BorderLayout.CENTER, start);
        setVisible(true);
    }
    /**
     * Displays the game screen with the game board and each player or CPU
     *
     * @param board, players 1 and 2, and the CPU
     * @return the screen is displayed, takes in information regarding each players
     *         token placement
     */
    public void showGameScreen(Board board, Player player1, Player player2, CPU computer) {
        Container gameLayout = getContentPane();
        JPanel gamePanel = new JPanel();
        JPanel player1IconPanel = new JPanel();
        JPanel player2CPUIconPanel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect4");

        gameLayout.setLayout(new BorderLayout());

        player1IconPanel.setLayout(new BoxLayout(player1IconPanel, BoxLayout.PAGE_AXIS));
        player1IconPanel.add(player1pic);
        player1IconPanel.add(player1Turn);
        player1IconPanel.add(player1InspirationMessage);
        player1Turn.setPreferredSize(new Dimension(20, 100));
        player1Turn.setVisible(true);

        player2CPUIconPanel.setLayout(new BoxLayout(player2CPUIconPanel, BoxLayout.PAGE_AXIS));
        player2CPUIconPanel.add(player2CPUpic);
        player2CPUIconPanel.add(player2CPUTurn);
        player2CPUIconPanel.add(player2InspirationMessage);
        player2CPUTurn.setPreferredSize(new Dimension(20, 100));
        player2CPUTurn.setVisible(false);

        createGameBoard(gamePanel);

        gameLayout.add(gamePanel, BorderLayout.CENTER);
        gameLayout.add(player1IconPanel, BorderLayout.WEST);
        gameLayout.add(player2CPUIconPanel, BorderLayout.EAST);

        if (isMulti) {
            setPlayerIcons(board, player1, player2);
        } else {
            setPlayerIcons(board, player1, computer);
        }

        setVisible(true);
    }
    /**
     * sets up the grid containing the game board
     *
     * @param panel it exists in
     * @return the game board is set to the screen
     */
    public void createGameBoard(JPanel panel) {
        JButton[] columnHeaders = new JButton[7];
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(7, 7, 2, 2));
        col1Button.setText("↓");
        columnHeaders[0] = col1Button;
        col1Button.setPreferredSize(new Dimension(50, 50));
        board.add(col1Button);
        col2Button.setText("↓");
        columnHeaders[1] = col2Button;
        col2Button.setPreferredSize(new Dimension(50, 50));
        board.add(col2Button);

        col3Button.setText("↓");
        columnHeaders[2] = col3Button;
        col3Button.setPreferredSize(new Dimension(50, 50));
        board.add(col3Button);

        col4Button.setText("↓");
        columnHeaders[3] = col4Button;
        col4Button.setPreferredSize(new Dimension(50, 50));
        board.add(col4Button);

        col5Button.setText("↓");
        columnHeaders[4] = col5Button;
        col5Button.setPreferredSize(new Dimension(50, 50));
        board.add(col5Button);

        col6Button.setText("↓");
        columnHeaders[5] = col6Button;
        col6Button.setPreferredSize(new Dimension(50, 50));
        board.add(col6Button);

        col7Button.setText("↓");
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
                board.add(label);
            }
        }

        panel.add(board);
    }
    /**
     * creates action listeners for each column a token can be placed in, places the
     * token, and updates the screen
     *
     * @param board, players 1 and 2, and the CPU
     * @return the screen displays changes based on the player's placement, checks
     *         for four in a row
     */
    public void addButtonCallbackHandlers(Board board, Player player1, Player player2, CPU computer) {

        col1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 1, computer)) {
                    col1Button.removeActionListener(this);
                }
            }
        });

        col2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 2, computer)) {
                    col2Button.removeActionListener(this);
                }
            }
        });

        col3Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 3, computer)) {
                    col3Button.removeActionListener(this);
                }
            }
        });

        col4Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 4, computer)) {
                    col4Button.removeActionListener(this);
                }
            }
        });

        col5Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 5, computer)) {
                    col5Button.removeActionListener(this);
                }
            }
        });

        col6Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 6, computer)) {
                    col6Button.removeActionListener(this);
                }
            }
        });

        col7Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!canTakeTurn(board, player1, player2, 7, computer)) {
                    col7Button.removeActionListener(this);
                }
            }
        });
    }
    /**
     * checks if the selected column is a valid place, places the token for player
     * or CPU, checks for four in a row, and either updates the screen, displays a
     * new screen for a winner, or displays a screen for a tie
     *
     * @param board, players 1 and 2, the selected column and the CPU
     * @return updates the screen and placement on the board
     */
    private boolean canTakeTurn(Board board, Player player1, Player player2, Integer column, CPU computer) {
        if (isMulti) {
            if (board.getRoundCount() % 2 == 0) {
                currentPlayer = player1;
                player1Turn.setVisible(false);
                player2CPUTurn.setVisible(true);
                player1InspirationMessage.setVisible(true);
                player2InspirationMessage.setVisible(false);
                player1InspirationMessage.setText(setInspirationalMessage());
            } else {
                player2InspirationMessage.setVisible(true);
                player1InspirationMessage.setVisible(false);
                player2InspirationMessage.setText(setInspirationalMessage());
                currentPlayer = player2;
                player1Turn.setVisible(true);
                player2CPUTurn.setVisible(false);
            }
        } else {
            currentPlayer = player1;
            if (board.getRoundCount() % 2 == 0) {
                player1Turn.setVisible(false);
                player2CPUTurn.setVisible(true);
            } else {
                player1Turn.setVisible(true);
                player2CPUTurn.setVisible(false);
            }
        }
        buttonCallbackRow = board.placeToken(currentPlayer, column);
        JLabel label = cells[buttonCallbackRow][column - 1];
        label.setIcon(new ImageIcon(new ImageIcon(board.getPlayerToken(currentPlayer)).getImage().getScaledInstance(50,
                50, Image.SCALE_DEFAULT)));
        if (buttonCallbackRow == 0) {
            if (numButtons == 1) {
                getContentPane().removeAll();
                repaint();
                if (isMulti) {
                    showTieScreen(player1, player2);
                } else {
                    showTieScreen(player1, computer);
                }
            } else {
                numButtons--;
                return false;
            }
        } else if (board.checkIfFourInARow()) {
            getContentPane().removeAll();
            repaint();
            showWinnerScreen(currentPlayer);
            return true;
        }

        if (!isMulti) {
            player1InspirationMessage.setVisible(true);
            player1InspirationMessage.setText(setInspirationalMessage());
            player1Turn.setVisible(false);
            player2CPUTurn.setVisible(true);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    Integer computerColumn = computer.placeToken();
                    buttonCallbackRow = board.placeToken(computer, computerColumn);

                    JLabel CPUlabel = cells[buttonCallbackRow][computerColumn - 1];
                    CPUlabel.setIcon(new ImageIcon(new ImageIcon(board.getPlayerToken(computer)).getImage()
                            .getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
                    player1Turn.setVisible(true);
                    player2CPUTurn.setVisible(false);
                    player1InspirationMessage.setVisible(false);
                }
            };
            long delay = 750L;
            timer.schedule(task, delay);

            if (buttonCallbackRow == 0) {
                return false;
            } else if (board.checkIfFourInARow()) {
                getContentPane().removeAll();
                repaint();
                showWinnerScreen(computer);
            }
        }
        return true;
    }
    /**
     * displays a screen showing that both players tied
     *
     * @param player1 and player 2
     * @return updates the screen
     */
    public void showTieScreen(Player player1, Player player2) {
        ImageIcon imageIcon = new ImageIcon("images/winScreenLogo.png");
        Image image = imageIcon.getImage();

        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel scaledImageLabel = new JLabel(new ImageIcon(scaledImage));
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel textLabel = new JLabel(
                player1.getName() + " and " + player2.getName() + " tied! Come back and play again soon!");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));

        JPanel tiePanel = new JPanel();
        tiePanel.add(imageLabel);

        getContentPane().add(BorderLayout.NORTH, textLabel);
        getContentPane().add(tiePanel);
        setVisible(true);
        pack();
    }
    /**
     * displays a screen showing that one player won
     *
     * @param  winner
     * @return updates the screen
     */
    public void showWinnerScreen(Player winner) {
        ImageIcon imageIcon = new ImageIcon("images/winScreenLogo.png");
        Image image = imageIcon.getImage();

        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel scaledImageLabel = new JLabel(new ImageIcon(scaledImage));
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel textLabel = new JLabel("Congratulations! " + winner.getName() + " won! Come back and play soon!");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));

        JPanel winPanel = new JPanel();
        winPanel.add(imageLabel);

        getContentPane().add(BorderLayout.NORTH, textLabel);
        getContentPane().add(winPanel);
        pack();
        setVisible(true);
    }
    /**
     * displays the tokens of each player and who's turn it currently is
     *
     * @param board, player 1 and player 2 or the CPU
     * @return displays the tokens and the current players turn
     */
    private void setPlayerIcons(Board board, Player player1, Player player2CPU) {
        player1pic.setIcon(new ImageIcon(new ImageIcon(board.getPlayerToken(player1)).getImage().getScaledInstance(150,
                150, Image.SCALE_DEFAULT)));
        player1Turn.setText(player1.getName() + " its your turn!");

        player2CPUpic.setIcon(new ImageIcon(new ImageIcon(board.getPlayerToken(player2CPU)).getImage()
                .getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

        if (isMulti) {
            player2CPUTurn.setText(player2CPU.getName() + " its your turn!");
        } else {
            player2CPUTurn.setText("Its the computer's turn!");
        }
    }
    /**
     * provides a random inspirational message to the player that just placed their
     * token
     *
     * @return a String containing the message
     */
    private String setInspirationalMessage() {
        String[] messages = { "Great move!", "Keep it up!", "Amazing!", "You can do it!", "Good strategy!",
                "Nice!", "Very impressive!", "Genius!", "Well done!", "Nice one!", "You're a star!" };
        Random rand = new Random();
        int randIndex = rand.nextInt(10);
        return messages[randIndex];
    }
}