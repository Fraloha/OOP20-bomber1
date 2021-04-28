package bomberOne.tools;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bomberOne.model.user.User;
import bomberOne.model.user.UserImpl;
import bomberOne.tools.DirectoryLoader;
import bomberOne.tools.RankLoader;
import bomberOne.tools.ResourcesLoader;
import bomberOne.tools.img.AnimatedObjectsSprites;
import bomberOne.tools.img.GameImages;
import bomberOne.tools.maps.Maps;

public class TestTools {

    /**
     * Test if the methods of DirectoryLoader throw IOException.
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
     * This method test if the RankLoader read and write correctly on the files.
     */
    @Test
    public void testRankLoader() {
        List<User> userList1 = new ArrayList<>();
        List<User> userList2 = new ArrayList<>();

        // Create some User and put them on the Lists
        User user1 = new UserImpl();
        User user2 = new UserImpl();
        user1.setName("GIGI");
        user1.setScore(100);
        user2.setName("MARIO");
        user2.setScore(150);
        userList1.add(user1);
        userList2.add(user2);
        // Write the list on the Files
        RankLoader.writeUsers(userList1, userList2);
        // Create other two list, fill them with the item reads from file and check if
        // this list are equals to the previous
        List<User> userList3 = new ArrayList<>();
        List<User> userList4 = new ArrayList<>();
        RankLoader.readUsers(userList3, userList4);
        assertTrue(userList3.get(0).getName().equals(user1.getName()));
        assertTrue(userList3.get(0).getScore() == (user1.getScore()));
        assertTrue(userList4.get(0).getName().equals(user2.getName()));
        assertTrue(userList4.get(0).getScore() == (user2.getScore()));
    }

    /**
     * This method tests if ResourceLoader load correctly all the images.
     */
    @Test
    public void testResourceLoader() {
        ResourcesLoader.start();
        assertNotNull(GameImages.BOMBER1SCOREBOARD.getImage());
        assertNotNull(GameImages.BACKGROUND.getImage());
        assertNotNull(GameImages.BOMB.getImage());
        assertNotNull(GameImages.BOX.getImage());
        assertNotNull(GameImages.HARDWALL.getImage());
        assertNotNull(GameImages.ICON.getImage());
        assertNotNull(GameImages.POWER_BOMB.getImage());
        assertNotNull(GameImages.POWER_FIREPOWER.getImage());
        assertNotNull(GameImages.POWER_PIERCE.getImage());
        assertNotNull(GameImages.POWER_SPEED.getImage());
        assertNotNull(GameImages.POWER_TIMER.getImage());
        assertNotNull(GameImages.SPAWN.getImage());

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
        List<List<String>> list = Maps.MAP1.getList();
        assertNotNull(list);
        assertTrue(list.get(0).get(0).equals("H"));
        assertFalse(list.get(9).get(9).equals("H"));
    }
}
