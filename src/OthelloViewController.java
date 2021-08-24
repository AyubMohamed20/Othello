/**
 * File name: OthelloViewController
 * Author: Ayub Mohamed, 040899407
 * Date: November 15th, 2020
 * Purpose: to create a graphical user interface of the game othello
 * Class list: Controller, OthelloViewController
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create Othello application GUI.
 *
 * @author AyubMohamed
 * @version 1
 * @see None
 */
public class OthelloViewController extends JFrame {

    /**
     * serial Version UID
     */
    private static final long serialVersionUID = 1L;
    /**
     * Main frame of application
     */
    public JFrame frame;
    /**
     * Model for current game
     */
    private OthelloModel model;
    /**
     * Controller for button
     */
    private Controller game;
    /**
     * Text field beside submit button
     */
    private JTextField textField;
    /**
     * Panel for pink area
     */
    private JPanel pinkPanel;
    /**
     * Show valid moves checkbox panel
     */
    private JPanel checkBoxPanel;
    /**
     * Show valid moves checkbox
     */
    private JCheckBox showMovesCheckBox;
    /**
     * panel for submit button and text field
     */
    private JPanel submitPanel;
    /**
     * submit button
     */
    private JButton submitButton;
    /**
     * Player panel for below the pink area
     */
    private JPanel playerPanel;
    /**
     * Player 1 text in player panel
     */
    private JLabel player1PiecesLabel;
    /**
     * Player 2 text in player panel
     */
    private JLabel player2PiecesLabel;
    /**
     * Number of pieces for player 1
     */
    private JLabel player1PiecesNumLabel;
    /**
     * Number of pieces for player 2
     */
    private JLabel player2PiecesNumLabel;
    /**
     * Label for the white pieces in player panel
     */
    private JLabel whitePieceLabel;
    /**
     * Label for the black pieces in player panel
     */
    private JLabel blackPieceLabel;
    /**
     * White piece icon
     */
    private ImageIcon player2Piece;
    /**
     * black piece icon
     */
    private ImageIcon player1Piece;
    /**
     * Panel for board
     */
    private JPanel boardPanel;
    /**
     * Boolean for color order on board
     */
    private boolean colorLabel;
    /**
     * Two dimensional array for board
     */
    private JLabel[][] squares;
    /**
     * Array for button on side and below board
     */
    private JButton[] boardButtons;
    /**
     * scrollPane for text area when needed
     */
    private JScrollPane scrollPane;
    /**
     * JTextArea for pink area
     */
    private JTextArea pinkPanelTextArea;
    /**
     * Menu bar
     */
    private JMenuBar menuBar;
    /**
     * File on menu bar
     */
    private JMenu mnFile;
    /**
     * Game on menu bar
     */
    private JMenu mnGame;
    /**
     * Help on menu bar
     */
    private JMenu mnHelp;
    /**
     * letter is Check
     */
    private boolean letterCheck = false;
    /**
     * number is Check
     */
    private boolean numberCheck = false;
    /**
     * letter position
     */
    private int letterPosition = -1;
    /**
     * number position
     */
    private int numberPosition = -1;
    /**
     * players turn
     */
    private boolean playerTurn = true;
    /**
     * check mark icon
     */
    private ImageIcon checkmark;
    /**
     * Menu item about
     */
    private JMenuItem mntmAbout;
    /**
     * Menu item load
     */
    private JMenuItem mntmLoad;
    /**
     * Menu item save
     */
    private JMenuItem mntmSave;
    /**
     * Menu item exit
     */
    private JMenuItem mntmExit;
    /**
     * Menu for Reskin Pieces
     */
    private JMenu mnReskinPieces;
    /**
     * Radio Button Menu Item for normal pieces
     */
    private JRadioButtonMenuItem rdbtnmntmNormalPieces;
    /**
     * Radio Button Menu Item for cats and dogs pieces
     */
    private JRadioButtonMenuItem rdbtnmntmCatsVsDogs;
    /**
     * Radio Button Menu Item for pumpkins and bats pieces
     */
    private JRadioButtonMenuItem rdbtnmntmPumpkinsVsBats;
    /**
     * debug scenario set by user
     */
    private int debugScenario = 0;
    /**
     * Menu debug scenario
     */
    private JMenu mnDebugScenarios;
    /**
     * Radio Button Menu Item for normal game
     */
    private JRadioButtonMenuItem rdbtnmntmNormalGame;
    /**
     * Radio Button Menu Item for coner test
     */
    private JRadioButtonMenuItem rdbtnmntmConerTest;
    /**
     * Radio Button Menu Item for side tests
     */
    private JRadioButtonMenuItem rdbtnmntmSideTests;
    /**
     * Radio Button Menu Item for CaptureTest1
     */
    private JRadioButtonMenuItem rdbtnmntmxCaptureTest1;
    /**
     * Radio Button Menu Item for CaptureTest2
     */
    private JRadioButtonMenuItem rdbtnmntmxCaptureTest2;
    /**
     * Radio Button Menu Item for empty board
     */
    private JRadioButtonMenuItem rdbtnmntmEmptyBoard;
    /**
     * Radio Button Menu Item for InnerSquareTest
     */
    private JRadioButtonMenuItem rdbtnmntmInnerSquareTest;
    /**
     * Create the application. Calls the initialize method which crates the GUI
     */
    public OthelloViewController() {
        model = new OthelloModel();
        model.initialize(0);
        initialize();
        game = new Controller();
        skipButton();
        updateUI();
        checkmark = new ImageIcon(OthelloViewController.class.getResource("/resources/checkmark.png"));
    }

    /**
     *
     * Create Button from data
     *
     * @param text, ac, fgc, bgc, handler
     * @return button
     */
    JButton createButton(String text, String ac, Color fgc, Color bgc, ActionListener handler) {
        JButton button = new JButton(text);
        button.setActionCommand(ac);
        button.setForeground(fgc);
        button.setBackground(bgc);
        button.addActionListener(handler);

        return button;
    }

    /**
     * Initialize the contents of the frame. Crates the Othello GUI
     */
    private void initialize() {

        // -------------------------------------Main Frame-----------------------
        frame = new JFrame();
        frame.setBounds(100, 100, 1010, 644);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);

        // -------------------------------------Menu Bar-----------------------

        // Menu bar
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Menu item file
        mnFile = new JMenu("File");
        menuBar.add(mnFile);

        // Menu item New game
        JMenuItem mntmNewGame = new JMenuItem("New Game");
        mntmNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        mnFile.add(mntmNewGame);

        // Menu item Load
        mntmLoad = new JMenuItem("Load");
        mntmLoad.setForeground(Color.LIGHT_GRAY);
        mnFile.add(mntmLoad);

        // Menu item Save
        mntmSave = new JMenuItem("Save");
        mntmSave.setForeground(Color.LIGHT_GRAY);
        mnFile.add(mntmSave);

        // Menu item Exit
        mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnFile.add(mntmExit);

        // Menu item Game
        mnGame = new JMenu("Game");
        menuBar.add(mnGame);

        // Reskin Pieces
        mnReskinPieces = new JMenu("Reskin Pieces");
        mnGame.add(mnReskinPieces);

        // When a reskin pieces selected all other pieces will be unselected the size
        // will be set, UI will be updated
        // Normal Pieces (Black/White) pieces
        rdbtnmntmNormalPieces = new JRadioButtonMenuItem("Normal Pieces (Black/White)");
        rdbtnmntmNormalPieces.setSelected(true);
        rdbtnmntmNormalPieces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnmntmCatsVsDogs.setSelected(false);
                rdbtnmntmPumpkinsVsBats.setSelected(false);
                player2Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/white_s.png"));
                player1Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/black_s.png"));
                blackPieceLabel.setIcon(player1Piece);
                whitePieceLabel.setIcon(player2Piece);
                whitePieceLabel.setLocation(379, 44);
                whitePieceLabel.setSize(34, 42);
                blackPieceLabel.setLocation(380, 1);
                blackPieceLabel.setSize(34, 42);
                updateUI();
            }
        });
        mnReskinPieces.add(rdbtnmntmNormalPieces);

        // Cats vs. Dogs pieces
        rdbtnmntmCatsVsDogs = new JRadioButtonMenuItem("Cats vs. Dogs");
        rdbtnmntmCatsVsDogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnmntmNormalPieces.setSelected(false);
                rdbtnmntmPumpkinsVsBats.setSelected(false);
                player2Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/cat.png"));
                player1Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/dog.png"));
                blackPieceLabel.setIcon(player1Piece);
                whitePieceLabel.setIcon(player2Piece);

                updateUI();
            }
        });
        mnReskinPieces.add(rdbtnmntmCatsVsDogs);

        // Pumpkins vs. Bats pieces
        rdbtnmntmPumpkinsVsBats = new JRadioButtonMenuItem("Pumpkins vs. Bats");
        rdbtnmntmPumpkinsVsBats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnmntmNormalPieces.setSelected(false);
                rdbtnmntmCatsVsDogs.setSelected(false);
                player2Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/bat.png"));
                player1Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/pumpkin.png"));
                blackPieceLabel.setIcon(player1Piece);
                whitePieceLabel.setIcon(player2Piece);
                blackPieceLabel.setLocation(360, 1);
                blackPieceLabel.setSize(54, 42);
                whitePieceLabel.setLocation(359, 44);
                whitePieceLabel.setSize(54, 42);
                updateUI();
            }
        });
        mnReskinPieces.add(rdbtnmntmPumpkinsVsBats);

        // Debug Scenarios
        mnDebugScenarios = new JMenu("Debug Scenarios");
        mnGame.add(mnDebugScenarios);

        // Normal Game
        rdbtnmntmNormalGame = new JRadioButtonMenuItem("Normal Game");
        rdbtnmntmNormalGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                debugScenario = 0;
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        rdbtnmntmNormalGame.setSelected(true);
        mnDebugScenarios.add(rdbtnmntmNormalGame);

        // Coner Test
        rdbtnmntmConerTest = new JRadioButtonMenuItem("Coner Test");
        rdbtnmntmConerTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 1;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmConerTest);

        // Side Tests
        rdbtnmntmSideTests = new JRadioButtonMenuItem("Side Tests");
        rdbtnmntmSideTests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 2;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmSideTests);

        // 1x Capture Test
        rdbtnmntmxCaptureTest1 = new JRadioButtonMenuItem("1x Capture Test");
        rdbtnmntmxCaptureTest1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 3;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmxCaptureTest1);

        // 2x Capture Test
        rdbtnmntmxCaptureTest2 = new JRadioButtonMenuItem("2x Capture Test");
        rdbtnmntmxCaptureTest2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 4;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmxCaptureTest2);

        // Empty Board Test
        rdbtnmntmEmptyBoard = new JRadioButtonMenuItem("Empty Board");
        rdbtnmntmEmptyBoard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 5;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmInnerSquareTest.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmEmptyBoard);

        // Inner Square Test
        rdbtnmntmInnerSquareTest = new JRadioButtonMenuItem("Inner Square Test");
        rdbtnmntmInnerSquareTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                debugScenario = 6;
                rdbtnmntmNormalGame.setSelected(false);
                rdbtnmntmConerTest.setSelected(false);
                rdbtnmntmSideTests.setSelected(false);
                rdbtnmntmxCaptureTest1.setSelected(false);
                rdbtnmntmxCaptureTest2.setSelected(false);
                rdbtnmntmEmptyBoard.setSelected(false);
            }
        });
        mnDebugScenarios.add(rdbtnmntmInnerSquareTest);

        mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        // About menu item
        mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(mnHelp, "Othello Game\nby Ayub Mohamed\nNovember 2020");
            }
        });
        mnHelp.add(mntmAbout);

        // -----------------------------------------------PinkArea--------------------------
        pinkPanel = new JPanel();
        pinkPanel.setBounds(543, 35, 448, 426);
        pinkPanel.setBackground(Color.pink);
        frame.getContentPane().add(pinkPanel);

        // pink text area
        pinkPanelTextArea = new JTextArea();
        pinkPanelTextArea.setText("Player 1 initialized with " + model.getChips(1) + " pieces. \n");
        pinkPanelTextArea.append("Player 2 initialized with " + model.getChips(2) + " pieces. \n");
        pinkPanel.setLayout(new BorderLayout(0, 0));
        pinkPanelTextArea.setBackground(Color.pink);

        // Scroll when needed
        scrollPane = new JScrollPane(pinkPanelTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        pinkPanel.add(scrollPane);

        // --------------------------------------------CheckBoxPanel-----------------------
        checkBoxPanel = new JPanel();
        checkBoxPanel.setBounds(543, 2, 449, 31);
        frame.getContentPane().add(checkBoxPanel);
        checkBoxPanel.setLayout(new BorderLayout(0, 0));

        // Show vaild moves check box
        showMovesCheckBox = new JCheckBox("Show Vaild Moves");
        showMovesCheckBox.setForeground(Color.BLACK);
        showMovesCheckBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showMovesCheckBox.isSelected()) {
                    showAllVaildMoves(true);
                } else {
                    showAllVaildMoves(false);
                }

            }
        });
        checkBoxPanel.add(showMovesCheckBox, BorderLayout.WEST);

        // ---------------------------------------------SubmitPanel-------------------------
        submitPanel = new JPanel();
        submitPanel.setBounds(1, 552, 990, 28);
        frame.getContentPane().add(submitPanel);
        submitPanel.setLayout(new BorderLayout(0, 0));

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setForeground(Color.RED);
        submitButton.setBackground(Color.BLACK);
        submitPanel.add(submitButton, BorderLayout.EAST);

        // Create and set text field
        textField = new JTextField();
        submitPanel.add(textField, BorderLayout.CENTER);
        textField.setColumns(10);

        // ---------------------------------------PlayerPanel--------------------------
        playerPanel = new JPanel();
        playerPanel.setBounds(543, 463, 449, 86);
        frame.getContentPane().add(playerPanel);
        playerPanel.setLayout(null);

        // Players text in player panel
        player1PiecesLabel = new JLabel("Player 1 Pieces:");
        player1PiecesLabel.setBounds(10, 29, 113, 14);
        playerPanel.add(player1PiecesLabel);

        player2PiecesLabel = new JLabel("Player 2 Pieces: ");
        player2PiecesLabel.setBounds(10, 54, 113, 14);
        playerPanel.add(player2PiecesLabel);

        // Number of pieces in player panel
        player1PiecesNumLabel = new JLabel(model.getChips(1) + "");
        player1PiecesNumLabel.setBounds(424, 11, 15, 32);
        playerPanel.add(player1PiecesNumLabel);

        player2PiecesNumLabel = new JLabel(model.getChips(2) + "");
        player2PiecesNumLabel.setBounds(424, 61, 15, 14);
        playerPanel.add(player2PiecesNumLabel);

        // Sets white piece icon in player panel
        whitePieceLabel = new JLabel("");
        player2Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/white_s.png"));
        whitePieceLabel.setLocation(379, 44);
        whitePieceLabel.setSize(34, 42);
        whitePieceLabel.setIcon(player2Piece);
        playerPanel.add(whitePieceLabel);

        // Sets black piece icon in player panel
        blackPieceLabel = new JLabel("");
        player1Piece = new ImageIcon(OthelloViewController.class.getResource("/resources/black_s.png"));
        blackPieceLabel.setLocation(380, 1);
        blackPieceLabel.setSize(34, 42);
        blackPieceLabel.setIcon(player1Piece);
        playerPanel.add(blackPieceLabel);

        // ----------------------------Board Panel Area-------------------
        boardPanel = new JPanel();
        boardPanel.setBounds(1, 0, 540, 552);
        boardPanel.setBackground(Color.GRAY);
        frame.getContentPane().add(boardPanel);
        boardPanel.setLayout(new GridLayout(9, 9, 1, 1));

        colorLabel = false;
        squares = new JLabel[9][9];
        boardButtons = new JButton[17];

        // Crates the board
        int x = 0;
        for (int i = 0; i < squares.length; i++) {
            // Sets order color for board
            if (colorLabel)
                colorLabel = false;
            else
                colorLabel = true;
            for (int j = 0; j < squares[i].length; j++) {

                // Sets button for 1 - 8
                if (i == squares.length - 1) {
                    boardButtons[x] = new JButton();
                    boardButtons[x].setOpaque(true);
                    boardButtons[x].setBackground(Color.LIGHT_GRAY);
                    boardPanel.add(boardButtons[x]);
                    x++;
                } else if (j == squares[i].length - 1) {
                    // Sets button for A - H
                    boardButtons[x] = new JButton();
                    boardButtons[x].setOpaque(true);
                    boardButtons[x].setBackground(Color.LIGHT_GRAY);
                    boardPanel.add(boardButtons[x]);
                    x++;
                } else {
                    // Sets labels for board black or white
                    squares[i][j] = new JLabel("", SwingConstants.CENTER);
                    if (colorLabel) {
                        squares[i][j].setBackground(Color.BLACK);
                        colorLabel = false;
                    } else {
                        squares[i][j].setBackground(Color.WHITE);
                        colorLabel = true;
                    }
                    squares[i][j].setOpaque(true);
                    boardPanel.add(squares[i][j]);
                }

            }
        }

        // Set move button
        boardButtons[16].setText("Move");
        boardButtons[16].setFont((new Font("Arial", Font.PLAIN, 8)));
        boardButtons[16].setBackground(Color.WHITE);

        // Set button text for 1 - 8
        for (int i = 1; i < 9; i++) {
            boardButtons[i - 1].setText("" + i);
        }

        // Set button text for A - H
        boardButtons[8].setText("A");
        boardButtons[9].setText("B");
        boardButtons[10].setText("C");
        boardButtons[11].setText("D");
        boardButtons[12].setText("E");
        boardButtons[13].setText("F");
        boardButtons[14].setText("G");
        boardButtons[15].setText("H");

    }

    /**
     *
     * skips turn if move button is skip, capture all pieces after a valid move it
     * made, update the UI
     *
     */
    public void moveButton() {
        int numCaptured;

        // Skip player is button is skip
        if (boardButtons[16].getText() == "skip") {
            if (playerTurn == true) {
                playerTurn = false;
                boardButtons[16].setText("move");
            } else {
                playerTurn = true;
                boardButtons[16].setText("move");
            }
        } else {
            // Check if both number and letter are selected
            if (numberCheck == true && letterCheck == true) {
                if (playerTurn == true) {
                    // validate selected position
                    if (model.isValid(numberPosition, letterPosition, 1)) {
                        // if valid, calls move and return num of piece captured
                        numCaptured = model.move(numberPosition, letterPosition, 1);
                        // updates text area
                        pinkPanelTextArea.append("Player 1 has captured " + numCaptured + " piece.\n");
                        // next player turn
                        playerTurn = false;
                    }

                } else {
                    if (model.isValid(numberPosition, letterPosition, 2)) {
                        numCaptured = model.move(numberPosition, letterPosition, 2);
                        pinkPanelTextArea.append("Player 2 has captured " + numCaptured + " piece.\n");
                        playerTurn = true;
                    }
                }
            }
        }

        // resets background color for buttons
        for (int i = 0; i < 16; i++) {
            boardButtons[i].setBackground(Color.LIGHT_GRAY);
        }
        // resets all other pieces
        numberCheck = false;
        letterCheck = false;
        numberPosition = -1;
        letterPosition = -1;
        showMovesCheckBox.setSelected(false);

        // updates and displays to UI
        updateUI();
        player1PiecesNumLabel.setText(model.getChips(1) + "");
        player2PiecesNumLabel.setText(model.getChips(2) + "");
        skipButton();
    }

    /**
     *
     * Show all valid move a player has
     *
     * @param checked
     *
     */
    public void showAllVaildMoves(boolean checked) {

        int player = 2;
        if (playerTurn) {
            player = 1;
        }

        // if valid position is found, and checked is true, check mark will be added,
        // else is will be removed
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (model.isValid(i, j, player)) {
                    if (checked) {
                        squares[i][j].setIcon(checkmark);
                    } else {
                        squares[i][j].setIcon(null);
                    }

                }
            }
        }
    }

    /**
     * Update UI to what model looks like
     */
    public void updateUI() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (model.getBoard(i, j) == 1) {
                    squares[i][j].setIcon(player1Piece);
                } else if (model.getBoard(i, j) == 2) {
                    squares[i][j].setIcon(player2Piece);
                } else if (squares[i][j].getIcon() == checkmark) {
                    squares[i][j].setIcon(null);
                } else if (model.getBoard(i, j) == 0) {
                    squares[i][j].setIcon(null);
                }
            }
        }

    }

    /**
     * if player has no more move, sets up so player can be skipped, also calls end
     * game if both player have no more moves
     */
    public void skipButton() {

        // checks if any player has any more moves
        if (model.canMove(1) || model.canMove(2)) {

            //sets up skip for current player
            if (playerTurn == true) {
                if (!model.canMove(1)) {
                    boardButtons[16].setText("skip");
                    pinkPanelTextArea.append("Player 1 has no vaild moves. Please skip\n");
                } else {
                    boardButtons[16].setText("move");
                }
            } else {
                if (!model.canMove(2)) {
                    boardButtons[16].setText("skip");
                    pinkPanelTextArea.append("Player 2 has no vaild moves. Please skip\n");
                } else {
                    boardButtons[16].setText("move");
                }
            }
        } else {
            // calls end game if no player has any valid moves
            endGame();
        }
    }

    /**
     * This will determine who won after counting the total of pieces each player has
     */
    public void endGame() {
        int player1Total = model.getChips(1);
        int player2Total = model.getChips(2);
        pinkPanelTextArea.append("END OF GAME\n");
        pinkPanelTextArea.append("Player 1 finishes with " + player1Total + " pieces\n");
        pinkPanelTextArea.append("Player 2 finishes with " + player2Total + " pieces\n");

        if (player1Total == player2Total) {
            pinkPanelTextArea.append("Game is a tie! \n\n");
        } else if (player1Total > player2Total) {
            pinkPanelTextArea.append("Player 1 wins! \n\n");
        } else {
            pinkPanelTextArea.append("Player 2 wins! \n\n");
        }

        pinkPanelTextArea.append("Play agian? (Select New Game from File Menu.)");
    }

    /**
     * Resets game, to selected debug Scenario, updates UI to new model
     */
    public void newGame() {
        OthelloModel newGame = new OthelloModel();
        newGame.initialize(debugScenario);
        model = newGame;
        playerTurn = true;
        pinkPanelTextArea.setText("Player 1 initialized with " + model.getChips(1) + " pieces. \n");
        pinkPanelTextArea.append("Player 2 initialized with " + model.getChips(2) + " pieces. \n");
        player1PiecesNumLabel.setText(model.getChips(1) + "");
        player2PiecesNumLabel.setText(model.getChips(2) + "");
        showMovesCheckBox.setSelected(false);
        updateUI();

        for (int i = 0; i < 16; i++) {
            boardButtons[i].setBackground(Color.LIGHT_GRAY);
        }

        skipButton();

    }

    /**
     * The Controller class will have very basic code. It reads the action command
     * (or user data) of the button that was pressed, and then prints it to the
     * console
     *
     * @author AyubMohamed
     * @version 1
     * @see None
     */

    class Controller implements ActionListener {
        /**
         *
         * adds ActionListener to all buttons
         *
         */
        public Controller() {
            for (int i = 0; i < 17; i++) {
                boardButtons[i].addActionListener(this);
            }
        }

        /**
         *
         * This will perform operations on all buttons when pressed
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boardButtons[16]) {
                // If move or skip is pressed
                moveButton();
            } else {
                // This will set all buttons to its original background colour then set the
                // pressed button is be operated on when moved button is called
                for (int i = 0; i < 16; i++) {
                    if (e.getSource() == boardButtons[i]) {
                        if (i < 8) {
                            if (numberCheck == true) {
                                for (int x = 0; x < 8; x++) {
                                    boardButtons[x].setBackground(Color.LIGHT_GRAY);
                                }
                            }
                            numberPosition = i;
                            boardButtons[i].setBackground(Color.WHITE);
                            numberCheck = true;

                        } else {
                            if (numberCheck == true) {
                                for (int x = 8; x < 16; x++) {
                                    boardButtons[x].setBackground(Color.LIGHT_GRAY);
                                }
                            }
                            letterPosition = i - 8;
                            boardButtons[i].setBackground(Color.WHITE);
                            letterCheck = true;

                        }

                    }
                }

            }

        }

    }
}
