package bomberone.model.bombergameboard;

import bomberone.model.common.P2d;

import bomberone.model.common.Maps;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.gameboard.BoardPointImpl;
import bomberone.model.pathfinding.gameboard.GameBoard;
import bomberone.model.pathfinding.gameboard.Markers;

/**
 * This class represent the BomberOne playground.
 */
public final class BomberOneBoard extends GameBoard {

    /**
     * This constant indicates the size of the sprite.
     */
    private static final int CELL_SIZE = 32;

    private static final BomberOneBoard SINGLETON = new BomberOneBoard();

    private BomberOneBoard() {
        super(Maps.MAP1.getList());

        for (int i = 0; i < this.getRowsQuantity(); i++) {
            for (int j = 0; j < this.getColumnsQuantity(); j++) {
                if (Maps.MAP1.getList().get(i).get(j).equals("H")) {
                    this.setItem(new BoardPointImpl(i, j, Markers.NOTACCESSIBLE));
                }
            }
        }
    }

    /**
     * This method gets the instance of the object.
     * 
     * @return The instance of the object.
     */
    public static BomberOneBoard getInstance() {
        return BomberOneBoard.SINGLETON;
    }

    /**
     * This method converts a P2d object to a BoardPoint object.
     * 
     * @param positionToConvert The P2d object to convert.
     * @return The position converted into a BoardPoint object.
     */
    public BoardPoint convertPosition(final P2d positionToConvert) {
        int x = (int) Math.round(positionToConvert.getY() / BomberOneBoard.CELL_SIZE);
        int y = (int) Math.round(positionToConvert.getX() / BomberOneBoard.CELL_SIZE);

        return new BoardPointImpl(x, y);
    }

    /**
     * This method converts a P2d object to a BoardPoint object.
     * 
     * @param positionToConvert The P2d object to convert.
     * @param pointMarker       The marker of the new BoardPoint object.
     * @return The position converted into a BoardPoint object.
     */
    public BoardPoint convertPosition(final P2d positionToConvert, final Markers pointMarker) {
        BoardPoint position = this.convertPosition(positionToConvert);
        position.setMarker(pointMarker);
        return position;
    }
}
