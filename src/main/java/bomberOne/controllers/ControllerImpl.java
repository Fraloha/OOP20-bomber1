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
		// TODO Auto-generated method stub
		
	}

	@Override
	public GameModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
