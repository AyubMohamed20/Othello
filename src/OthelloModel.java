/**
 * File name: OthelloModel
 * Author: Ayub Mohamed, 040899407
 * Date: November 16th, 2020
 * Purpose: Create Othello Model for game
 * Class list: None
 */

/**
 * Create Othello Model for game
 *
 * @author AyubMohamed
 * @version 1
 * @see None
 */
public class OthelloModel {

    /**
     * a normal game {@value} 0
     */
    public static final int NORMAL = 0;
    /**
     * a corner test game {@value} 1
     */
    public static final int CORNER_TEST = 1;
    /**
     * a outer test game {@value} 2
     */
    public static final int OUTER_TEST = 2;
    /**
     * a test capture game {@value} 3
     */
    public static final int TEST_CAPTURE = 3;
    /**
     * a test capture game 2 {@value} 4
     */
    public static final int TEST_CAPTURE2 = 4;
    /**
     * a unwinnable game {@value} 5
     */
    public static final int UNWINNABLE = 5;
    /**
     * a inner test game {@value} 6
     */
    public static final int INNER_TEST = 6;
    /**
     * Empty position on model {@value} 0
     */
    public static final int EMPTY = 0;
    /**
     * black piece on model {@value} 1
     */
    public static final int BLACK = 1;
    /**
     * white piece on model {@value} 1
     */
    public static final int WHITE = 2;
    /**
     * Game board for model
     */
    int[][] board = new int[8][8];

    /**
     *
     * initialize mode set by user
     *
     * @param mode
     */
    public void initialize(int mode) {
        switch (mode) {
            case CORNER_TEST:
                board = new int[][]{{2, 0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 2, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 1, 0}, {2, 0, 0, 0, 0, 0, 0, 2}};

                break;
            case OUTER_TEST:
                board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 2, 2, 2, 2, 2, 2, 0}, {0, 2, 1, 1, 1, 1, 2, 0},
                        {0, 2, 1, 0, 0, 1, 2, 0}, {0, 2, 1, 0, 0, 1, 2, 0}, {0, 2, 1, 1, 1, 1, 2, 0},
                        {0, 2, 2, 2, 2, 2, 2, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
                break;
            case INNER_TEST:
                board = new int[][]{{2, 2, 2, 2, 2, 2, 2, 2}, {2, 0, 0, 0, 0, 0, 0, 2}, {2, 0, 2, 2, 2, 2, 0, 2},
                        {2, 0, 2, 1, 1, 2, 0, 2}, {2, 0, 2, 1, 1, 2, 0, 2}, {2, 0, 2, 2, 2, 2, 0, 2},
                        {2, 0, 0, 0, 0, 0, 0, 2}, {2, 2, 2, 2, 2, 2, 2, 2}};
                break;
            case UNWINNABLE:
                board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
                break;
            case TEST_CAPTURE:
                board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 2, 2, 2, 1, 1, 0}, {0, 1, 2, 0, 2, 1, 1, 0}, {0, 1, 2, 2, 2, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
                break;

            case TEST_CAPTURE2:
                board = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 2, 2, 1, 2, 1, 1},
                        {1, 2, 2, 2, 2, 2, 1, 1}, {1, 2, 2, 0, 2, 2, 1, 1}, {1, 2, 2, 2, 2, 1, 1, 1},
                        {1, 2, 1, 2, 2, 2, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
                break;
            default:
                board = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 2, 1, 0, 0, 0}, {0, 0, 0, 1, 2, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};

        }
    }

    /**
     *
     * Get a position on board
     *
     * @param x, y
     * @return board[x][y]
     */
    public int getBoard(int x, int y) {
        return board[x][y];
    }

    /**
     *
     * Find if given x,y positions on board is valid
     *
     * @param x, y, player
     * @return valid
     */
    public boolean isValid(int x, int y, int player) {

        boolean valid = false; // when valid position is found

        // check if position is taken
        if (board[x][y] == 0) {
            int curr, row, col; // Row/col of board, curr - current position
            boolean temp; // true when player is valid or position is invalid

            // this will check the surrounding pieces for opposing players piece, if not
            // found will continue, if found it will go to the while loop below
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    row = y + i;
                    col = x + j;
                    temp = false;
                    if (col > -1 && col < 8 && row > -1 && row < 8) {
                        curr = board[col][row];
                    } else {
                        curr = -1;
                    }

                    if (curr == -1 || curr == 0 || curr == player) {
                        continue;
                    }

                    // It will continue on its current path until it finds player peace, when found
                    // it will return true

                    while (!temp) {

                        row += i;
                        col += j;

                        if (col > -1 && col < 8 && row > -1 && row < 8) {
                            curr = board[col][row];
                        } else {
                            curr = -1;
                        }

                        if (curr == player) {
                            return true;

                        } else if (curr == -1 || curr == 0) {
                            temp = true;
                        }
                    }
                }
            }
        }

        return valid;
    }

    /**
     *
     * This method would validate X,Y position on the board ,when player position is
     * found it will reverse its course and flip all opposing players pieces
     *
     * @param x, y, player
     * @return numFlipped
     */
    public int move(int x, int y, int player) {
        // Same as the one above
        int numFlipped = 0; // Number of pieces flipped
        if (board[x][y] == 0) {
            int curr, row, col;
            boolean temp;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    row = y + i;
                    col = x + j;
                    temp = false;
                    if (col > -1 && col < 8 && row > -1 && row < 8) {
                        curr = board[col][row];
                    } else {
                        curr = -1;
                    }

                    if (curr == -1 || curr == 0 || curr == player) {
                        continue;
                    }

                    while (!temp) {

                        row += i;
                        col += j;

                        if (col > -1 && col < 8 && row > -1 && row < 8) {
                            curr = board[col][row];
                        } else {
                            curr = -1;
                        }

                        // once if finds current player position, it will reverse its course and flip
                        // all opposing players pieces
                        if (curr == player) {
                            temp = true;
                            row -= i;
                            col -= j;
                            if (col > -1 && col < 8 && row > -1 && row < 8) {
                                curr = board[col][row];
                            } else {
                                curr = 0;
                            }
                            while (curr != 0) {

                                board[col][row] = player;
                                row -= i;
                                col -= j;

                                if (col > -1 && col < 8 && row > -1 && row < 8) {
                                    curr = board[col][row];
                                } else {
                                    curr = 0;
                                }
                                // count total number if piece flipped
                                numFlipped++;
                            }

                        } else if (curr == -1 || curr == 0) {
                            temp = true;
                        }
                    }
                }
            }
        }
        // sets positions to current player piece
        board[x][y] = player;
        return numFlipped;
    }

    /**
     *
     * Runs is valid on all positions on board
     *
     * @param player
     * @return True/False
     */
    public boolean canMove(int player) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValid(i, j, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * Get the total number of chips a given player has on board
     *
     * @param player
     * @return numChips
     */
    public int getChips(int player) {
        int numChips = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == player) {
                    numChips++;
                }
            }
        }
        return numChips;
    }

}
