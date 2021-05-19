package bomberone.model;

import java.util.ArrayList;
import java.util.List;

import bomberone.model.match.GameMatch;
import bomberone.model.user.User;
import bomberone.tools.RankLoader;

/**
 * An implementation of GameModel.
 *
 */
public class GameModelImpl implements GameModel {

    private List<User> standardRank = new ArrayList<User>();
    private List<User> hardRank = new ArrayList<User>();
    private GameMatch currentMatch;

    public GameModelImpl() {
        this.hardRank = RankLoader.getInstance().getRankHard();
        this.standardRank = RankLoader.getInstance().getRankStandard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getStdRank() {
        return this.standardRank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getHardRank() {
        return this.hardRank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameMatch getCurrentMatch() {
        return this.currentMatch;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createMatch(final GameMatch match) {
        this.currentMatch = match;
    }

}
