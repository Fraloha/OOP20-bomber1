package bomberOne.tools;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bomberOne.model.user.User;
import bomberOne.model.user.UserImpl;
import bomberOne.tools.img.ObjectsImages;
import bomberOne.tools.maps.Maps;
import bomberOne.tools.img.AnimatedObjectsSprites;

public class TestTools {

	/**
	 * Test if the methods of DirectoryLoader throw IOException
	 */
	@Test
	public void testDirectoryLoader() {
		boolean done = true;
		try {
			DirectoryLoader.start();
		} catch (IOException e) {
			done = false;
		}
		assertTrue(done);
	}
	
	/**
	 * This method test if the RankLoader read and write correctly on the files
	 */
	@Test
	public void testRankLoader() {
		List<User> userList1 = new ArrayList<>();
		List<User> userList2 = new ArrayList<>();
		
		//Create some User and put them on the Lists
		User user1 = new UserImpl();
		User user2 = new UserImpl();
		user1.setName("GIGI");
		user1.setScore(100);
		user2.setName("MARIO");
		user2.setScore(150);
		userList1.add(user1);	
		userList2.add(user2);
		//Write the list on the Files
		RankLoader.writeUsers(userList1, userList2);
		//Create other two list, fill them with the item reads from file and check if this list are equals to the previous
		List<User> userList3 = new ArrayList<>();
		List<User> userList4 = new ArrayList<>();
		RankLoader.readUsers(userList3, userList4);
		assertTrue(userList3.get(0).getName().equals(user1.getName()));
		assertTrue(userList3.get(0).getScore() == (user1.getScore()));
		assertTrue(userList4.get(0).getName().equals(user2.getName()));
		assertTrue(userList4.get(0).getScore() == (user2.getScore()));
	}
	
	/**
	 * This method tests if ImageLoader load correctly all the images
	 */
	@Test
	public void testImageLoader() {
		ResourcesLoader.start();
		assertNotNull(ObjectsImages.BOMBER1SCOREBOARD.getImage());
		assertNotNull(ObjectsImages.BACKGROUND.getImage());
		assertNotNull(ObjectsImages.BOMB.getImage());
		assertNotNull(ObjectsImages.BOX.getImage());
		assertNotNull(ObjectsImages.FIRE.getImage());
		assertNotNull(ObjectsImages.HARDWALL.getImage());
		assertNotNull(ObjectsImages.ICON.getImage());
		assertNotNull(ObjectsImages.POWER_BOMB.getImage());
		assertNotNull(ObjectsImages.POWER_FIREPOWER.getImage());
		assertNotNull(ObjectsImages.POWER_PIERCE.getImage());
		assertNotNull(ObjectsImages.POWER_SPEED.getImage());
		assertNotNull(ObjectsImages.POWER_TIMER.getImage());
		assertNotNull(ObjectsImages.SPAWN.getImage());
		
		assertNotNull(AnimatedObjectsSprites.PLAYER_1.getImage());
		assertNotNull(AnimatedObjectsSprites.PLAYER_2.getImage());
		assertNotNull(AnimatedObjectsSprites.PLAYER_3.getImage());
		assertNotNull(AnimatedObjectsSprites.PLAYER_4.getImage());
		assertNotNull(AnimatedObjectsSprites.ENEMIES_HARD.getImage());
		assertNotNull(AnimatedObjectsSprites.ENEMIES_STANDARD.getImage());
	}
	
	@Test
	public void testMapLoader() {
		ResourcesLoader.start();
		assertNotNull(Maps.MAP1.getList());
	}
}
