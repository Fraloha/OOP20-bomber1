package bomberone.controllers.setUp;

import bomberone.controllers.ControllerImpl;
import bomberone.model.user.Controls;
import bomberone.model.user.Difficulty;
import bomberone.model.user.Skins;

public class SetUpControllerImpl extends ControllerImpl implements SetUpController {
	
	@Override
	public void setDifficulty(Difficulty diff) {
		this.getModel().setDifficulty(diff);
	}

	@Override
	public void setUser(String name) {
		this.getModel().getUser().setName(name);
	}

	@Override
	public void setSkin(Skins skin) {
		this.getModel().getUser().setSkin(skin);
		
	}

	@Override
	public void setControls(Controls choice) {
		this.getModel().getUser().setControls(choice);
		
	}

	@Override
	public void init() {
		
	}

}
