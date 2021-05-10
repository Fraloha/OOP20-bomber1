package bomber.model.factory;

import bomber.model.Difficulty;
import bomber.model.World;
import bomber.model.WorldImpl;
import bomber.model.user.User;

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
