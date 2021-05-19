package bomberone.model.gameboard;

public class GameBoard {

    /* Fields. */
    private char[][] currentGameBoard;
    private int rows;
    private int columns;

    /* Singleton pattern. */
    private static class GameBoardHolder {
        private static final GameBoard BOARDSINGLETON = new GameBoard(18, 18);
    }

    public static GameBoard getInstance() {
        return GameBoardHolder.BOARDSINGLETON;
    }

    /* Constructors. */
    private GameBoard(int rowsToSet, int columnsToSet) {
        this.rows = rowsToSet;
        this.columns = columnsToSet;
        this.currentGameBoard = new char[this.rows][this.columns];
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

    private boolean isLegal(int row, int column) {
        return ((row >= 0 && row < 18) && (column >= 0 && column < 18));
    }

    public void setItem(int row, int column, Markers marker) {
        this.currentGameBoard[row][column] = this.isLegal(row, column) ? marker.getMarker() : 'N';
    }

    public char getItem(int row, int column) {
        if (this.isLegal(row, column)) {
            return this.currentGameBoard[row][column];
        } else {
            return 'N';
        }
    }

    public int[] findEnemyLocation(int enemyNumber) {
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

    public boolean isAccessible(int row, int column) {
        return this.getItem(row, column) != 'W' && this.getItem(row, column) != 'B' ? true : false;
    }

    public boolean isPlayerVisible(int row, int column) {
        boolean result = false;
        int[] playerLocation = this.findPlayerLocation();
        if (this.isLegal(row, column) && this.isAccessible(row, column)) {
            if (playerLocation[0] == row || playerLocation[1] == column) {
                result = true;
            }
        }

        return result;
    }
}
