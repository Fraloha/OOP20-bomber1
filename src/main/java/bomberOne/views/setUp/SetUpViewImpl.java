package bomberOne.views.setUp;

import bomberOne.controllers.setUp.SetUpController;
import bomberOne.controllers.setUp.SetUpControllerImpl;
import bomberOne.model.user.Controls;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;
import bomberOne.tools.img.GameImages;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SetUpViewImpl extends ViewImpl implements SetUpView {

    @FXML
    private ImageView boxPlayer;

    @FXML
    private ImageView buttonSX;

    @FXML
    private ImageView buttonDX;

    @FXML
    private ImageView buttonNormal;

    @FXML
    private ImageView buttonHard;

    @FXML
    private ImageView buttonWASD;

    @FXML
    private ImageView buttonArrows;

    @FXML
    private ImageView buttonPlay;

    @FXML
    private ImageView buttonHome;

    @FXML
    private TextField nickname;

    @Override
    public final void init() {
        this.drawSetUp();
        this.getController().init();
    }

    @Override
    public final void drawSetUp() {
        this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P1.getImage(), null));
        this.buttonSX.setImage(SwingFXUtils.toFXImage(GameImages.SX.getImage(), null));
        this.buttonDX.setImage(SwingFXUtils.toFXImage(GameImages.DX.getImage(), null));
        this.buttonNormal.setImage(SwingFXUtils.toFXImage(GameImages.NORMAL_SET.getImage(), null));
        this.buttonHard.setImage(SwingFXUtils.toFXImage(GameImages.HARD_UNSET.getImage(), null));
        this.buttonWASD.setImage(SwingFXUtils.toFXImage(GameImages.WASD_SET.getImage(), null));
        this.buttonArrows.setImage(SwingFXUtils.toFXImage(GameImages.ARROWS_UNSET.getImage(), null));
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
        this.buttonHome.setImage(SwingFXUtils.toFXImage(GameImages.QUIT_GAME.getImage(), null));
    }

    @Override
    public final void switchToGame() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.GAME, this.getController().getModel());
    }

    @Override
    public final void switchToHome() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }

    @FXML
    public final void setNormal() {
        this.buttonNormal.setImage(SwingFXUtils.toFXImage(GameImages.NORMAL_SET.getImage(), null));
        this.buttonHard.setImage(SwingFXUtils.toFXImage(GameImages.HARD_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setDifficulty(Difficulty.STANDARD);
    }

    @FXML
    public final void setHard() {
        this.buttonHard.setImage(SwingFXUtils.toFXImage(GameImages.HARD_SET.getImage(), null));
        this.buttonNormal.setImage(SwingFXUtils.toFXImage(GameImages.NORMAL_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setDifficulty(Difficulty.HARD);
    }

    @FXML
    public final void setWASD() {
        this.buttonWASD.setImage(SwingFXUtils.toFXImage(GameImages.WASD_SET.getImage(), null));
        this.buttonArrows.setImage(SwingFXUtils.toFXImage(GameImages.ARROWS_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setControls(Controls.WASD);
    }

    @FXML
    public final void setArrows() {
        this.buttonArrows.setImage(SwingFXUtils.toFXImage(GameImages.ARROWS_SET.getImage(), null));
        this.buttonWASD.setImage(SwingFXUtils.toFXImage(GameImages.WASD_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setControls(Controls.ARROW);
    }

    @FXML
    public final void setPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null));
    }

    @FXML
    public final void unsetPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
    }

    public final void play() {
        if (!nickname.getText().isEmpty()) {
            ((SetUpController) this.getController()).setSkin(Skins.BLACK);
            this.switchToGame();
        }
    }
}