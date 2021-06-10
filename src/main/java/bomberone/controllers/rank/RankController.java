package bomberone.controllers.rank;

import java.util.List;

import bomberone.controllers.Controller;
import bomberone.model.user.User;

public interface RankController extends Controller {


    List<User> getStdRank();

    List<User> getHardRank();

}
