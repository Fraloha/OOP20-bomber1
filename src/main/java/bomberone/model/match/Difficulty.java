package bomberone.model.match;

/**
 * The difficulty of the match, set by the Player when start the game.
 *
 */
public enum Difficulty {

    /**
     * 
     */
    STANDARD(80),

    /**
     * 
     */
    HARD(100);

    private int numBox;

    Difficulty(final int num) {
        this.numBox = num;
    }

    public int getNumBox() {
        return this.numBox;
    }
}
