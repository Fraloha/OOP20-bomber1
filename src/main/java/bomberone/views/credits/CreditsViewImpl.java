package bomberone.views.credits;

import bomberone.views.ViewImpl;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.common.GameImages;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class CreditsViewImpl extends ViewImpl implements CreditsView {

    @FXML
    private ImageView creditsImage;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.drawCredits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawCredits() {
        this.creditsImage.setImage(GameImages.CREDITS.getImage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToHome() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
