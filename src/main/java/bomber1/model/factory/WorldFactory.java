package bomber1.model.factory;

import bomber1.model.World;
import bomber1.model.user.User;

public interface WorldFactory {

    /**
     * This method creates the World for standard Difficulty.
     * @param user The user of the game
     * @return the standard World
     */
    World createWorldStandard(User user);

    /**
     * This method creates the World for hard Difficulty.
     * @param user The user of the game
     * @return the hard World
     */
    World createWorldHard(User user);
}
