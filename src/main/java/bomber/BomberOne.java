package bomber;

import bomber.model.Difficulty;
import bomber.model.GameModel;
import bomber.model.GameModelImpl;
import bomber.model.common.GameImages;
import bomber.model.user.Controls;
import bomber.model.user.Skins;
import bomber.tools.DirectoryLoader;
import bomber.tools.ResourcesLoader;
import bomber.tools.audio.AudioHandler;
import bomber.tools.audio.GameAudio;
import bomber.views.ViewType;
import bomber.views.ViewsSwitcher;
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
