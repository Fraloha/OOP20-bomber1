package bomberone.views;

import bomberone.controllers.Controller;
import javafx.stage.Stage;

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
	
	/**
	 * Attach a stage to the View
	 * @param stage
	 */
	public void setStage(Stage stage);
	
	/**
	 * Return stage attached to the View
	 * @param stage
	 */
	public Stage getStage();
	
}
