package bomberOne.model.gameObjectCollection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.BombImpl;
import bomberOne.model.gameObjects.Box;
import bomberOne.model.gameObjects.BoxImpl;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.GameObjectCollection;
import bomberOne.model.gameObjects.GameObjectCollectionImpl;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.tools.img.AnimatedObjectsSprites;
import bomberOne.tools.img.ObjectsImages;

import java.util.LinkedList;
import java.util.List;

import java.awt.image.BufferedImage;

/**
 * Test if the gameObjectCollection is ok.
 *
 */
public class TestGameObjectCollection {

    private GameObjectCollection collection = new GameObjectCollectionImpl();

    @Test
    public void testSpawnDespawn() {
        List<GameObject> list = new LinkedList<>();
        Bomb bomb = new BombImpl(new P2d(32, 1), AnimatedObjectsSprites.BOMB.getSprites(), 1, 1, true);
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
        Box box = new BoxImpl(new P2d(32, 1), new BufferedImage(3, 3, 3), 1);
        boxList.add(box);
        List<HardWall> wallList = new LinkedList<>();
        HardWall wall = new HardWall(new P2d(33, 1), new BufferedImage(2, 3, 3), 1);
        wallList.add(wall);
        collection.spawn(box);
        collection.spawn(wall);
        assertTrue(collection.getBoxList().size() == 1);
        assertTrue(collection.getHardWallList().equals(wallList));
    }

}
