package bomberone;

import bomberone.tools.DirectoryLoader;
import bomberone.tools.RankLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.SoundsHandler;
import bomberone.tools.audio.GameSounds;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.game.img.GameImages;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
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
        primaryStage.getIcons().add(SwingFXUtils.toFXImage(GameImages.ICON.getImage(), null));
        primaryStage.setTitle("BomberOne");

        SoundsHandler.start(GameSounds.HOME);
        ViewsSwitcher.switchView(primaryStage, ViewType.HOME);
    }

}
