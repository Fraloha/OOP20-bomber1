package bomberone.model.enemy.actions;

import java.util.List;
import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;
import bomberone.model.common.P2d;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.common.Direction;
import bomberone.model.enemy.navigation.Node;
import bomberone.model.enemy.navigation.NodeImpl;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.HardWall;

public final class IntermediateBehavior extends AbstractActions {

    /* Fields. */
    private P2d playerPosition;
    private List<BoxImpl> boxes;
    private BasicBehavior basicActions;
    private List<HardWall> walls;
    private HashSet<P2d> visitedPosition;
    private LinkedList<Node> positionsToVisit;

    /* Constructor. */
    public IntermediateBehavior(final EnemyImpl newEnemy) {
        super(newEnemy);
        this.randomGenerator = new Random();
        this.visitedPosition = new HashSet<P2d>();
        this.positionsToVisit = new LinkedList<Node>();
        this.basicActions = new BasicBehavior(this.selectedEnemy);
    }

    /* Methods. */

    /**
     * {@inheritDoc}
     */
    @Override
    public void doActions() {
        P2d actualPosition = this.selectedEnemy.getPosition();
        this.selectedEnemy.setDir(this.shortestPath(actualPosition, this.playerPosition).get(0));
        this.selectedEnemy.setPosition(actualPosition);
        this.nextMove();
    }

    public void setPlayerPosition(final P2d playerPos) {
        this.playerPosition = playerPos;
    }

    public void setBoxes(List<BoxImpl> boxes) {
        this.boxes = boxes;
    }

    public void setWalls(List<HardWall> walls) {
        this.walls = walls;
    }

    private P2d doMovements(final Direction direction) {
        if (direction.equals(Direction.UP)) {
            while(this.selectedEnemy.getPosition().getY() % 32 != 0) {
                this.selectedEnemy.moveUp();
            }
        } else if (direction.equals(Direction.DOWN)) {
            while (this.selectedEnemy.getPosition().getY() % 32 != 0) {
                this.selectedEnemy.moveDown();
            }
        } else if (direction.equals(Direction.RIGHT)) {
            while (this.selectedEnemy.getPosition().getX() % 32 != 0) {
                this.selectedEnemy.moveRight();
            }
        } else {
            while(this.selectedEnemy.getPosition().getX() % 32 != 0) {
                this.selectedEnemy.moveLeft();
            }
        }

        return this.selectedEnemy.getPosition();
    }

    private boolean isAccessible() {
        boolean result = false;

        for (BoxImpl currentBox : this.boxes) {
            result = currentBox.getCollider().intersects(this.selectedEnemy.getCollider()) ? true : false;
        }

        for (HardWall currentWall : this.walls) {
            result = currentWall.getCollider().intersects(this.selectedEnemy.getCollider()) ? true : false;
        }

        return result;
    }

    /**
     * This method adds new positions to check in the search algorithm. In
     * particular, this method builds the tree or graph, where the BFS has to be
     * performed.
     * 
     * @param currentNode The current node to set as a parent of the nodes that will
     *                    be created.
     */
    private void addTargets(final Node node) {
        /* Variables declaration. */
        P2d currentInitialPosition = this.selectedEnemy.getPosition();
        P2d positionToCheck;

        for (Direction currentDirection : Direction.values()) {
            positionToCheck = this.doMovements(currentDirection);

            if (!this.visitedPosition.contains(positionToCheck) && isAccessible()) {
                this.positionsToVisit.add(new NodeImpl(currentDirection, positionToCheck, node));
            }
        }
        this.selectedEnemy.setPosition(currentInitialPosition);
    }

    /**
     * This method search the shortest path to reach the player. The searching
     * algorithm is a Breadth-First Search algorithm.
     * 
     * @param initialPosition The enemy position.
     * @param destination     The player position.
     * @return A list of directions that defines the shortest path.
     */
    private List<Direction> shortestPath(final P2d initialPosition, final P2d destination) {
        /* Variables declaration. */
        List<Direction> path = null;

        // Setting the initial node.
        this.positionsToVisit.add(new NodeImpl(null, initialPosition, null));

        while (!this.positionsToVisit.isEmpty()) {
            Node currentNode = this.positionsToVisit.remove();
            if (currentNode.getPosition().equals(destination)) {
                path = currentNode.getPath();
            }
            this.visitedPosition.add(currentNode.getPosition());
            this.addTargets(currentNode);
        }
        return path;
    }
}