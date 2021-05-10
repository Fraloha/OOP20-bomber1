package bomberone.views.credits;

import bomberone.model.common.GameImages;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class CreditsViewImpl extends ViewImpl implements CreditsView {

    @FXML
    private ImageView creditsImage;

    @Override
    public void init() {
        this.creditsImage.setImage(SwingFXUtils.toFXImage(GameImages.CREDITS.getImage(), null));
    }

    @Override
    public void switchToHome() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }

}
