package bomberone;

import bomberone.model.GameModelImpl;
import bomberone.tools.DirectoryLoader;
import bomberone.tools.RankLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import javafx.application.Application;
import javafx.stage.Stage;

public final class BomberOne extends Application {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        ResourcesLoader.getInstance().start();
        DirectoryLoader.getInstance().start();
        RankLoader.getInstance().readUsers();
        ViewsSwitcher.getInstance().switchView(primaryStage, ViewType.HOME, new GameModelImpl());
    }

}
