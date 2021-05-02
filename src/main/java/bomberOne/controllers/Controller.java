package bomberOne.controllers;

import bomberOne.model.GameModel;
import bomberOne.views.basic.View;

/**
 * This represent a generic Controller, every type of Controller extends it.
 *
 */
public interface Controller {

    /**
     * This method attach the view to the Controller.
     * 
     * @param view the View to attach
     */
    void attachView(View view);

    /**
     * This method return the View attached to the Controller.
     * 
     * @return View, the view attached
     */
    View getView();

    /**
     * This method attach the GameModel to the Controller.
     * 
     * @param model the Model to attach
     */
    void attachModel(GameModel model);

    /**
     * This method return the GameModel attached to the Controller.
     * 
     * @return GameModel, the Model attached
     */
    GameModel getModel();

    /**
     * This method Initialize the Controller.
     */
    void init();
}
