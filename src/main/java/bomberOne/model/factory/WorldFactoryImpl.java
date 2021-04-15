package bomberone.model.factory;

import bomberone.model.World;
import bomberone.model.WorldImpl;
import bomberone.model.user.Difficulty;
import bomberone.model.user.User;

public class WorldFactoryImpl implements WorldFactory {
	
	@Override
	public World createWorldStandard(User user) {
		// TODO Auto-generated method stub
		return new WorldImpl(Difficulty.STANDARD, user.getSkin());
	}

	@Override
	public World createWorldHard(User user) {
		// TODO Auto-generated method stub
		return new WorldImpl(Difficulty.HARD, user.getSkin());
	}
}
