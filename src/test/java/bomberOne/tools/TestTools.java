package bomberOne.tools;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bomberOne.model.User;
import bomberOne.model.UserImpl;
import bomberOne.tools.img.ImagesObj;
import bomberOne.tools.img.SpriteMapsObj;

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
		ImagesLoader.start();
		assertNotNull(ImagesObj.BACKGROUND.getImage());
		assertNotNull(ImagesObj.BOMB.getImage());
		assertNotNull(ImagesObj.BOX.getImage());
		assertNotNull(ImagesObj.FIRE.getImage());
		assertNotNull(ImagesObj.HARDWALL.getImage());
		assertNotNull(ImagesObj.ICON.getImage());
		assertNotNull(ImagesObj.POWER_BOMB.getImage());
		assertNotNull(ImagesObj.POWER_FIREPOWER.getImage());
		assertNotNull(ImagesObj.POWER_PIERCE.getImage());
		assertNotNull(ImagesObj.POWER_SPEED.getImage());
		assertNotNull(ImagesObj.POWER_TIMER.getImage());
		assertNotNull(ImagesObj.SPAWN.getImage());
		
		assertNotNull(SpriteMapsObj.PLAYER_1.getImage());
		assertNotNull(SpriteMapsObj.PLAYER_2.getImage());
		assertNotNull(SpriteMapsObj.PLAYER_3.getImage());
		assertNotNull(SpriteMapsObj.PLAYER_4.getImage());
		assertNotNull(SpriteMapsObj.ENEMIES_HARD.getImage());
		assertNotNull(SpriteMapsObj.ENEMIES_STANDARD.getImage());
	}
}
