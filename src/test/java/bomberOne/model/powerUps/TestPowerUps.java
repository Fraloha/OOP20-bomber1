package bomberOne.model.powerUps;
import bomberOne.tools.img.ImagesObj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.gameObjects.PowerUpImpl;

public class TestPowerUps {

	PowerUp pUp = new PowerUpImpl(new P2d(0,0), ImagesObj.POWER_FIREPOWER.getImage(),1, false, PowerUp.type.FirePower);
	
	@Test
	public void testReleased() {
		assertFalse(pUp.isReleased());
		pUp.release();
		assertTrue(pUp.isReleased());
	}
	
	@Test
	public void testType() {
		assertEquals(PowerUp.type.FirePower, pUp.getType());
		assertEquals(ImagesObj.POWER_FIREPOWER.getImage(), pUp.getImage());
	}
	
}
