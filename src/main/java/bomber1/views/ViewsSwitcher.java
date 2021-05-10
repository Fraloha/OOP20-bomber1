package bomber1.views;

import java.io.IOException;

import bomber1.controllers.Controller;
import bomber1.model.GameModel;
import bomber1.views.basic.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        View view = loader.getController();
        stage.setScene(new Scene(root));
        Controller controller = viewType.getController();
        controller.attachView(view);
        controller.attachModel(model);
        view.attachController(controller);
        view.setStage(stage);
        view.init();
        stage.show();
    }


}
