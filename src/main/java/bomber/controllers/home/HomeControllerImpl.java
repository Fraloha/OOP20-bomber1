package bomber.controllers.home;

import bomber.controllers.ControllerImpl;
import bomber.model.Difficulty;
import bomber.model.user.Controls;
import bomber.model.user.Skins;

public class HomeControllerImpl extends ControllerImpl implements HomeController {

    @Override
    public void init() {
        // TODO Auto-generated method stub
        this.getModel().getUser().setControls(Controls.ARROW);
        this.getModel().getUser().setSkin(Skins.WHITE);
        this.getModel().setDifficulty(Difficulty.STANDARD);
    }

}
