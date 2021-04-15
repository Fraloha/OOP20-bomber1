package bomberone.model.gameObjectCollection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.Bomb;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.Box;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.GameObjectCollection;
import bomberone.model.gameObjects.GameObjectCollectionImpl;
import bomberone.model.gameObjects.HardWall;

import java.util.LinkedList;
import java.util.List;

import java.awt.image.BufferedImage;

/**
 * Test if the gameObjectCollection is ok
 * @author Tommaso Brini
 *
 */
public class TestGameObjectCollection {

	GameObjectCollection collection = new GameObjectCollectionImpl();
	
	@Test
	public void testSpawnDespawn() {
		List<GameObject> list = new LinkedList<>();
		Bomb bomb = new BombImpl(new P2d(32,1), new BufferedImage(3,3,3), 1, 1, true);
		list.add(bomb);
		collection.spawn(bomb);
		assertTrue(collection.getGameObjectCollection().equals(list));
		collection.spawn(bomb);
		assertFalse(collection.getGameObjectCollection().equals(list));
		collection.despawn(bomb);
		assertTrue(collection.getGameObjectCollection().equals(list));
	}
	
	@Test
	public void testGetObjectList() {
		List<Box> boxList = new LinkedList<>();
		Box box = new BoxImpl(new P2d(32,1), new BufferedImage(3,3,3), 1);
		boxList.add(box);
		List<HardWall> wallList = new LinkedList<>();
		HardWall wall = new HardWall(new P2d(33,1), new BufferedImage(2,3,3), 1);
		wallList.add(wall);
		collection.spawn(box);
		collection.spawn(wall);
		assertTrue(collection.getBoxList().size()==1);
		assertTrue(collection.getHardWallList().equals(wallList));
	}	
		
	
}
