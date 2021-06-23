package bomberone.controllers.rank;

import java.util.List;
import bomberone.controllers.Controller;
import bomberone.model.match.Difficulty;
import bomberone.model.user.User;

/**
 * This interface represent the controller of the rank view.
 */
public interface RankController extends Controller {

    /**
     * This method gets the users easy mode rank.
     * 
     * @return A List<User> that contains all the easy mode players.
     */
    List<User> getStdRank();

    /**
     * This method gets the users hard mode rank.
     * 
     * @return A List<User> that contains all the hard mode players.
     */
    List<User> getHardRank();

    /**
     * This method gets the difficulty of the current game match.
     * 
     * @return An Difficulty enum value.
     */
    Difficulty getMatchDifficulty();
}
