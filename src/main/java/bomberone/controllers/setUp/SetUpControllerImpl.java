package bomberone.controllers.setUp;

import bomberone.controllers.ControllerImpl;
import bomberone.model.match.Difficulty;
import bomberone.model.match.GameMatch;
import bomberone.model.match.GameMatchImpl;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;

public final class SetUpControllerImpl extends ControllerImpl implements SetUpController {

    private Difficulty difficulty;
    private String name;
    private Skins skin;
    private Controls controls;
    private GameMatch match;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDifficulty(final Difficulty diff) {
        this.difficulty = diff;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUser(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSkin(final Skins skin) {
        this.skin = skin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setControls(final Controls choice) {
        this.controls = choice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buildUser() {
        User user = new UserImpl.Builder(this.name)
                            .skin(this.skin)
                            .controls(this.controls)
                            .build();
        this.match = new GameMatchImpl();
        this.match.setDifficulty(this.difficulty);
        this.match.setUser(user);
        this.getModel().createMatch(this.match);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {

    }

}
