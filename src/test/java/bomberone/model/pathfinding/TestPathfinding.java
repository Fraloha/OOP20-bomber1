package bomberone.model.pathfinding;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import bomberone.model.pathfinding.gameboard.GameBoard;
import bomberone.model.pathfinding.gameboard.Markers;
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.gameboard.BoardPointImpl;
import bomberone.model.pathfinding.navigation.PathFinder;
import bomberone.model.common.Direction;

/**
 * Path finding tester.
 */
public class TestPathfinding {

    /**
     * The eighth position.
     */
    private static final int POS_8 = 8;

    /**
     * The seventh position.
     */
    private static final int POS_7 = 7;

    /**
     * The third position.
     */
    private static final int POS_3 = 3;

    /**
     * The first position.
     */
    private static final int POS_1 = 1;

    private BoardPoint startPosition;
    private PathFinder pathFinder;
    private GameBoard testBoard;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        List<List<String>> boardToSet = new LinkedList<List<String>>();

        try {
            Scanner reader = new Scanner(new File("./bin/test/bomberone/model/pathfinding/TestBoard.txt"));
            while (reader.hasNextLine()) {
                char[] array = reader.nextLine().toCharArray();
                List<String> buffer = new LinkedList<String>();
                for (char item : array) {
                    buffer.add(String.valueOf(item));
                }
                boardToSet.add(buffer);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.testBoard = new GameBoard(boardToSet);
    }

    @Test
    public void noWayOutTest() {
        this.startPosition = new BoardPointImpl(TestPathfinding.POS_7, TestPathfinding.POS_8);
        this.pathFinder = new BFSSearch(this.testBoard);
        assertTrue(this.pathFinder.searchPath(startPosition).isEmpty());
    }

    @Test
    public void firstTest() {
        BoardPoint startPosition = new BoardPointImpl(POS_7, POS_8);
        List<BoardPoint> pointsToReset = new LinkedList<BoardPoint>();
        pointsToReset.add(new BoardPointImpl(TestPathfinding.POS_3, TestPathfinding.POS_7));
        pointsToReset.add(new BoardPointImpl(TestPathfinding.POS_3, TestPathfinding.POS_8));
        pointsToReset.add(new BoardPointImpl(TestPathfinding.POS_1, TestPathfinding.POS_8));
        pointsToReset.add(new BoardPointImpl(TestPathfinding.POS_1, TestPathfinding.POS_3));
        for (BoardPoint point : pointsToReset) {
            point.setMarker(Markers.ACCESSIBLE);
        }

        this.testBoard.changeAllItems(pointsToReset);

        this.pathFinder = new BFSSearch(this.testBoard);
        List<Direction> path = this.pathFinder.searchPath(startPosition);
        assertTrue(!path.isEmpty());
    }
}
