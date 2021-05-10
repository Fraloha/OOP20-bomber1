package bomber1;

import bomber1.model.Difficulty;
import bomber1.model.GameModel;
import bomber1.model.GameModelImpl;
import bomber1.model.common.GameImages;
import bomber1.model.user.Controls;
import bomber1.model.user.Skins;
import bomber1.tools.DirectoryLoader;
import bomber1.tools.ResourcesLoader;
import bomber1.tools.audio.AudioHandler;
import bomber1.tools.audio.GameAudio;
import bomber1.views.ViewType;
import bomber1.views.ViewsSwitcher;
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
