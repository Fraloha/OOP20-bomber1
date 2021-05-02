package bomberOne.views.home;

import bomberOne.controllers.game.GameController;
import bomberOne.tools.img.GameImages;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import bomberOne.views.game.movement.ControlsMap;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class HomeViewImpl extends ViewImpl implements HomeView {

    @FXML
    private Canvas homeCanvas;

    @FXML
    private ImageView boxLogo;

    @FXML
    private ImageView buttonPlay;

    @FXML
    private ImageView buttonRank;

    @FXML
    private ImageView buttonTutorial;

    private GraphicsContext graphicContext;
    private ControlsMap controlsMap;

    @Override
    public void init() {
        this.graphicContext = this.homeCanvas.getGraphicsContext2D();
        this.drawHome();
        this.getController().init();
        this.controlsMap = new ControlsMap(this.getController().getModel().getUser().getControls(),
                ((GameController) this.getController()).getCommandListener().getPlayerBehaviour());
    }

    @Override
    public void drawHome() {
        this.boxLogo.setImage(SwingFXUtils.toFXImage(GameImages.HOME_LOGO.getImage(), null));
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null));
        this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_UNSET.getImage(), null));
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

    @FXML
    public void setPlay() {
        Platform.runLater(() -> {
            this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null)); 
        });
    }

    @FXML
    public void unsetPlay() {
        Platform.runLater(() -> {
            this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null)); 
        });
    }

    @FXML
    public void setRank() {
        Platform.runLater(() -> {
            this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_SET.getImage(), null)); 
        });
    }

    @FXML
    public void unsetRank() {
        Platform.runLater(() -> {
            this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null)); 
        });
    }

    @FXML
    public void setTutorial() {
        Platform.runLater(() -> {
            this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_SET.getImage(), null)); 
        });
    }

    @FXML
    public void unsetTutorial() {
        Platform.runLater(() -> {
            this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_UNSET.getImage(), null)); 
        });
    }
}
