package bomberone.model.factory;

import bomberone.model.match.Difficulty;
import bomberone.model.user.User;
import bomberone.model.world.World;
import bomberone.model.world.WorldImpl;

public class WorldFactoryImpl implements WorldFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public final World createWorldStandard(final User user) {
        return new WorldImpl(Difficulty.EASY, user.getSkin());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final World createWorldHard(final User user) {
        return new WorldImpl(Difficulty.HARD, user.getSkin());
    }
}
