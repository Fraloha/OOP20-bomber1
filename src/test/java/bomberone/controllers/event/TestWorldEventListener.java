package bomberone.controllers.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.controllers.match.event.ExplosionEvent;
import bomberone.controllers.match.event.HitEntityEvent;
import bomberone.controllers.match.event.WorldEventListener;
import bomberone.controllers.match.event.WorldEventListenerImpl;
import bomberone.model.common.P2d;
import bomberone.model.factory.GameObjectFactory;
import bomberone.model.factory.GameObjectFactoryImpl;
import bomberone.model.gameObjects.bomb.ExplosionImpl;
import bomberone.model.match.Difficulty;
import bomberone.model.match.GameMatch;
import bomberone.model.match.GameMatchImpl;
import bomberone.model.user.Skins;
import bomberone.model.world.World;
import bomberone.model.world.WorldImpl;
import bomberone.tools.ResourcesLoader;

/**
 * Test if the WorldEventListener takes correctly events in input, put them on
 * the queue and if it process them in the right way.
 * 
 *
 */
public class TestWorldEventListener {

    private static final int CONSTANT_2 = 2;

    private static final int CONSTANT_0 = 0;

    private static final int CONSTANT_3 = 3;

    private static final int CONSTANT_64 = 64;

    private static final int CONSTANT_96 = 96;

    private static final int CONSTANT_32 = 32;

    private static final int EXPECTED_SCORE = 50;

    static final int EXPECTED_N_EVENTS = 2;

    private WorldEventListener listener;
    private World world;
    private GameMatch match;
    private GameObjectFactory factory;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        listener = new WorldEventListenerImpl();
        ResourcesLoader.getInstance().start();
        world = new WorldImpl(Difficulty.EASY, Skins.BLACK);
        match = new GameMatchImpl();
        factory = new GameObjectFactoryImpl();
    }

    /**
     * Test if objects that collide with the fire are hitted correctly.
     */
    @Test
    public void testCollisionEvent() {

        match.setWorld(world);
        this.listener.setGameMatch(match);
        assertEquals(this.match.getScore(), 0);
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(CONSTANT_32, CONSTANT_32)));
        this.listener.notifyEvent(new HitEntityEvent(world.getGameObjectCollection().getBoxList().get(0)));
        this.listener.processEvents();
        assertEquals(this.match.getScore(), EXPECTED_SCORE);
        assertFalse(world.getGameObjectCollection().getBoxList().get(0).isAlive());
    }

    /**
     * Test if the Listener handle correctly the explosions without Pierce.
     * 
     */
    @Test
    public void testExplosionWithoutPierce() {
        match.setWorld(world);
        this.listener.setGameMatch(match);
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_32, CONSTANT_32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_96, CONSTANT_32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_64, CONSTANT_0)));
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(CONSTANT_64, CONSTANT_64)));
        this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(CONSTANT_3, false, new P2d(CONSTANT_64, CONSTANT_32))));
        this.listener.processEvents();
        assertTrue(world.getGameObjectCollection().getFireList().size() == CONSTANT_2);
    }

    /**
     * Test handle correctly the explosions with Pierce.
     *
     */
    @Test
    public void testExplosionWithPierce() {
        match.setWorld(world);
        this.listener.setGameMatch(match);
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_32, CONSTANT_32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_96, CONSTANT_32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(CONSTANT_64, CONSTANT_0)));
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(CONSTANT_64, CONSTANT_64)));
        this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(CONSTANT_3, true, new P2d(CONSTANT_64, CONSTANT_32))));
        this.listener.processEvents();
        assertTrue(world.getGameObjectCollection().getFireList().size() == CONSTANT_3);

    }

}
