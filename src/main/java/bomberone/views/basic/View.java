package bomberone.views.basic;

import bomberone.controllers.Controller;
import javafx.stage.Stage;

/**
 * Basic View.
 *
 */
public interface View {

    /**
     * Attach a MVC controller to the current View.
     * 
     * @param controller to attach
     */
    void attachController(Controller controller);

    /**
     * Get the Controller attached to the View.
     * 
     * @return the Controller
     */
    Controller getController();

    /**
     * Initialize the View.
     */
    void init();

    /**
     * Attach a stage to the View.
     * 
     * @param stage
     */
    void setStage(Stage stage);

    /**
     * Return stage attached to the View.
     * 
     * @return the Stage
     */
    Stage getStage();

}
