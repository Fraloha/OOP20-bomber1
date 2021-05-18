package bomberone.views;

import java.io.IOException;

import bomberone.controllers.Controller;
import bomberone.model.GameModel;
import bomberone.views.common.GameImages;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This Utility Class load the Views-style and switch the Stage's content.
 *
 */
public final class ViewsSwitcher {

    private ViewsSwitcher() {

    }

    /**
     * Switch the view displayed on the Stage.
     * 
     * @param stage
     * @param viewType the type of the View to switch
     * @param model    the Istance of the GameModel
     * @throws IOException
     */
    public static void switchView(final Stage stage, final ViewType viewType, final GameModel model) {
        View view = loadStyle(stage, viewType);
        Controller controller = viewType.getController();
        controller.attachView(view);
        controller.attachModel(model);
        view.attachController(controller);
        view.setStage(stage);
        view.init();
        stage.getIcons().add(GameImages.ICON.getImage());
        stage.setTitle("BomberOne");
        stage.show();
    }

    /**
     * Load Style from FXML file and creates the View linked to it.
     * 
     * @param stage    to be changed
     * @param viewType of new View
     * @return The View
     */
    private static View loadStyle(final Stage stage, final ViewType viewType) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        View view = loader.getController();
        view.setStage(stage);
        stage.setScene(newScene);
        return view;
    }

}
