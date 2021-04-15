package bomberone.model.factory;

import bomberone.model.World;
import bomberone.model.user.User;

public interface WorldFactory {

	/**
	 * This method creates the World for standard Difficulty
	 * @return the standard World
	 */
	World createWorldStandard(User user);
	
	/**
	 * This method creates the World for hard Difficulty
	 * @return the hard World
	 */
	World createWorldHard(User user);
}
