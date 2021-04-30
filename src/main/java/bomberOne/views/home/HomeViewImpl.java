package bomberOne.views.home;

import bomberOne.controllers.game.GameController;
import bomberOne.tools.img.GameImages;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import bomberOne.views.game.movement.ControlsMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class HomeViewImpl extends ViewImpl implements HomeView {

    @FXML
    private Canvas canvasBackground;

    @FXML
    private Canvas canvasForegrounds;

    @FXML
    private ImageView buttonPlay;

    @FXML
    private ImageView buttonRank;

    @FXML
    private ImageView buttonTutorial;

    private GraphicsContext gCForeground;
    private GraphicsContext gCBackground;
    private ControlsMap controlsMap;

    @Override
    public void drawHomeView() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        // TODO Auto-generated method stub

    }

    @FXML
    public void switchToSetUp() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.GAME, this.getController().getModel());
    }

    @Override
    public void switchToCredits() {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchToRank() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {

    }

    @FXML
    public void setPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null));
    }

    @FXML
    public void unsetPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
    }

    @FXML
    public void setRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_SET.getImage(), null));
    }

    @FXML
    public void unsetRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null));
    }

    @FXML
    public void setTutorial() {
        this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_SET.getImage(), null));
    }

    @FXML
    public void unsetTutorial() {
        this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_UNSET.getImage(), null));
    }
}
