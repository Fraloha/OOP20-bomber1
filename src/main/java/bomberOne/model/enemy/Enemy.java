package bomberOne.model.enemy;

import bomberOne.model.gameObjects.AnimatedEntity;
import bomberOne.model.gameObjects.Box;
import bomberOne.model.gameObjects.HardWall;
import java.util.LinkedList;


/**
 * This interface define a basic enemy.
 * @author Francesco
 *
 */
public interface Enemy extends AnimatedEntity{
	
	public void setBoxes(LinkedList<Box> boxes);
	
	public void setWalls(LinkedList<HardWall> walls);
	
	public LinkedList<Box> getBoxes();
	
	public LinkedList<HardWall> getWalls();
}