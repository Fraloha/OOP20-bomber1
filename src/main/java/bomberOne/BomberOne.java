package bomberOne;

import bomberOne.model.GameModelImpl;
import bomberOne.tools.DirectoryLoader;
import bomberOne.tools.ImagesLoader;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

public class BomberOne extends Application{

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false);
		ImagesLoader.start();
		DirectoryLoader.start();
		ViewsSwitcher.switchView(primaryStage, ViewType.GAME, new GameModelImpl());
	}

}
