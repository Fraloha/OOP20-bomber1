package bomberOne.model.factory;

import bomberOne.model.World;
import bomberOne.model.WorldImpl;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.User;

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
