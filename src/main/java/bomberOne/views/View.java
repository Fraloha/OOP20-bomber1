package bomberOne.views;

import bomberOne.controllers.Controller;

public interface View {

	/**
	 * Attach a MVC controller to the current View
	 * @param controller to attach
	 */
	public void attachController(Controller controller);
	
	/**
	 * Initialize the View
	 */
	public void init();
	
}
