package bomberOne;

import bomberOne.model.GameModelImpl;
import bomberOne.tools.DirectoryLoader;
import bomberOne.tools.ResourcesLoader;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

public final class BomberOne extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);
        ResourcesLoader.start();
        DirectoryLoader.start();
        ViewsSwitcher.switchView(primaryStage, ViewType.GAME, new GameModelImpl());
    }

}
