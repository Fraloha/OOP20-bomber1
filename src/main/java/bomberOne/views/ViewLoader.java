package bomberOne.views;

import java.io.IOException;

import bomberOne.model.GameModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewLoader {

	private static final String DIRECTORY = "viewStyle/";
	private static final String FORMAT = ".fxml";
	
	public static void init() {
		ViewType.GAME.setPath(DIRECTORY + "gameView" + FORMAT); 
		ViewType.SETUP.setPath(DIRECTORY + "setUpView" + FORMAT); 
	}
	
	public static void switchView(Stage stage, ViewType viewType, GameModel model) {
		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
		Parent root = null;
		try { 
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		View fxController = loader.getController();
		stage.setScene(new Scene(root));
		controller.setView(view);

        view.setController(controller);
        view.setStage(stage);
        view.init();
        stage.show();
	}
	
	
}
