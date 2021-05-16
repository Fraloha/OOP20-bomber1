package bomberone.model;

import java.util.List;

import bomberone.model.match.GameMatch;
import bomberone.model.user.User;

/**
 * The domain of the Application.
 *
 */
public interface GameModel {

    /**
     * Return the Rank of Hard-Level Players.
     * 
     * @return the List of User(the rank)
     */
    List<User> getStdRank();

    /**
     * Return the Rank of Standard-Level Players.
     * 
     * @return the List of User(the rank)
     */
    List<User> getHardRank();

    /**
     * Return the current Match.
     * @return the current GameMatch
     */
    GameMatch getCurrentMatch();

    /**
     * Create a new GameMatch().
     * @param match to Create
     */
    void createMatch(GameMatch match);
}
