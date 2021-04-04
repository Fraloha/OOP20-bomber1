package bomberOne.model.factory;

import bomberOne.model.World;
import bomberOne.model.WorldImpl;

public class WorldFactoryImpl implements WorldFactory {
	
	@Override
	public World createWorldStandard() {
		// TODO Auto-generated method stub
		return new WorldImpl(false);
	}

	@Override
	public World createWorldHard() {
		// TODO Auto-generated method stub
		return new WorldImpl(true);
	}
}
