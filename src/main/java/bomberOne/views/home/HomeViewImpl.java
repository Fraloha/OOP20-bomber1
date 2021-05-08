package bomberOne.views.home;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import bomberOne.tools.audio.GameAudio;
import bomberOne.tools.audio.SoundsHandler;
import bomberOne.model.common.GameImages;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import bomberOne.views.game.movement.ControlsMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
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
    private ImageView buttonRules;

    // private GraphicsContext graphicContext;
    private ControlsMap controlsMap;

    @Override
    public void init() {
        // this.graphicContext = this.homeCanvas.getGraphicsContext2D();
        this.drawHome();
        this.getController().init();
    }

    @Override
    public void drawHome() {
        SoundsHandler.start(GameAudio.HOME);
        this.boxLogo.setImage(SwingFXUtils.toFXImage(GameImages.HOME_LOGO.getImage(), null));
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null));
        this.buttonRules.setImage(SwingFXUtils.toFXImage(GameImages.RULES_UNSET.getImage(), null));
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
        // ViewsSwitcher.switchView(this.getStage(), ViewType.RANK,
        // this.getController().getModel());
    }

    @FXML
    public void switchToRules() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.RULES, this.getController().getModel());
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
    public void setRules() {
        this.buttonRules.setImage(SwingFXUtils.toFXImage(GameImages.RULES_SET.getImage(), null));
    }

    @FXML
    public void unsetRules() {
        this.buttonRules.setImage(SwingFXUtils.toFXImage(GameImages.RULES_UNSET.getImage(), null));
    }
}
