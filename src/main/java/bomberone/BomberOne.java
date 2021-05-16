package bomberone;

import bomberone.model.GameModelImpl;
import bomberone.tools.DirectoryLoader;
import bomberone.tools.RankLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.game.img.GameImages;
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
        RankLoader.readUsers();
        primaryStage.getIcons().add(GameImages.ICON.getImage());
        primaryStage.setTitle("BomberOne");
        ViewsSwitcher.switchView(primaryStage, ViewType.HOME, new GameModelImpl());
    }

}
