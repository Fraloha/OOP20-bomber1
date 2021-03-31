package bomberOne.controllers;

import bomberOne.model.GameModel;
import bomberOne.views.View;

public class ControllerImpl implements Controller{

	GameModel model;
	View view;
	
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
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
