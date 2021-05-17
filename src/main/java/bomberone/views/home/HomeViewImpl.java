package bomberone.views.home;

import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.match.img.GameImages;
import bomberone.tools.audio.GameSounds;
import bomberone.tools.audio.SoundsHandler;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        SoundsHandler.start(GameSounds.HOME);
        this.getController().init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToSetUp() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.SETUP, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToCredits() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.CREDITS, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRank() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRules() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.RULES, this.getController().getModel());
    }

    /**
     * Method that select button play.
     */
    @FXML
    public void setPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_SET.getImage());
    }

    /**
     * Method that deselect button play.
     */
    @FXML
    public void unsetPlay() {
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
    }

    /**
     * Method that select button rank.
     */
    @FXML
    public void setRank() {
        this.buttonRank.setImage(GameImages.RANK_SET.getImage());
    }

    /**
     * Method that deselect button rank.
     */
    @FXML
    public void unsetRank() {
        this.buttonRank.setImage(GameImages.RANK_UNSET.getImage());
    }

    /**
     * Method that select button rules.
     */
    @FXML
    public void setRules() {
        this.buttonRules.setImage(GameImages.RULES_SET.getImage());
    }

    /**
     * Method that deselect button rules.
     */
    @FXML
    public void unsetRules() {
        this.buttonRules.setImage(GameImages.RULES_UNSET.getImage());
    }
}
