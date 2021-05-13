package bomberone.controllers.setUp;

import bomberone.controllers.ControllerImpl;
import bomberone.model.Difficulty;
import bomberone.model.GameModelImpl;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;

public final class SetUpControllerImpl extends ControllerImpl implements SetUpController {

    @Override
    public void setDifficulty(final Difficulty diff) {
        this.getModel().setDifficulty(diff);
    }

    @Override
    public void setUser(final String name) {
        this.getModel().getUser().setName(name);
    }

    @Override
    public void setSkin(final Skins skin) {
        this.getModel().getUser().setSkin(skin);

    }

    @Override
    public void setControls(final Controls choice) {
        this.getModel().getUser().setControls(choice);

    }

    @Override
    public void init() {

    }

}
