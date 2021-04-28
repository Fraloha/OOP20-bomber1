package bomberOne.views.basic;

import bomberOne.controllers.Controller;
import javafx.stage.Stage;

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
