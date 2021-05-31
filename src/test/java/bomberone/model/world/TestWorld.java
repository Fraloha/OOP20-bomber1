package bomberone.model.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.match.Difficulty;
import bomberone.model.user.Skins;
import bomberone.tools.ResourcesLoader;

/**
 * Test the world.
 */
public class TestWorld {

    private static final int NUMBOX = 80;
    private static final int NUMPOWERUP = 20;
    private World world;

    @BeforeEach
    public final void init() {
        ResourcesLoader.getInstance().start();
        world = new WorldImpl(Difficulty.EASY, Skins.BLACK);
    }

    /**
     * Test if each GameObject has been created.
     */
    @Test
    public void testWorld() {
        assertFalse(world.getGameObjectCollection().getHardWallList().size() == 0);
        assertEquals(world.getBomber().getPosition(), new P2d(32, 32));
        assertEquals(world.getGameObjectCollection().getBoxList().size(), NUMBOX);
        assertEquals(world.getGameObjectCollection().getPowerUpList().size(), NUMPOWERUP);
        assertEquals(world.getGameObjectCollection().getEnemyList().size(), 3);
        assertEquals(world.getRespawn(), false);
    }
}
