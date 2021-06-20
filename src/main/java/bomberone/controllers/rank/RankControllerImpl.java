package bomberone.controllers.rank;

import java.util.List;

import bomberone.controllers.ControllerImpl;
import bomberone.model.match.Difficulty;
import bomberone.model.user.User;

/**
 * This class is the rank view controller.
 */
public class RankControllerImpl extends ControllerImpl implements RankController {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getStdRank() {
        return this.getModel().getStdRank();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getHardRank() {
        return this.getModel().getHardRank();
    }

    /**
     * 
     */
    @Override
    public void init() {

    }
}
