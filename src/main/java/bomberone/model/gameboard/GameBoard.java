package bomberone.model.gameboard;

import java.util.List;
import java.util.Optional;
import bomberone.model.common.Maps;

public class GameBoard {

    private static final int BOUNDS_CELLS = 18;
    /* Fields. */
    private int rows;
    private int columns;
    private char[][] currentGameBoard;

    /* Constructors. */
    public GameBoard(final int rowsToSet, final int columnsToSet) {
        this.rows = rowsToSet;
        this.columns = columnsToSet;
        this.currentGameBoard = new char[this.rows][this.columns];

        // Setting the ground.
        BoardPoint currentPosition = new BoardPointImpl(0, 0);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.setItem(currentPosition, Markers.GROUND_MARKER);
                currentPosition.setPoint(i, j);
            }
        }
    }

    public GameBoard(final Maps mapLayout) {
        Markers newMarker;
        List<List<String>> map = mapLayout.getList();
        BoardPoint currentPosition = new BoardPointImpl(0, 0);

        this.rows = map.size();
        this.columns = map.get(0).size();
        this.currentGameBoard = new char[this.rows][this.columns];

        // Setting the map.
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {

                if (map.get(j).get(i).equals("H")) {
                    newMarker = Markers.WALL_MARKER;
                } else {
                    newMarker = Markers.GROUND_MARKER;
                }

                currentPosition.setPoint(j, i);
                this.setItem(currentPosition, newMarker);
            }
        }
    }

    /* Methods. */

    /**
     * Gets the game board as a 2D char array. For each cell there is a char that
     * represents the current game object that occupies the position.
     * 
     * @return the game board as a 2D char array.
     */
    public char[][] getGameBoard() {
        return this.currentGameBoard;
    }

    /**
     * This method sets the game board.
     * 
     * @param gameBoard the new game board.
     */
    public void setGameBoard(final char[][] gameBoard) {
        this.currentGameBoard = gameBoard;
    }

    /**
     * This method gets the game board's rows number.
     * 
     * @return the rows number.
     */
    public int getRowsQuantity() {
        return this.rows;
    }

    /**
     * This method gets the gameboard's columns number.
     * 
     * @return the columns number
     */
    public int getColumnsQuantity() {
        return this.columns;
    }

    /**
     * This method finds the player position in the game board.
     * 
     * @return the player position.
     */
    public Optional<BoardPoint> findPlayerLocation() {
        return this.searchMarker(Markers.PLAYER_MARKER);
    }

    /**
     * This method checks if the location passed as an argument is in the game board
     * boundaries.
     * 
     * @param locationToCheck the position to check.
     * @return true if the position is valid, otherwise false.
     */
    private boolean isLegal(final BoardPoint locationToCheck) {
        boolean result = locationToCheck.getX() >= 0 && locationToCheck.getX() < BOUNDS_CELLS ? true : false;
        boolean secondResult = locationToCheck.getY() >= 0 && locationToCheck.getY() < BOUNDS_CELLS ? true : false;

        return result && secondResult;
    }

    /**
     * This method sets a marker to a specified position.
     * 
     * @param locationToSet the position where the marker has to be set.
     * @param marker        the marker to set.
     */
    public void setItem(final BoardPoint locationToSet, final Markers marker) {
        int currentX = locationToSet.getX();
        int currentY = locationToSet.getY();
        this.currentGameBoard[currentX][currentY] = this.isLegal(locationToSet) ? marker.getMarker() : 'N';
    }

    /**
     * This method sets a marker to some specified positions.
     * 
     * @param positions A List of BoardPoint, so the positions where the marker has
     *                  to be set.
     * @param marker    The marker to set.
     */
    public void setItems(final List<BoardPoint> positions, final Markers marker) {
        for (BoardPoint currentPosition : positions) {
            this.setItem(currentPosition, marker);
        }
    }

    /**
     * This method gets an item at the position specified by the BoardPoint object
     * passed as an argument.
     * 
     * @param location the item's position.
     * @return the marker of the specified position.
     */
    public char getItem(final BoardPoint location) {
        if (this.isLegal(location)) {
            return this.currentGameBoard[location.getX()][location.getY()];
        } else {
            return 'N';
        }
    }

    /**
     * This method checks if the position specified by the argument is accessible,
     * so checks if the marker in the position is the ground marker.
     * 
     * @param locationToCheck the position to check.
     * @return true if the marker in the position is equal to the ground marker,
     *         otherwise false.
     */
    public boolean isAccessible(final BoardPoint locationToCheck) {
        char item = this.getItem(locationToCheck);
        boolean result = item != Markers.BOX_MARKER.getMarker() && item != Markers.WALL_MARKER.getMarker() ? true
                : false;
        return (item != 'N') && result;
    }

    /**
     * This method checks if two points are on the same row or column and if the
     * position between them are all accessible.
     * 
     * @param currentPoint A point of the game board.
     * @param destination  A destination point.
     * @param mode         The checking policy which specify if the accessibility
     *                     has to be checked in row or in column.
     * @return true is the positions between the points are all accessible,
     *         otherwise false.
     */
    private boolean checkAccessibility(final BoardPoint currentPoint, final BoardPoint destination,
            final Accessibility mode) {

        boolean result = true;
        int currentCoordinates = mode.equals(Accessibility.ROWS) ? currentPoint.getX() : currentPoint.getY();
        int destinationCoordinates = mode.equals(Accessibility.ROWS) ? destination.getX() : destination.getY();

        if (currentCoordinates == destinationCoordinates) {
            int k = mode.equals(Accessibility.ROWS) ? Math.min(currentPoint.getY(), destination.getY())
                    : Math.min(currentPoint.getX(), destination.getX());
            int m = mode.equals(Accessibility.ROWS) ? Math.max(currentPoint.getY(), destination.getY())
                    : Math.max(currentPoint.getX(), destination.getX());
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

    /**
     * This method checks if the player is "visible" from the position passed as an
     * argument. The player is visible if the positions between the point argument
     * and the player position are accessible.
     * 
     * @param currentPosition The starting position.
     * @return true if the player is visible, otherwise false.
     */
    public boolean isPlayerVisible(final BoardPoint currentPosition) {
        boolean result = false;
        Optional<BoardPoint> playerLocation = this.findPlayerLocation();

        if (!playerLocation.isEmpty()) {
            result = this.checkAccessibility(currentPosition, playerLocation.get(), Accessibility.ROWS)
                    || this.checkAccessibility(currentPosition, playerLocation.get(), Accessibility.COLUMNS);
        }

        return result;
    }

    /**
     * This method sets the player position in the game board.
     * 
     * @param newPosition The new position of the player.
     */
    public void setPlayerLocation(final BoardPoint newPosition) {
        this.resetItem(Markers.PLAYER_MARKER);
        this.setItem(newPosition, Markers.PLAYER_MARKER);
    }

    /**
     * This method searches the marker passed as a parameter.
     * 
     * @param markerToFind The marker to find in the game board.
     * @return a Optional<BoardPoint> object, which contains the position of the
     *         marker passed as argument, if it is found, otherwise an empty
     *         Optional object.
     */
    public Optional<BoardPoint> searchMarker(final Markers markerToFind) {
        BoardPoint itemPoint = new BoardPointImpl(0, 0);
        Optional<BoardPoint> position = Optional.empty();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.getItem(itemPoint) == markerToFind.getMarker()) {
                    position = Optional.of(itemPoint);
                    break;
                }
                itemPoint.setPoint(i, j);
            }
        }
        return position;
    }

    /**
     * This method changes the first occurrence of the marker specified as the first
     * argument to the marker passed as second argument.
     * 
     * @param markerToChange The marker to change.
     * @param newMarker      The new marker.
     * @return true if the marker if the marker is present in the game board and it
     *         is changed, otherwise false.
     */
    public boolean changeItem(final Markers markerToChange, final Markers newMarker) {
        boolean result = true;
        Optional<BoardPoint> itemToChange = this.searchMarker(markerToChange);
        if (itemToChange.isEmpty()) {
            result = false;
        } else {
            this.setItem(itemToChange.get(), newMarker);
        }

        return result;
    }

    /**
     * This method changes all the occurrences of the marker that are equal to the
     * marker passed as first argument to the maker passed as second argument.
     * 
     * @param markerToChange The marker to change.
     * @param newMarker      The new Marker.
     */
    public void changeAllItems(final Markers markerToChange, final Markers newMarker) {
        boolean result;

        do {
            result = this.changeItem(markerToChange, newMarker);
        } while (result);
    }

    /**
     * This method changes the first occurrence of the marker passed as argument to
     * a ground marker.
     * 
     * @param markerToChange The marker to change
     */
    public void resetItem(final Markers markerToChange) {
        this.changeItem(markerToChange, Markers.GROUND_MARKER);
    }

    /**
     * This method changes all the occurrences of the marker passed as a argument to
     * a ground marker.
     * 
     * @param markerToChange The maker to change.
     */
    public void resetAllItems(final Markers markerToChange) {
        this.changeAllItems(markerToChange, Markers.GROUND_MARKER);
    }

    /**
     * Writes the whole board to standard output.
     */
    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getItem(new BoardPointImpl(i, j)) + "  ");
            }
            System.out.println();
        }
    }
}
