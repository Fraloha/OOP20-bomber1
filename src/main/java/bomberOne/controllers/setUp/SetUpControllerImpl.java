package bomberOne.controllers.setUp;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;

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
