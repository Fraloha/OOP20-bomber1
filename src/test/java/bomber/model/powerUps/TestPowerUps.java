package bomber.model.powerUps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomber.model.common.GameImages;
import bomber.model.common.P2d;
import bomber.model.gameObjects.PowerUp;
import bomber.model.gameObjects.PowerUpImpl;

public class TestPowerUps {

    private PowerUp pUp = new PowerUpImpl(new P2d(0, 0), GameImages.POWER_FIREPOWER.getImage(), 1, false, PowerUp.Type.FirePower);

    @Test
    public void testReleased() {
        assertFalse(pUp.isReleased());
        pUp.release();
        assertTrue(pUp.isReleased());
    }

    @Test
    public void testType() {
        assertEquals(PowerUp.Type.FirePower, pUp.getType());
        assertEquals(GameImages.POWER_FIREPOWER.getImage(), pUp.getImage());
    }

}
