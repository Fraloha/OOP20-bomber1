package bomberone.controllers.home;

import bomberone.controllers.ControllerImpl;
import bomberone.model.Difficulty;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;

public class HomeControllerImpl extends ControllerImpl implements HomeController {

    @Override
    public void init() {
        // TODO Auto-generated method stub
        this.getModel().getUser().setControls(Controls.ARROW);
        this.getModel().getUser().setSkin(Skins.WHITE);
        this.getModel().setDifficulty(Difficulty.STANDARD);
    }

}
