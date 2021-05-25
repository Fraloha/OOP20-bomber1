package bomberone.model.gameboard;

import java.util.LinkedList;
import java.util.List;

import bomberone.model.common.P2d;

public class GameBoard {

    /* Fields. */
    private static final int WORLD_SIZE = 18;
    private char[][] currentGameBoard;
    private char[][] markedBoard;
    private int rows;
    private int columns;

    /* Singleton pattern. */
    private static class GameBoardHolder {
        private static final GameBoard BOARDSINGLETON = new GameBoard(GameBoard.WORLD_SIZE, GameBoard.WORLD_SIZE);
    }

    public static GameBoard getInstance() {
        return GameBoardHolder.BOARDSINGLETON;
    }

    /* Constructors. */
    private GameBoard(final int rowsToSet, final int columnsToSet) {
        this.rows = rowsToSet;
        this.columns = columnsToSet;
        this.currentGameBoard = new char[this.rows][this.columns];
        this.markedBoard = new char[this.rows][this.columns];
    }

    /* Methods. */
    public char[][] getGameBoard() {
        return this.currentGameBoard;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.currentGameBoard = gameBoard;
    }

    public int getRowsQuantity() {
        return this.rows;
    }

    public int getColumnsQuantity() {
        return this.columns;
    }

    public int[] findPlayerLocation() {

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.getItem(i, j) == 'P') {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public void resetPlayerLocation() {
        int[] location = this.findPlayerLocation();
        if (location[0] != -1) {
            this.currentGameBoard[location[0]][location[1]] = 'G';
        }
    }

    private boolean isLegal(final int row, final int column) {
        return ((row >= 0 && row < 18) && (column >= 0 && column < 18));
    }

    public void setItem(final int row, final int column, final Markers marker) {
        this.currentGameBoard[row][column] = this.isLegal(row, column) ? marker.getMarker() : 'N';
    }

    public char getItem(final int row, final int column) {
        if (this.isLegal(row, column)) {
            return this.currentGameBoard[row][column];
        } else {
            return 'N';
        }
    }

    public int[] findEnemyLocation(final int enemyNumber) {
        int currentEnemy = 1;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.getItem(i, j) == 'E' && currentEnemy == enemyNumber) {
                    return new int[] { i, j };
                } else {
                    currentEnemy++;
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public boolean isAccessible(final int row, final int column) {
        return this.getItem(row, column) != Markers.WALL_MARKER.getMarker()
                && this.getItem(row, column) != Markers.BOX_MARKER.getMarker();
    }

    private boolean isRowAccessible(final int row, final int column, final int[] playerLocation) {
        boolean result = true;
        int i = Math.min(row, playerLocation[0]);
        int m = Math.max(row, playerLocation[0]);

        while (i < m) {
            if (!this.isLegal(i, column) || !this.isAccessible(i, column)) {
                result = false;
                break;
            }
            i++;
        }

        return result;
    }

    private boolean isColumnAccessible(final int row, final int column, final int[] destination) {
        boolean result = true;
        int j = Math.min(column, destination[1]);
        int m = Math.max(column, destination[1]);

        while (j < m) {
            if (!this.isLegal(row, j) || !this.isAccessible(row, j)) {
                result = false;
                break;
            }
            j++;
        }

        return result;
    }

    public boolean isPlayerVisible(int row, int column) {
        boolean result = false;
        int[] playerLocation = this.findPlayerLocation();
        if (this.isLegal(row, column) && this.isAccessible(row, column)) {
            if (this.isRowAccessible(row, column, playerLocation)
                    || this.isColumnAccessible(row, column, playerLocation)) {
                result = true;
            }
        }

        return result;
    }

    public void setPlayerLocation(final int row, final int column) {
        this.resetPlayerLocation();
        this.setItem(row, column, Markers.PLAYER_MARKER);
    }

    public int[] convertLocation(final P2d location) {
        int[] boardLocation = new int[2];

        boardLocation[0] = (int) location.getX() / 32;
        boardLocation[1] = (int) location.getY() / 32;

        return boardLocation;
    }

    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getItem(i, j) + "  ");
            }
            System.out.println();
        }
    }

    public void setMarkedBoard() {
        this.markedBoard = this.currentGameBoard;
    }

    public void printMarkedBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.markedBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void setPlaceHolder(int row, int column) {
        if (this.isLegal(row, column)) {
            this.markedBoard[row][column] = 'X';
        }
    }

    public void resetPlaceHolder() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.currentGameBoard[i][j] == 'X') {
                    this.currentGameBoard[i][j] = 'G';
                }
            }
        }
    }
}
