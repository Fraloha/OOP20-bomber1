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
import bomberone.model.pathfinding.gameboard.BoardPoint;
import bomberone.model.pathfinding.gameboard.BoardPointImpl;
import bomberone.model.pathfinding.navigation.PathFinder;
import bomberone.model.common.Direction;

/**
 * Path finding tester.
 */
public class TestPathfinding {

    private static final int POS_8 = 8;
    private static final int POS_7 = 7;
    private PathFinder pathFinder;
    private GameBoard testBoard;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        this.pathFinder = new BFSSearch();
        List<List<String>> boardToSet = new LinkedList<List<String>>();
        List<String> buffer = new LinkedList<String>();

        try {
            Scanner reader = new Scanner(new File("./bin/test/bomberone/model/pathfinding/TestBoard.txt"));
            while (reader.hasNextLine()) {
                char [] array = reader.nextLine().toCharArray();
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

        this.testBoard = new GameBoard(boardToSet, 'H');
    }

    @Test
    public void noWayOutTest() {
        BoardPoint startPosition = new BoardPointImpl(POS_7, POS_8);
        List<Direction> path = this.pathFinder.searchPath(startPosition);
        System.out.println(path.isEmpty());
        assertTrue(path.isEmpty());
    }
}
