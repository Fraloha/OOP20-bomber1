package bomberone.views.home;

import bomberone.model.common.GameImages;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
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
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null));
    }

    /**
     * Method that deselect button play.
     */
    @FXML
    public void unsetPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
    }

    /**
     * Method that select button rank.
     */
    @FXML
    public void setRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_SET.getImage(), null));
    }

    /**
     * Method that deselect button rank.
     */
    @FXML
    public void unsetRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null));
    }

    /**
     * Method that select button rules.
     */
    @FXML
    public void setRules() {
        this.buttonRules.setImage(SwingFXUtils.toFXImage(GameImages.RULES_SET.getImage(), null));
    }

    /**
     * Method that deselect button rules.
     */
    @FXML
    public void unsetRules() {
        this.buttonRules.setImage(SwingFXUtils.toFXImage(GameImages.RULES_UNSET.getImage(), null));
    }
}
