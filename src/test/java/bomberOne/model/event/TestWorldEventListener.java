package bomberOne.model.event;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.gameObjects.PowerUpImpl;
import bomberOne.tools.img.ImagesObj;;

/**
 * Test if the WorldEventListener takes correctly events in input, put them on the queue 
 * and if it process them in the right way.
 * @author Luigi
 *
 */
public class TestWorldEventListener {

	static final int EXPECTED_N_EVENTS = 2;
	
	WorldEventListener listener = new WorldEventListenerImpl();
	
	@Test
	public void TestSetGetModel() {
		
	}
	
	/**
	 * Test if the Listener add events, and process them correctly
	 */
	@Test
	public void TestNotifyEvent() {
		//this.listener.notifyEvent(new ExplosionEvent(exp));
		this.listener.notifyEvent(new HitBorderEvent(new HardWall(new P2d(0, 0), ImagesObj.HARDWALL.getImage(), 0, false), 10));
		this.listener.notifyEvent(new PickPowerUpEvent(new PowerUpImpl(new P2d(0, 0), ImagesObj.POWER_BOMB.getImage(), 0, false, PowerUp.type.FirePower)));
		assertEquals(EXPECTED_N_EVENTS, this.listener.getEventList().size());
		//process all the events
		this.listener.processEvents();
		//check if the List is now Empty
		assertTrue(this.listener.getEventList().isEmpty());
	
	}
	
}
