package bomberone.views.home;


import bomberone.tools.audio.SoundsHandler;
import bomberone.model.GameModelImpl;
import bomberone.tools.audio.GameSounds;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.GameImages;
import bomberone.views.game.movement.ControlsMap;
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
//        this.getController().init();
    }

    @Override
    public void drawHome() {
        this.boxLogo.setImage(GameImages.HOME_LOGO.getImage());
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
        this.buttonRank.setImage(GameImages.RANK_UNSET.getImage());
        this.buttonRules.setImage(GameImages.RULES_UNSET.getImage());
    }

    @FXML
    public void switchToSetUp() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.SETUP, new GameModelImpl());

    }

    @FXML
    public void switchToCredits() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.CREDITS);
    }

    @FXML
    public void switchToRank() {
//        ViewsSwitcher.switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
        ViewsSwitcher.switchView(this.getStage(), ViewType.RANK);
    }

    @FXML
    public void switchToRules() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.RULES);
    }

    @FXML
    public void setPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_SET.getImage());
    }

    @FXML
    public void unsetPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
    }

    @FXML
    public void setRank() {
        this.buttonRank.setImage(GameImages.RANK_SET.getImage());
    }

    @FXML
    public void unsetRank() {
        this.buttonRank.setImage(GameImages.RANK_UNSET.getImage());
    }

    @FXML
    public void setRules() {
        this.buttonRules.setImage(GameImages.RULES_SET.getImage());
    }

    @FXML
    public void unsetRules() {
        this.buttonRules.setImage(GameImages.RULES_UNSET.getImage());
    }
}
