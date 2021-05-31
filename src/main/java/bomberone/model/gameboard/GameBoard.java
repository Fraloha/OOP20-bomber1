package bomberone.model.gameboard;

import bomberone.model.common.P2d;

public class GameBoard {

    /* Fields. */
    private static final int WORLD_SIZE = 18;
    private static final int CELL_SIZE = 32;
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

    public void setGameBoard(final char[][] gameBoard) {
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

    public boolean isAccessible(final BoardPoint locationToCheck) {
        char item = this.getItem(locationToCheck);
        boolean result = item != Markers.BOX_MARKER.getMarker() && item != Markers.WALL_MARKER.getMarker() ? true
                : false;
        return (item != 'N') && result;
    }

    private boolean checkAccessibility(final BoardPoint currentPoint, final BoardPoint playerPosition,
            final Accessibility mode) {

        boolean result = true;
        int coordinateEnemy = mode.equals(Accessibility.ROWS) ? currentPoint.getY() : currentPoint.getX();
        int coordinatePlayer = mode.equals(Accessibility.ROWS) ? playerPosition.getY() : playerPosition.getX();

        if (coordinateEnemy == coordinatePlayer) {
            int k = mode.equals(Accessibility.ROWS) ? Math.min(currentPoint.getX(), playerPosition.getX())
                    : Math.min(currentPoint.getY(), playerPosition.getY());
            int m = mode.equals(Accessibility.ROWS) ? Math.max(currentPoint.getX(), playerPosition.getX())
                    : Math.max(currentPoint.getY(), playerPosition.getY());
            BoardPoint nextPoint = new BoardPointImpl(k, m);

            while (k <= m) {
                if (!this.isLegal(nextPoint) || !this.isAccessible(nextPoint)) {
                    result = false;
                    break;
                }
                k++;
                nextPoint.setPoint(k, m);
            }
        } else {
            result = false;
        }

        return result;
    }

    public boolean isPlayerVisible(BoardPoint currentPosition) {
        BoardPoint playerLocation = this.findPlayerLocation();
        return this.checkAccessibility(currentPosition, playerLocation, Accessibility.ROWS)
                || this.checkAccessibility(currentPosition, playerLocation, Accessibility.COLUMNS);
    }

    public void setPlayerLocation(final BoardPoint newPosition) {
        this.resetPlayerLocation();
        this.setItem(newPosition, Markers.PLAYER_MARKER);
    }

    public BoardPoint convertPosition(P2d positionToConvert) {
        int X = (int) Math.round(positionToConvert.getY() / GameBoard.CELL_SIZE);
        int Y = (int) Math.round(positionToConvert.getX() / GameBoard.CELL_SIZE);

        return new BoardPointImpl(X, Y);
    }

    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getItem(new BoardPointImpl(i, j)) + "  ");
            }
            System.out.println();
        }
    }

    public void resetBoxes() {
        BoardPoint currentPosition = new BoardPointImpl(0, 0);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.getItem(currentPosition) == Markers.BOX_MARKER.getMarker()) {
                    this.setItem(currentPosition, Markers.GROUND_MARKER);
                }
                currentPosition.setPoint(i, j);
            }
        }
    }
}
