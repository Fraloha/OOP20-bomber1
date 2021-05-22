package bomberone.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;

class BuilderTest {

    @Test
    void test() {
        User user = new UserImpl.Builder("Ciccio")
                            .skin(Skins.BLACK)
                            .controls(Controls.ARROW)
                            .build();
        assertTrue(user.getName().equals("Ciccio"));
        assertTrue(user.getSkin().equals(Skins.BLACK));
    }

}
