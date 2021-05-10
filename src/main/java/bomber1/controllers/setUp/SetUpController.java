package bomber1.controllers.setUp;

import bomber1.controllers.Controller;
import bomber1.model.Difficulty;
import bomber1.model.user.Controls;
import bomber1.model.user.Skins;

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
