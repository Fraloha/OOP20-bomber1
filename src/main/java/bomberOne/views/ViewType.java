package bomberOne.views;

import java.io.File;

import bomberOne.controllers.Controller;
import bomberOne.controllers.game.GameControllerImpl;
import bomberOne.controllers.setUp.SetUpControllerImpl;
import bomberOne.controllers.home.HomeControllerImpl;


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
    HOME("HomeView", new HomeControllerImpl()), SETUP("SetUpView", new SetUpControllerImpl()),

    /**
     * 
     */
    GAME("GameView", new GameControllerImpl()), RANK("RankView", new GameControllerImpl());

    /**
     * Style files path.
     */
    private static final String DIRECTORY = "viewsStyle" + File.separator;
    private static final String FORMAT = ".fxml";

    private String fileName;
    private Controller controller;

    ViewType(final String string, final Controller controller) {
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
    public Controller getController() {
        return this.controller;
    }

}
