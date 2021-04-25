package bomberOne;

import bomberOne.model.GameModel;
import bomberOne.model.GameModelImpl;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;
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

        // UNCOMMENT TO TEST
//
        GameModel test = new GameModelImpl();
        test.getUser().setControls(Controls.ARROW);
        test.getUser().setSkin(Skins.RED);
        test.setDifficulty(Difficulty.STANDARD);
        test.init();
        ViewsSwitcher.switchView(primaryStage, ViewType.GAME, test);
    }

}
