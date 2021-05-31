package bomberone.builder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;

/**
 * Testing pattern Builder in UserImpl.
 *
 */
class BuilderTest {

    @Test
    void test() {
        User user = new UserImpl.Builder("Mario")
                            .skin(Skins.BLACK)
                            .controls(Controls.ARROW)
                            .build();
        assertTrue(user.getName().equals("Mario"));
        assertTrue(user.getSkin().equals(Skins.BLACK));
    }

}
