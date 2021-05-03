package bomberOne.model.gameObject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.FireImpl;

/**
 * Tester for Fire.
 *
 */
public class TestFire {
    private FireImpl fire;
    private static final int LIFE_TIME = 100;

    /**
     * 
     */
    @BeforeEach
    public void init() {
        this.fire = (FireImpl) new GameObjectFactoryImpl().createFire(new P2d(10, 10));
    }

    @Test
    public void testUpdate() {
        for (int c = 0; c < this.LIFE_TIME; c++) {
            this.fire.update(0);
            assertTrue(this.fire.isAlive());
        }
        this.fire.update(0);
        assertFalse(this.fire.isAlive());
    }

}
