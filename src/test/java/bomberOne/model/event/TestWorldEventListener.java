package bomberOne.model.event;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	WorldEventListener listener = new WorldEventListenerImpl();
	
	@Test
	public void TestSetGetModel() {
		
	}
	
	/**
	 * Test if the Listener add events, and process them correctly
	 */
	@Test
	public void TestExplosionEvent() {
		ImagesLoader.loadImages();
		ImagesLoader.sliceSprite();
		GameObjectFactory factory = new GameObjectFactoryImpl();
		World world = new WorldImpl(Difficulty.STANDARD, Skins.BLACK);
		GameModel model = new GameModelImpl();
		model.setWorld(world);
		this.listener.setGameModel(model);
		world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(32, 32)));
		world.getGameObjectCollection().spawn(factory.createHardWall(new P2d(96, 32)));
		this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(3, false, new P2d(64, 32))));
		this.listener.processEvents();
		assertTrue(world.getGameObjectCollection().getFireList().size() == 3);
		this.listener.notifyEvent(new ExplosionEvent(new ExplosionImpl(3, true, new P2d(64, 32))));
		this.listener.processEvents();
		assertTrue(world.getGameObjectCollection().getGameObjectCollection().size() == 7);
	}
	
}
