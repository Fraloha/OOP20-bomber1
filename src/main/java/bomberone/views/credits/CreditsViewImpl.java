package bomberone.views.credits;

import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.GameImages;
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
        this.creditsImage.setImage(GameImages.CREDITS.getImage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToHome() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }

}
