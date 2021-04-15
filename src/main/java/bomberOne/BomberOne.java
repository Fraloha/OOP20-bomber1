package bomberone;

import bomberone.model.GameModelImpl;
import bomberone.tools.DirectoryLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

public class BomberOne extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    /**
     * 
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        ResourcesLoader.start();
        DirectoryLoader.start();
        ViewsSwitcher.switchView(primaryStage, ViewType.GAME, new GameModelImpl());
    }

}
