package bomberone.views.basic;

import bomberone.controllers.Controller;
import javafx.stage.Stage;

public abstract class ViewImpl implements View {

    private Controller controller;
    private Stage stage;

    /**
     * {@inheritDoc}
     */
    @Override
    public void attachController(final Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStage(final Stage stage) {
        this.stage = stage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stage getStage() {
        return this.stage;
    }

    @Override
    public abstract void init();

}
