package bomberone.model.factory;

import java.awt.image.BufferedImage;

import bomberone.model.bomber.BomberImpl;
import bomberone.model.common.P2d;
import bomberone.model.gameObjects.BombImpl;
import bomberone.model.gameObjects.BoxImpl;
import bomberone.model.gameObjects.FireImpl;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.HardWall;
import bomberone.model.gameObjects.PowerUp;
import bomberone.model.gameObjects.PowerUpImpl;
import bomberone.model.gameObjects.PowerUp.type;
import bomberone.model.user.Difficulty;
import bomberone.model.user.Skins;
import bomberone.tools.img.AnimatedObjectsSprites;
import bomberone.tools.img.ObjectsImages;

public class GameObjectFactoryImpl implements GameObjectFactory {

	private static final int BOMBER_LIFES = 3;
	
	@Override
	public GameObject createBomber(P2d position, Skins color) {
		BufferedImage [][] images = null;
		if(color.equals(Skins.WHITE)) {
			images = AnimatedObjectsSprites.PLAYER_1.getSprites();
		}
		if(color.equals(Skins.BLACK)) {
			images = AnimatedObjectsSprites.PLAYER_2.getSprites();
		}
		if(color.equals(Skins.RED)) {
			images = AnimatedObjectsSprites.PLAYER_3.getSprites();
		}
		if(color.equals(Skins.BLUE)) {
			images = AnimatedObjectsSprites.PLAYER_4.getSprites();
		}
		return new BomberImpl(position, images, GameObjectFactoryImpl.BOMBER_LIFES);
	}

	@Override
	public GameObject createEnemy(P2d position, Difficulty diff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameObject createBox(P2d position) {
		return new BoxImpl(position, ObjectsImages.BOX.getImage(), 1);
	}

	@Override
	public GameObject createPowerUp(P2d position, type type) {
		
		BufferedImage powerUpImage = new BufferedImage(0, 0, 0);
		if(type.equals(PowerUp.type.FirePower)) {
			powerUpImage = ObjectsImages.POWER_FIREPOWER.getImage();
		}
		if(type.equals(PowerUp.type.Pierce)) {
			powerUpImage = ObjectsImages.POWER_PIERCE.getImage();
		}
		if(type.equals(PowerUp.type.Speed)) {
			powerUpImage = ObjectsImages.POWER_SPEED.getImage();
		}
		if(type.equals(PowerUp.type.Time)) {
			powerUpImage = ObjectsImages.POWER_TIMER.getImage();
		}
		PowerUp pU = new PowerUpImpl(position, powerUpImage, 1, true, type);
		return pU;
	}

	@Override
	public GameObject createHardWall(P2d position) {
		return new HardWall(position, ObjectsImages.HARDWALL.getImage(), 1);
	}

	@Override
	public GameObject createFire(P2d position) {
		return new FireImpl(position, ObjectsImages.FIRE.getImage(), 1);
	}

	@Override
	public GameObject createBomb(P2d position, int firePower, boolean pierce) {
		return new BombImpl(position, ObjectsImages.BOMB.getImage(), 1, firePower, pierce);
	}

}
