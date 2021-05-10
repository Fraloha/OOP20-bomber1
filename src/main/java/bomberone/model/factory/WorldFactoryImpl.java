package bomberone.model.factory;

import bomberone.model.Difficulty;
import bomberone.model.World;
import bomberone.model.WorldImpl;
import bomberone.model.user.User;

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
