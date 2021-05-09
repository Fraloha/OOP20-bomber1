package bomberOne;

import bomberOne.model.Difficulty;
import bomberOne.model.GameModel;
import bomberOne.model.GameModelImpl;
import bomberOne.model.common.GameImages;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Skins;
import bomberOne.tools.DirectoryLoader;
import bomberOne.tools.ResourcesLoader;
import bomberOne.tools.audio.AudioHandler;
import bomberOne.tools.audio.GameAudio;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
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
        
        ViewsSwitcher.switchView(primaryStage, ViewType.HOME, new GameModelImpl());
    }

}
