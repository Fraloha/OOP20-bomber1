package bomberone;

import bomberone.model.Difficulty;
import bomberone.model.GameModel;
import bomberone.model.GameModelImpl;
import bomberone.model.common.GameImages;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.tools.DirectoryLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.AudioHandler;
import bomberone.tools.audio.GameAudio;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
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
        primaryStage.getIcons().add(SwingFXUtils.toFXImage(GameImages.ICON.getImage(), null));
        // UNCOMMENT TO TEST
//
//        GameModel test = new GameModelImpl();
//        test.getUser().setControls(Controls.ARROW);
//        test.getUser().setSkin(Skins.WHITE);
//        test.setDifficulty(Difficulty.STANDARD);
//      test.init();
        AudioHandler.start(GameAudio.HOME);
        ViewsSwitcher.switchView(primaryStage, ViewType.HOME, new GameModelImpl());
    }

}
