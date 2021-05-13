package bomberone.views;


import java.util.Optional;

import bomberone.controllers.Controller;
import bomberone.controllers.game.GameControllerImpl;
import bomberone.controllers.setUp.SetUpControllerImpl;

/**
 * Enum for the Views, each one has her StyleFile and her specific Controller.
 * Type
 * 
 *
 */
public enum ViewType {

    /**
     * TODOOOOOOOOOOOOOOOOOOOOOOOOOOOO.
     */
    HOME("HomeView", Optional.empty()), SETUP("SetUpView", Optional.of(new SetUpControllerImpl())),

    /**
     * 
     */
    CREDITS("CreditsView", Optional.empty()), RULES("RulesView", Optional.empty()),

    /**
     * 
     */
    GAME("GameView", Optional.of(new GameControllerImpl())), RANK("RankView", Optional.empty());

    /**
     * Style files path.
     */
    private static final String DIRECTORY = "viewsStyle/";
    private static final String FORMAT = ".fxml";

    private String fileName;
    private Optional<Controller> controller;

    ViewType(final String string, final Optional<Controller> controller) {
        this.fileName = string;
        this.controller = controller;
    }

    /**
     * Get the path of FXML Style file.
     * 
     * @return The Path
     */
    public String getPath() {
        return DIRECTORY + this.fileName + FORMAT;
    }

    /**
     * Return the specific controller linked to the specific view.
     * 
     * @return the Controller
     */
    public Optional<Controller> getController() {
        return this.controller;
    }

}
