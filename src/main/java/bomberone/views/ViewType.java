package bomberone.views;



import bomberone.controllers.Controller;
import bomberone.controllers.home.HomeControllerImpl;
import bomberone.controllers.game.GameControllerImpl;
import bomberone.controllers.setUp.SetUpControllerImpl;
import bomberone.controllers.rank.RankControllerImpl;

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
    CREDITS("CreditsView", new HomeControllerImpl()), RULES("RulesView", new HomeControllerImpl()),

    /**
     * 
     */
    GAME("GameView", new GameControllerImpl()), RANK("RankView", new RankControllerImpl());

    /**
     * Style files path.
     */
    private static final String DIRECTORY = "viewsStyle/";
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
