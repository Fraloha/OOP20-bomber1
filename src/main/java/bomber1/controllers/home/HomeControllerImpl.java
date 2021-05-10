package bomber1.controllers.home;

import bomber1.controllers.ControllerImpl;
import bomber1.model.Difficulty;
import bomber1.model.user.Controls;
import bomber1.model.user.Skins;

public class HomeControllerImpl extends ControllerImpl implements HomeController {

    @Override
    public void init() {
        // TODO Auto-generated method stub
        this.getModel().getUser().setControls(Controls.ARROW);
        this.getModel().getUser().setSkin(Skins.WHITE);
        this.getModel().setDifficulty(Difficulty.STANDARD);
    }

}
