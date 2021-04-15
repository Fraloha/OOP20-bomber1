package bomberone.controllers;

import bomberone.model.GameModel;
import bomberone.views.View;

public abstract class ControllerImpl implements Controller{

	private GameModel model;
	private View view;
	
	@Override
	public void attachView(View view) {
		this.view = view;
	}

	@Override
	public View getView() {
		return this.view;
	}

	@Override
	public void attachModel(GameModel model) {
		this.model = model;
	}

	@Override
	public GameModel getModel() {
		return this.model;
	}

	@Override
	public abstract void init();

}
