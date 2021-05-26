package bomberone.views.setUp;

import bomberone.controllers.setUp.SetUpController;
import bomberone.model.match.Difficulty;
import bomberone.model.user.Controls;
import bomberone.model.user.Skins;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.SoundsHandler;
import bomberone.views.ViewImpl;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.common.GameImages;
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

    private Font font = ResourcesLoader.getInstance().getFont(SetUpViewImpl.SIZE);

    @Override
    public final void init() {
        this.drawSetUp();
        this.getController().init();
        this.defaultSetUp();
    }

    private void defaultSetUp() {
        ((SetUpController) this.getController()).setSkin(Skins.WHITE);
        ((SetUpController) this.getController()).setControls(Controls.WASD);
        ((SetUpController) this.getController()).setDifficulty(Difficulty.EASY);
    }

    @Override
    public final void drawSetUp() {
        this.boxPlayer.setImage(GameImages.P1.getImage());
        this.buttonSX.setImage(GameImages.SX.getImage());
        this.buttonDX.setImage(GameImages.DX.getImage());
        this.buttonNormal.setImage(GameImages.EASY_SET.getImage());
        this.buttonHard.setImage(GameImages.HARD_UNSET.getImage());
        this.buttonWASD.setImage(GameImages.WASD_SET.getImage());
        this.buttonArrows.setImage(GameImages.ARROWS_UNSET.getImage());
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
        this.buttonHome.setImage(GameImages.QUIT_GAME.getImage());
        this.nickname.setFont(font);
        this.difficulty.setFont(font);
        this.controls.setFont(font);
    }

    @Override
    public final void switchToGame() {
        SoundsHandler.getInstance().stopAudio();
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.MATCH, this.getController().getModel());
    }

    @Override
    public final void switchToHome() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
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

        switch (count) {
        case 0:
            this.boxPlayer.setImage(GameImages.P1.getImage());
            ((SetUpController) this.getController()).setSkin(Skins.WHITE);
            break;
        case 1:
            this.boxPlayer.setImage(GameImages.P2.getImage());
            ((SetUpController) this.getController()).setSkin(Skins.BLACK);
            break;
        case 2:
            this.boxPlayer.setImage(GameImages.P3.getImage());
            ((SetUpController) this.getController()).setSkin(Skins.RED);
            break;
        case 3:
            this.boxPlayer.setImage(GameImages.P4.getImage());
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
        this.buttonNormal.setImage(GameImages.EASY_SET.getImage());
        this.buttonHard.setImage(GameImages.HARD_UNSET.getImage());
        ((SetUpController) this.getController()).setDifficulty(Difficulty.EASY);
    }

    @FXML
    private void setHard() {
        this.buttonHard.setImage(GameImages.HARD_SET.getImage());
        this.buttonNormal.setImage(GameImages.EASY_UNSET.getImage());
        ((SetUpController) this.getController()).setDifficulty(Difficulty.HARD);
    }

    @FXML
    private void setWASD() {
        this.buttonWASD.setImage(GameImages.WASD_SET.getImage());
        this.buttonArrows.setImage(GameImages.ARROWS_UNSET.getImage());
        ((SetUpController) this.getController()).setControls(Controls.WASD);
    }

    @FXML
    private void setArrows() {
        this.buttonArrows.setImage(GameImages.ARROWS_SET.getImage());
        this.buttonWASD.setImage(GameImages.WASD_UNSET.getImage());
        ((SetUpController) this.getController()).setControls(Controls.ARROW);
    }

    @FXML
    private void setPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_SET.getImage());
    }

    @FXML
    private void unsetPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
    }

    @FXML
    public final void play() {
        if (!textNickname.getText().isEmpty() && !textNickname.getText().equals("Insert Nickname")) {
            ((SetUpController) this.getController()).setUser(textNickname.getText());
            ((SetUpController) this.getController()).buildUser();
            this.switchToGame();
        } else {
            this.textNickname.setText("Insert Nickname");
        }
    }

    /**
     * Delete the text "Insert NickName" on the TextField when clicked.
     */
    @FXML
    public void deleteText() {
        this.textNickname.setText("");
    }
}
