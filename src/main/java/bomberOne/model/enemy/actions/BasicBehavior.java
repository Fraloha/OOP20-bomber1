package bomberOne.model.enemy.actions;

import java.util.Random;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.gameObjects.GameObject;
import java.util.LinkedList;

public class BasicBehavior implements Actions{
	
	/* Fields. */
	Random randomGenerator = new Random();
	Enemy selectedEnemy;
	int frameCounter;
	
	/* Constructors. */
	public BasicBehavior(Enemy newEnemy) {
		this.selectedEnemy = newEnemy;
		this.frameCounter = 1;
	}
	
	/* Methods. */
	@Override
	public P2d doAction(P2d currentPosition, double speed) {
		
		return currentPosition;
	}
	
	public boolean freePath(LinkedList<? extends GameObject> objects) {
		
		/* Variables declaration. */
		boolean resultBoxes = true;
		boolean resultWalls = true;
		
		//Checking if the enemy is colliding with any objects in the list.
		for(GameObject obj : this.selectedEnemy.getBoxes()) {
			if(this.selectedEnemy.getBoundingBox().isCollidingWith(obj.getBoundingBox())) {
				resultBoxes = false;
				break;
			}
		}
		
		for(GameObject obj : this.selectedEnemy.getWalls()) {
			if(this.selectedEnemy.getBoundingBox().isCollidingWith(obj.getBoundingBox())) {
				resultWalls = false;
			}
		}
		
		return resultBoxes | resultWalls;
	}
}