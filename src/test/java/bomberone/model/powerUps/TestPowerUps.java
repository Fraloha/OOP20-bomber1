package bomberone.model.powerUps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberone.model.common.P2d;
import bomberone.model.gameObjects.powerUp.PowerUp;
import bomberone.model.gameObjects.powerUp.PowerUpImpl;

public class TestPowerUps {

    private PowerUp pUp = new PowerUpImpl(new P2d(0, 0), 1, false, PowerUp.Type.FirePower);

    @Test
    public void testReleased() {
        assertFalse(pUp.isReleased());
        pUp.release();
        assertTrue(pUp.isReleased());
    }

    @Test
    public void testType() {
        assertEquals(PowerUp.Type.FirePower, pUp.getType());
    }

}
