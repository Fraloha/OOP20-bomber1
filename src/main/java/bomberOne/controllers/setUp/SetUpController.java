package bomberOne.controllers.setUp;

import bomberOne.controllers.Controller;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;

/**
 * This Controller sets some settings of the GameModel by the choice of the User
 * in the SetUpView.
 * 
 *
 */
public interface SetUpController extends Controller {

    /**
     * Set the Difficulty of the GameModel attached on it.
     * 
     * @param diff
     */
    void setDifficulty(Difficulty diff);

    /**
     * Set the User on the GameModel.
     * 
     * @param name
     */
    void setUser(String name);

    /**
     * Set the skin of the Bomberman.
     * 
     * @param skin
     */
    void setSkin(Skins skin);

    /**
     * Set the Controls that are used by the Player to manage the Bomberman.
     * 
     * @param choice
     */
    void setControls(Controls choice);
}
