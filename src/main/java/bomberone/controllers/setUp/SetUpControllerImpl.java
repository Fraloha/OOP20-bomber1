package bomberone.controllers.setUp;

import bomberone.controllers.ControllerImpl;
import bomberone.model.Difficulty;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.model.user.User;
import bomberone.model.user.UserImpl;

public final class SetUpControllerImpl extends ControllerImpl implements SetUpController {

    private User user = new UserImpl();

    @Override
    public void setDifficulty(final Difficulty diff) {
        this.getModel().setDifficulty(diff);
    }

    @Override
    public void setUser(final String name) {
        this.user.setName(name);
        // this.getModel().getUser().setName(name);
    }

    @Override
    public void setSkin(final Skins skin) {
        this.user.setSkin(skin);
        // this.getModel().getUser().setSkin(skin);
    }

    @Override
    public void setControls(final Controls choice) {
        // this.getModel().getUser().setControls(choice);
        this.user.setControls(choice);
    }

    public void attachUser() {
        this.getModel().setUser(user);
    }

    @Override
    public void init() {

    }

}
