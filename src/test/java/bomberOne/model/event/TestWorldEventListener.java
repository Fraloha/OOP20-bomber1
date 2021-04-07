package bomberOne.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.Difficulty;
import bomberOne.model.GameModel;
import bomberOne.model.GameModelImpl;
import bomberOne.model.Skins;
import bomberOne.model.World;
import bomberOne.model.WorldImpl;
import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.ExplosionImpl;
import bomberOne.tools.ImagesLoader;


/**
 * Test if the WorldEventListener takes correctly events in input, put them on the queue 
 * and if it process them in the right way.
 * @author Luigi
 *
 */
public class TestWorldEventListener {

	static final int EXPECTED_N_EVENTS = 2;
	
	WorldEventListener listener;
	World world;
	GameModel model;
	GameObjectFactory factory;
	
	@BeforeEach
    public void init() {
		listener = new WorldEventListenerImpl();
		ImagesLoader.loadImages();
		ImagesLoader.sliceSprite();
		world = new WorldImpl(Difficulty.STANDARD, Skins.BLACK);
		model = new GameModelImpl();
		factory = new GameObjectFactoryImpl();
    }
	
	/**
	 * Test if objects that collide with the fire are hitted correctly
	 */
	@Test
	public void TestCollisionEvent() {
		
		model.setWorld(world);
		this.listener.setGameModel(model);
		world.getGameObjectCollection().spawn(factory.createBox(new P2d(32, 32)));
		this.listener.notifyEvent(new HitFireEvent(world.getGameObjectCollection().getBoxList().get(0)));
		this.listener.processEvents();
		assertFalse(world.getGameObjectCollection().getBoxList().get(0).isAlive());
	}
	
	/**
	 * Test if the Listener handle correctly the explosions without Pierce
	 * 
	 */
	@Test
	public void TestExplosionWithoutPierce() {
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
	* Test handle correctly the explosions with Pierce
	*
	*/
	@Test
	public void TestExplosionWithPierce(){
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
