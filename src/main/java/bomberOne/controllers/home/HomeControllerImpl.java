package bomberOne.controllers.home;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;

public class HomeControllerImpl extends ControllerImpl implements HomeController {

    @Override
    public void init() {
        // TODO Auto-generated method stub
        this.getModel().getUser().setControls(Controls.ARROW);
        this.getModel().getUser().setSkin(Skins.WHITE);
        this.getModel().setDifficulty(Difficulty.STANDARD);
    }

}
