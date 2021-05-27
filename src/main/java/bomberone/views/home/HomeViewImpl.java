package bomberone.views.home;

import bomberone.views.ViewImpl;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.common.GameImages;
import bomberone.tools.audio.GameSounds;
import bomberone.tools.audio.SoundsHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;

public class HomeViewImpl extends ViewImpl implements HomeView {

    @FXML
    private Canvas homeCanvas;

    @FXML
    private ImageView boxLogo1;

    @FXML
    private ImageView boxLogo2;

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
        this.drawHome();
        SoundsHandler.getInstance().start(GameSounds.HOME);
        this.getController().init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawHome() {
        this.boxLogo1.setImage(GameImages.BOMBER_LOGO.getImage());
        this.boxLogo2.setImage(GameImages.ONE_LOGO.getImage());
        this.buttonPlay.setImage(GameImages.PLAY_UNSET.getImage());
        this.buttonRank.setImage(GameImages.RANK_UNSET.getImage());
        this.buttonRules.setImage(GameImages.RULES_UNSET.getImage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToSetUp() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.SETUP, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToCredits() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.CREDITS, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRank() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRules() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.RULES, this.getController().getModel());
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
