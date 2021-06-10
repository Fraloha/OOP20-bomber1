package bomberone.model.bombergameboard;

import bomberone.model.common.P2d;
import bomberone.model.common.Maps;
import bomberone.model.gameboard.GameBoard;
import bomberone.model.gameboard.BoardPoint;
import bomberone.model.gameboard.BoardPointImpl;

public final class BomberOneBoard extends GameBoard {

    private static final int CELL_SIZE = 32;
    private static final BomberOneBoard SINGLETON = new BomberOneBoard();

    private BomberOneBoard() {
        super(Maps.MAP1);
    }

    public static BomberOneBoard getInstance() {
        return BomberOneBoard.SINGLETON;
    }

    public BoardPoint convertPosition(final P2d positionToConvert) {
        int x = (int) Math.round(positionToConvert.getY() / BomberOneBoard.CELL_SIZE);
        int y = (int) Math.round(positionToConvert.getX() / BomberOneBoard.CELL_SIZE);

        return new BoardPointImpl(x, y);
    }
}
