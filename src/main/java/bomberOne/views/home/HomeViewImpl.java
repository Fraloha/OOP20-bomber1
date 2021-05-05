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
        ViewsSwitcher.switchView(this.getStage(), ViewType.SETUP, this.getController().getModel());
    }

    @FXML
    public void switchToCredits() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.CREDITS, this.getController().getModel());
    }

    @FXML
    public void switchToRank() {
        //ViewsSwitcher.switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
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
