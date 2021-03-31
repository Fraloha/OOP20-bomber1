package bomberOne.controllers;

import bomberOne.model.GameModel;
import bomberOne.views.View;

public interface Controller {

	/**
	 * This method attach the view to the Controller.
	 * @param view the View to attach
	 */
	public void attachView(View view);
	
	/**
	 * This method return the View attached to the Controller.
	 * @return View, the view attached
	 */
	public View getView();
	
	/**
	 * This method attach the GameModel to the Controller.
	 * @param model the Model to attach
	 */
	public void attachModel(GameModel model);
	
	/**
	 * This method return the GameModel attached to the Controller.
	 * @return GameModel, the Model attached
	 */
	public GameModel getModel();
	
	/**
	 * This method Initialize the Controller
	 */
	public void init();
}
