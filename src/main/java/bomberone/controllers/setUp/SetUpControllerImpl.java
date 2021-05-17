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

    @Override
    public void setDifficulty(final Difficulty diff) {
        this.difficulty = diff;
    }

    @Override
    public void setUser(final String name) {
        this.name = name;
    }

    @Override
    public void setSkin(final Skins skin) {
        this.skin = skin;
    }

    @Override
    public void setControls(final Controls choice) {
        this.controls = choice;
    }

    public void buildUser() {
        User user = new UserImpl();
        user.setControls(this.controls);
        user.setName(this.name);
        user.setSkin(this.skin);
        this.match = new GameMatchImpl();
        this.match.setDifficulty(this.difficulty);
        this.match.setUser(user);
        this.getModel().createMatch(match);
    }

    @Override
    public void init() {

    }

}
