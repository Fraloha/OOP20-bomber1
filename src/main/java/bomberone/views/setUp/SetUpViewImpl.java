package bomberone.views.setUp;

import bomberone.controllers.setUp.SetUpController;
import bomberone.model.Difficulty;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.SoundsHandler;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.GameImages;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class SetUpViewImpl extends ViewImpl implements SetUpView {

    private static final int SIZE = 44;

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
    private TextField textNickname;

    @FXML
    private Label nickname;

    @FXML
    private Label difficulty;

    @FXML
    private Label controls;

    private int count = 0;

    private Font font = ResourcesLoader.getFont(SetUpViewImpl.SIZE);

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
        this.nickname.setFont(font);
        this.difficulty.setFont(font);
        this.controls.setFont(font);
    }

    @Override
    public final void switchToGame() {
        SoundsHandler.stopAudio();
        ViewsSwitcher.switchWithController(this.getStage(), ViewType.GAME, this.getController().getModel());
    }

    @Override
    public final void switchToHome() {
        ViewsSwitcher.switchWithoutController(this.getStage(), ViewType.HOME);
    }

    private void setPlayer(final String sign) {
        if (sign.equals("+")) {
            if (count == 3) {
                count = 0;
            } else {
                count++;
            }
        } else {
            if (count == 0) {
                count = 3;
            } else {
                count--;
            }
        }

        switch (Math.abs(count % 4)) {
        case 0:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P1.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.WHITE);
            break;
        case 1:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P2.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.BLACK);
            break;
        case 2:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P3.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.RED);
            break;
        case 3:
            this.boxPlayer.setImage(SwingFXUtils.toFXImage(GameImages.P4.getImage(), null));
            ((SetUpController) this.getController()).setSkin(Skins.BLUE);
            break;
        default:
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
        if (!textNickname.getText().isEmpty()) {
            this.switchToGame();
        }
    }
}