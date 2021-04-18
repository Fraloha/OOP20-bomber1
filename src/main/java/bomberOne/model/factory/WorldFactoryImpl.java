package bomberOne.model.factory;

import bomberOne.model.World;
import bomberOne.model.WorldImpl;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.User;

public class WorldFactoryImpl implements WorldFactory {

    @Override
    public final World createWorldStandard(final User user) {
        return new WorldImpl(Difficulty.STANDARD, user.getSkin());
    }

    @Override
    public final World createWorldHard(final User user) {
        return new WorldImpl(Difficulty.HARD, user.getSkin());
    }
}
