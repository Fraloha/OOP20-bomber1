package bomberOne.model.enemy;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;

public class EnemyImpl extends AnimatedEntityImpl implements Enemy{
	
	/* Fields. */
	
	/* Constructors. */
	public EnemyImpl(P2d position, BufferedImage img, int elapsed, boolean isAlive) {
		super(position, img, elapsed, isAlive);
	}
}