package bomberOne.model.factory;

import bomberOne.model.World;

public interface WorldFactory {

	/**
	 * This method creates the World for standard Difficulty
	 * @return the standard World
	 */
	World createWorldStandard();
	
	/**
	 * This method creates the World for hard Difficulty
	 * @return the hard World
	 */
	World createWorldHard();
}
