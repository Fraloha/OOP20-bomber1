package bomberOne.views;

import bomberOne.controllers.Controller;

public abstract class ViewImpl implements View {

	private Controller controller;
	
	@Override
	public void attachController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public Controller getController() {
		return this.controller;
	}

	@Override
	public abstract void init();

}
