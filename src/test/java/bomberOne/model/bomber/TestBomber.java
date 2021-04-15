package bomberone.model.bomber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberone.model.bomber.Bomber;
import bomberone.model.bomber.BomberImpl;
import bomberone.model.bomber.PowerUpHandlerImpl;
import bomberone.model.common.Direction;
import bomberone.model.common.P2d;
import bomberone.model.gameObjects.PowerUp;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.img.AnimatedObjectsSprites;

/**
 * Tester for BomberImpl
 * @author Gustavo Mazzanti
 *
 */
public class TestBomber {
	
	BomberImpl bomber;
	PowerUpHandlerImpl activator;
	
	@BeforeEach
	public void init() {
		ResourcesLoader.start();
		bomber = new BomberImpl(new P2d(0, 0), AnimatedObjectsSprites.PLAYER_1.getSprites(), 3);
		activator = new PowerUpHandlerImpl(bomber);
		bomber.setUpHandler(activator);
	}
	
	@Test
	public void testInitializer() {
		assertTrue(bomber.getSpeed() == Bomber.SPEED);
		assertTrue(bomber.getAmmo() == Bomber.AMMO);
	}
	
	@Test
	public void testLifes() {
		System.out.println(bomber.getLifes());
		assertTrue(bomber.getLifes() == 3);
		bomber.addLifes(1);
		assertTrue(bomber.getLifes() == 4);
		bomber.hitted();
		assertTrue(bomber.getLifes() == 3);
	}
	
	@Test
	public void testRespawn() {
		assertTrue(bomber.isAlive());
		bomber.hitted();
		assertFalse(bomber.isAlive());
		bomber.respawn();
		assertTrue(bomber.isAlive());
	}
	
	@Test
	public void testAmmo() {
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO);
		this.bomber.applyPowerUp(PowerUp.Type.Ammo);
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO + BomberImpl.AMMO_INC);
		this.bomber.plantBomb();
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO + BomberImpl.AMMO_INC - 1);
		this.bomber.plantBomb();
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO + BomberImpl.AMMO_INC - 2);
		this.bomber.restoreAmmo();
		this.bomber.restoreAmmo();
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO + BomberImpl.AMMO_INC);
		this.bomber.restoreAmmo();
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO + BomberImpl.AMMO_INC);
		this.bomber.respawn();
		assertTrue(this.bomber.getAmmo() == Bomber.AMMO);
	}
	
	@Test
	public void testPowerUp() {
		assertTrue(this.bomber.getFirePower() == Bomber.FIRE_POWER);
		this.bomber.applyPowerUp(PowerUp.Type.FirePower);
		assertTrue(this.bomber.getFirePower() == Bomber.FIRE_POWER + BomberImpl.FIRE_POWER_INC);
		this.bomber.applyPowerUp(PowerUp.Type.FirePower);
		assertTrue(this.bomber.getFirePower() == Bomber.FIRE_POWER + (2 * BomberImpl.FIRE_POWER_INC));
		assertFalse(this.bomber.isPierced());
		this.bomber.applyPowerUp(PowerUp.Type.Pierce);
		assertTrue(this.bomber.isPierced());
		assertTrue(this.bomber.getSpeed() == Bomber.SPEED);
		this.bomber.applyPowerUp(PowerUp.Type.Speed);
		assertTrue(this.bomber.getSpeed() == Bomber.SPEED + BomberImpl.SPEED_INC);
		this.bomber.applyPowerUp(PowerUp.Type.Speed);
		assertTrue(this.bomber.getSpeed() == Bomber.SPEED + (2 * BomberImpl.SPEED_INC));
		this.bomber.respawn();
		assertTrue(this.bomber.getFirePower() == Bomber.FIRE_POWER);
		assertFalse(this.bomber.isPierced());
		assertTrue(this.bomber.getSpeed() == Bomber.SPEED);
	}
	
	@Test
	public void testMovement() {
		assertTrue(this.bomber.getDirection() == Bomber.DIR);
		this.bomber.moveLeft();
		assertTrue(this.bomber.getDirection() == Direction.LEFT);
		this.bomber.moveUp();
		assertTrue(this.bomber.getDirection() == Direction.UP);
		this.bomber.moveRight();
		assertTrue(this.bomber.getDirection() == Direction.RIGHT);
		this.bomber.moveDown();
		assertTrue(this.bomber.getDirection() == Direction.DOWN);
	}
}
