package bomberOne.views.setUp;

import bomberOne.controllers.setUp.SetUpController;
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

    private int count = 1;

    @Override
    public final void init() {
        this.drawSetUp();
        this.getController().init();
        this.defaultSetUp();
    }

    private void defaultSetUp() {
        ((SetUpController) this.getController()).setSkin(Skins.WHITE);
        ((SetUpController) this.getController()).setControls(Controls.WASD);
        ((SetUpController) this.getController()).setDifficulty(Difficulty.STANDARD);
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

    private void setPlayer(final String sign) {
        switch (count) {
        case 1:
            if (sign.equals("+")) {
                count++;
            } else {
                count = 4;
            }
            break;
        case 4:
            if (sign.equals("+")) {
                count = 1;
            } else {
                count--;
            }
            break;
        default:
            if (sign.equals("+")) {
                count++;
            } else {
                count--;
            }
            break;
        }

        switch (count) {
        case 1:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P1.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.WHITE);
            break;
        case 2:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P2.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.BLACK);
            break;
        case 3:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P3.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.RED);
            break;
        case 4:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P4.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.BLUE);
            break;
        }
    }

    @FXML
    private void dx() {
        this.setPlayer("+");
    }

    @FXML
    private void sx() {
        this.setPlayer("-");
    }

    @FXML
    private void setNormal() {
        this.buttonNormal.setImage(SwingFXUtils.toFXImage(GameImages.NORMAL_SET.getImage(), null));
        this.buttonHard.setImage(SwingFXUtils.toFXImage(GameImages.HARD_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setDifficulty(Difficulty.STANDARD);
    }

    @FXML
    private void setHard() {
        this.buttonHard.setImage(SwingFXUtils.toFXImage(GameImages.HARD_SET.getImage(), null));
        this.buttonNormal.setImage(SwingFXUtils.toFXImage(GameImages.NORMAL_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setDifficulty(Difficulty.HARD);
    }

    @FXML
    private void setWASD() {
        this.buttonWASD.setImage(SwingFXUtils.toFXImage(GameImages.WASD_SET.getImage(), null));
        this.buttonArrows.setImage(SwingFXUtils.toFXImage(GameImages.ARROWS_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setControls(Controls.WASD);
    }

    @FXML
    private void setArrows() {
        this.buttonArrows.setImage(SwingFXUtils.toFXImage(GameImages.ARROWS_SET.getImage(), null));
        this.buttonWASD.setImage(SwingFXUtils.toFXImage(GameImages.WASD_UNSET.getImage(), null));
        ((SetUpController) this.getController()).setControls(Controls.ARROW);
    }

    @FXML
    private void setPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null));
    }

    @FXML
    private void unsetPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
    }

    public final void play() {
        if (!nickname.getText().isEmpty()) {
            this.switchToGame();
        }
    }
}