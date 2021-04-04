package bomberOne.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberOne.model.WorldFactory;
import bomberOne.model.WorldFactoryImpl;
import bomberOne.model.bomber.Bomber;
import bomberOne.model.common.P2d;
import bomberOne.tools.img.ImagesObj;

public class TestWorld {

	WorldFactory factory = new WorldFactoryImpl();
	
	@Test
	public void testStandardWorld() {
		World standardWorld = factory.createWorldStandard();
		assertTrue(standardWorld.getBomber().getPosition().equals(new Bomber(new P2d(1,1), ImagesObj.ICON.getImage(), 3, true).getPosition()));
	}
}
