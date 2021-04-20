package bomberOne.model.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberOne.model.World;
import bomberOne.model.WorldImpl;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;

public class TestWorld {

    private World world = new WorldImpl(Difficulty.STANDARD, Skins.BLACK);

    @Test
    public void testSetBox() {
        assertEquals(world.getGameObjectCollection().getBoxList().size(), 80);
    }
}
