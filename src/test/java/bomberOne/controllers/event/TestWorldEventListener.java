package bomberOne.controllers.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.Difficulty;
import bomberOne.model.GameModel;
import bomberOne.model.GameModelImpl;
import bomberOne.model.World;
import bomberOne.model.WorldImpl;
import bomberOne.model.common.P2d;
import bomberOne.controllers.game.event.ExplosionEvent;
import bomberOne.controllers.game.event.HitEntityEvent;
import bomberOne.controllers.game.event.WorldEventListener;
import bomberOne.controllers.game.event.WorldEventListenerImpl;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.ExplosionImpl;
import bomberOne.model.user.Skins;
import bomberOne.tools.ResourcesLoader;

/**
 * Test if the WorldEventListener takes correctly events in input, put them on
 * the queue and if it process them in the right way.
 * 
 *
 */
public class TestWorldEventListener {

    private static final int EXPECTED_SCORE = 50;

    static final int EXPECTED_N_EVENTS = 2;

    private WorldEventListener listener;
    private World world;
    private GameModel model;
    private GameObjectFactory factory;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        listener = new WorldEventListenerImpl();
        ResourcesLoader.start();
        world = new WorldImpl(Difficulty.STANDARD, Skins.BLACK);
        model = new GameModelImpl();
        factory = new GameObjectFactoryImpl();
    }

    /**
     * Test if objects that collide with the fire are hitted correctly.
     */
    @Test
    public void testCollisionEvent() {

        model.setWorld(world);
        this.listener.setGameModel(model);
        assertEquals(this.model.getScore(), 0);
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(32, 32)));
        this.listener.notifyEvent(new HitEntityEvent(world.getGameObjectCollection().getBoxList().get(0)));
        this.listener.processEvents();
        assertEquals(this.model.getScore(), EXPECTED_SCORE);
        assertFalse(world.getGameObjectCollection().getBoxList().get(0).isAlive());
    }

    /**
     * Test if the Listener handle correctly the explosions without Pierce.
     * 
     */
    @Test
    public void testExplosionWithoutPierce() {
        model.setWorld(world);
        this.listener.setGameModel(model);
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(32, 32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(96, 32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(64, 0)));
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(64, 64)));
        this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(3, false, new P2d(64, 32))));
        this.listener.processEvents();
        assertTrue(world.getGameObjectCollection().getFireList().size() == 2);
    }

    /**
     * Test handle correctly the explosions with Pierce.
     *
     */
    @Test
    public void testExplosionWithPierce() {
        model.setWorld(world);
        this.listener.setGameModel(model);
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(32, 32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(96, 32)));
        world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(64, 0)));
        world.getGameObjectCollection().spawn(factory.createBox(new P2d(64, 64)));
        this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(3, true, new P2d(64, 32))));
        this.listener.processEvents();
        assertTrue(world.getGameObjectCollection().getFireList().size() == 3);

    }

}
