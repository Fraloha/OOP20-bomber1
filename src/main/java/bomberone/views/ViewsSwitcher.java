package bomberone.views;

import java.io.IOException;
import java.util.Optional;

import bomberone.controllers.Controller;
import bomberone.model.GameModel;
import bomberone.views.basic.View;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class ViewsSwitcher {

    private ViewsSwitcher() {

    }

//    /**
//     * Switch the view displayed on the Stage.
//     * 
//     * @param stage
//     * @param viewType the type of the View to switch
//     * @param model    the Istance of the GameModel
//     * @throws IOException
//     */
//    public static void switchView(final Stage stage, final ViewType viewType, final GameModel model) {
//        if (viewType.getController().equals(Optional.empty())) {
//            switchWithoutController(stage, viewType);
//        } else {
//            switchWithController(stage, viewType, model);
//        }
////        stage.show();
//    }

    public static void switchWithController(final Stage stage, final ViewType viewType, final GameModel model) {
        View view = loadStyle(stage, viewType);
        Controller controller = viewType.getController().get();
        controller.attachView(view);
        controller.attachModel(model);
        view.attachController(controller);
        view.setStage(stage);
        view.init();
        stage.show();
    }

    public static void switchWithoutController(final Stage stage, final ViewType viewType) {
        View view = loadStyle(stage, viewType);
        view.init();
        stage.show();
    }

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
