package bomberone.controllers.setUp;

import bomberone.controllers.ControllerImpl;
import bomberone.model.Difficulty;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;

public final class SetUpControllerImpl extends ControllerImpl implements SetUpController {

    private Difficulty difficulty;
    private String name;
    private Skins skin;
    private Controls controls;

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
        this.getModel().setDifficulty(this.difficulty);
        this.getModel().setUser(user);
    }

    @Override
    public void init() {

    }

}
