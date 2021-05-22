package bomberone.model.user;

import java.io.Serializable;

/**
 * The user of the Game, to be saved on the rank.
 * 
 *
 */

public interface User extends Serializable {

    /**
     * Sets the name of the User.
     * 
     * @param name
     */
    void setName(String name);

    /**
     * Sets the score of the user.
     * 
     * @param score
     */
    void setScore(int score);

    /**
     * Sets the skin of the user.
     * 
     * @param skin The skin to attach to the User
     */
    void setSkin(Skins skin);

    /**
     * 
     * @return the name of the User
     */
    String getName();

    /**
     * 
     * @return the score of the User
     */
    int getScore();

    /**
     * 
     * @return the skin choised by the User
     */
    Skins getSkin();

    /**
     * 
     * Set the controls of the User.
     * 
     * @param controls
     */
    void setControls(Controls controls);

    /**
     * 
     * @return the controls of the User
     */
    Controls getControls();
}
