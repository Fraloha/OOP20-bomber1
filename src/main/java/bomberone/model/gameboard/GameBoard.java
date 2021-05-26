package bomberone.model.gameboard;

public class GameBoard {

    /* Fields. */
    private static final int WORLD_SIZE = 18;
    private char[][] currentGameBoard;
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

    public BoardPoint findPlayerLocation() {

        BoardPoint location = new BoardPointImpl(-1, -1);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                location.setPoint(i, j);
                if (this.getItem(location) == 'P') {
                    return location;
                }
            }
        }
        return new BoardPointImpl(-1, -1);
    }

    public void resetPlayerLocation() {
        BoardPoint location = this.findPlayerLocation();
        if (location.getX() != -1) {
            this.currentGameBoard[location.getX()][location.getY()] = 'G';
        }
    }

    private boolean isLegal(final BoardPoint locationToCheck) {
        boolean result = locationToCheck.getX() >= 0 && locationToCheck.getX() < 18 ? true : false;
        boolean secondResult = locationToCheck.getY() >= 0 && locationToCheck.getY() < 18 ? true : false;

        return result && secondResult;
    }

    public void setItem(final BoardPoint locationToSet, final Markers marker) {
        int currentX = locationToSet.getX();
        int currentY = locationToSet.getY();
        this.currentGameBoard[currentX][currentY] = this.isLegal(locationToSet) ? marker.getMarker() : 'N';
    }

    public char getItem(final BoardPoint location) {
        if (this.isLegal(location)) {
            return this.currentGameBoard[location.getX()][location.getY()];
        } else {
            return 'N';
        }
    }

    /*
     * public int[] findEnemyLocation(final int enemyNumber) { int currentEnemy = 1;
     * 
     * for (int i = 0; i < this.rows; i++) { for (int j = 0; j < this.columns; j++)
     * { if (this.getItem(i, j) == 'E' && currentEnemy == enemyNumber) { return new
     * int[] { i, j }; } else { currentEnemy++; } } }
     * 
     * return new int[] { -1, -1 }; }
     */

    public boolean isAccessible(final BoardPoint locationToCheck) {
        return this.getItem(locationToCheck) != Markers.WALL_MARKER.getMarker()
                && this.getItem(locationToCheck) != Markers.BOX_MARKER.getMarker();
    }

    private boolean isRowAccessible(final BoardPoint currentPoint, final BoardPoint playerPosition) {

        boolean result = true;

        if (currentPoint.getY() == playerPosition.getY()) {
            result = false;
        } else {
            BoardPoint nextPoint = new BoardPointImpl(0, 0);
            int i = Math.min(currentPoint.getX(), playerPosition.getX());
            int m = Math.max(currentPoint.getX(), playerPosition.getX());

            while (i <= m) {
                nextPoint.setPoint(i, m);
                if (!this.isLegal(nextPoint) || !this.isAccessible(nextPoint)) {
                    result = false;
                    break;
                }
                i++;
            }
        }

        return result;
    }

    private boolean isColumnAccessible(final BoardPoint currentPoint, final BoardPoint playerPosition) {
        boolean result = true;
        
        if (currentPoint.getX() == playerPosition.getX()) {
            result = false;
        } else {
            BoardPoint nextPoint = new BoardPointImpl(0, 0);
            int j = Math.min(currentPoint.getY(), playerPosition.getY());
            int m = Math.max(currentPoint.getY(), playerPosition.getY());
            
            while (j <= m) {
                nextPoint.setPoint(j, m);
                if (!this.isLegal(nextPoint) || !this.isAccessible(nextPoint)) {
                    result = false;
                    break;
                }
                j++;
            }
        }
        
        return result;
    }

    public boolean isPlayerVisible(BoardPoint currentPosition) {
        boolean result = false;
        BoardPoint playerLocation = this.findPlayerLocation();
        if (this.isLegal(currentPosition) && this.isAccessible(currentPosition)) {
            if (this.isRowAccessible(currentPosition, playerLocation)
                    || this.isColumnAccessible(currentPosition, playerLocation)) {
                result = true;
            }
        }

        return result;
    }

    public void setPlayerLocation(final BoardPoint newPosition) {
        this.resetPlayerLocation();
        this.setItem(newPosition, Markers.PLAYER_MARKER);
    }

    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getItem(new BoardPointImpl(i, j)) + "  ");
            }
            System.out.println();
        }
    }
}
