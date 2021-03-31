package bomberOne.model.factory;

import java.awt.image.BufferedImage;

import bomberOne.model.Difficulty;
import bomberOne.model.Skins;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.BoxImpl;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.gameObjects.PowerUp.type;
import bomberOne.model.gameObjects.PowerUpImpl;
import bomberOne.tools.img.ImagesObj;

public class GameObjectFactoryImpl implements GameObjectFactory {

	@Override
	public GameObject createBomber(P2d position, Skins color) {
		//return new Bomber();
		return null;
	}

	@Override
	public GameObject createEnemy(P2d position, Difficulty diff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameObject createBox(P2d position) {
		return new BoxImpl(position, ImagesObj.BOX.getImage(), 1, true);
	}

	@Override
	public GameObject createPowerUp(P2d position, type type) {
		
		BufferedImage powerUpImage = new BufferedImage(0, 0, 0);
		if(type.equals(PowerUp.type.FirePower)) {
			powerUpImage = ImagesObj.POWER_FIREPOWER.getImage();
		}
		if(type.equals(PowerUp.type.Pierce)) {
			powerUpImage = ImagesObj.POWER_PIERCE.getImage();
		}
		if(type.equals(PowerUp.type.Speed)) {
			powerUpImage = ImagesObj.POWER_SPEED.getImage();
		}
		if(type.equals(PowerUp.type.Time)) {
			powerUpImage = ImagesObj.POWER_TIMER.getImage();
		}
		PowerUp pU = new PowerUpImpl(position, powerUpImage, 1, true, type);
		return pU;
	}

	@Override
	public GameObject createHardWall(P2d position) {
		return new HardWall(position, ImagesObj.HARDWALL.getImage(), 1, false);
	}

}
