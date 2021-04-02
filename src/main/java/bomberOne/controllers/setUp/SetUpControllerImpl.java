package bomberOne.controllers.setUp;

import bomberOne.controllers.ControllerImpl;
import bomberOne.model.Commands;
import bomberOne.model.Difficulty;
import bomberOne.model.Skins;

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
	public void setControls(Commands choice) {
		// TODO QUANDO GUS SVILUPPA I COMANDI
		
	}

	@Override
	public void init() {
		
	}

}
