package bomberOne.views;

import java.io.IOException;

import bomberOne.controllers.Controller;
import bomberOne.controllers.game.GameControllerImpl;
import bomberOne.controllers.setUp.SetUpControllerImpl;
import bomberOne.model.GameModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewsSwitcher {

	
	
	public static void init() {
		
	}
	
	/**
	 * Switch the view displayed on the Stage
	 * @param stage
	 * @param viewType the type of the View to switch
	 * @param model the Istance of the GameModel
	 * @throws IOException 
	 */
	public static void switchView(Stage stage, ViewType viewType, GameModel model) {
		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		View view = loader.getController();
		stage.setScene(new Scene(root));
		Controller controller = ViewsSwitcher.getController(viewType);
		controller.attachView(view);
        view.attachController(controller);
        view.init();
        stage.show();
	}
	
	/**
	 * Create a specify Controller for the View in Input
	 * @param type the type of the View
	 * @return the Controller to attach to the view
	 */
	private static Controller getController(ViewType type) {
	
		Controller controller = null;
		
		if(type.equals(ViewType.GAME)) {
			controller = new GameControllerImpl();
		}
		
		if(type.equals(ViewType.SETUP)) {
			controller = new SetUpControllerImpl();
		}
		return controller;
	}
	
	
}
