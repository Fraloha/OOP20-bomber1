package bomber1.controllers.setUp;

import bomber1.controllers.ControllerImpl;
import bomber1.model.Difficulty;
import bomber1.model.GameModelImpl;
import bomber1.model.user.Controls;
import bomber1.model.user.Skins;

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
        this.attachModel(new GameModelImpl());
    }

}
