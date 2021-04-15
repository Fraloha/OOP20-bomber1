package bomberone.views;

import java.io.File;

import bomberone.controllers.*;
import bomberone.controllers.game.GameControllerImpl;
import bomberone.controllers.setUp.*;;

/**
 * Enum for the Views, each one has her StyleFile and her specific Controller Type
 * @author Luigi
 *
 */
public enum ViewType {

	/**
	 * TODOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	 */
	HOME("HomeView", new GameControllerImpl()),
	SETUP("SetUpView", new SetUpControllerImpl()),
	GAME("GameView", new GameControllerImpl()),
	RANK("RankView", new GameControllerImpl());
	
	/**
	 * Style files path
	 */
	private static final String DIRECTORY = "viewsStyle" + File.separator;
	private static final String FORMAT = ".fxml";
	
	private String fileName;
	private Controller controller;


	ViewType(String string, Controller controller) {
		this.fileName = string;
		this.controller = controller;
	}

	/**
	 * Get the path of FXML Style file
	 * @return
	 */
	public String getPath() {
		return DIRECTORY + this.fileName + FORMAT;
	}
	
	/**
	 * Return the specific controller linked to the specific view
	 * @return
	 */
	public Controller getController() {
		return this.controller;
	}
	
}
