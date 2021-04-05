package bomberOne.model.factory;

import bomberOne.model.Difficulty;
import bomberOne.model.User;
import bomberOne.model.World;
import bomberOne.model.WorldImpl;

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
