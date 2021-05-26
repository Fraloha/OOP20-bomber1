package bomberone.views;

import java.io.IOException;

import bomberone.controllers.Controller;
import bomberone.model.GameModel;
import bomberone.tools.ResourcesLoader;
import bomberone.views.common.GameImages;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This Utility Class load the Views-style and switch the Stage's content.
 *
 */
public final class ViewsSwitcher {

    private boolean firstSwitch = true;

    /* Singleton Pattern */
    private static class LazyHolder {
        private static final ViewsSwitcher SINGLETON = new ViewsSwitcher();
    }

    // Create SINGLETON on the first call.
    public static ViewsSwitcher getInstance() {
        return LazyHolder.SINGLETON;
    }

    private ViewsSwitcher() {

    }

    /**
     * Switch the view displayed on the Stage.
     * 
     * @param stage
     * @param viewType the type of the View to switch
     * @param model    the Instance of the GameModel
     * @throws IOException
     */
    public void switchView(final Stage stage, final ViewType viewType, final GameModel model) {
        View view = this.loadStyle(stage, viewType);
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
    private View loadStyle(final Stage stage, final ViewType viewType) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene newScene;
        if (this.firstSwitch) {
            newScene = new Scene(root);
            this.firstSwitch = false;
        } else {
            /* Do not resize the stage */
            newScene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
        }
        stage.setScene(newScene);
        View view = loader.getController();
        stage.getScene().getStylesheets().clear();
        if (viewType.equals(ViewType.RANK)) {
            stage.getScene().getStylesheets().add(ResourcesLoader.getInstance().getRankStyleSheets());
        }
        stage.setMinHeight(((AnchorPane) stage.getScene().getRoot()).getMinHeight());
        stage.setMinWidth(((AnchorPane) stage.getScene().getRoot()).getMinWidth());
        if (root != null) {
            root.scaleXProperty().bind(Bindings.min(stage.widthProperty().divide(stage.minWidthProperty()),
                    stage.heightProperty().divide(stage.minHeightProperty())));

            root.scaleYProperty().bind(root.scaleXProperty());
        }
        view.setStage(stage);
        stage.setScene(newScene);
        return view;
    }

}
