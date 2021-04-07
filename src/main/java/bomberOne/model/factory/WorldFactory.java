package bomberOne.model.factory;

import bomberOne.model.User;
import bomberOne.model.World;

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
