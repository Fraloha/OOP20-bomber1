package bomberOne.views;

import bomberOne.controllers.Controller;

public interface View {

	/**
	 * Attach a MVC controller to the current View
	 * @param controller to attach
	 */
	public void attachController(Controller controller);
	
	/**
	 * Get the Controller attached to the View
	 * @return
	 */
	public Controller getController();
	
	/**
	 * Initialize the View
	 */
	public abstract void init();
	
}
