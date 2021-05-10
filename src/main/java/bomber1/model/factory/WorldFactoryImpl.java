package bomber1.model.factory;

import bomber1.model.Difficulty;
import bomber1.model.World;
import bomber1.model.WorldImpl;
import bomber1.model.user.User;

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
