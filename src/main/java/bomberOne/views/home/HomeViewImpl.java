package bomberOne.views.home;

import bomberOne.tools.img.GameImages;
import bomberOne.views.basic.ViewImpl;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HomeViewImpl extends ViewImpl implements HomeView {

    @FXML
    private ImageView buttonPlay;

    @FXML
    private ImageView buttonRank;

    @FXML
    private ImageView buttonTutorial;

    @Override
    public void drawHomeView() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchToSetUp() {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchToCredits() {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchToRank() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    public void setPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_SET.getImage(), null));
    }

    public void unsetPlay() {
        this.buttonPlay.setImage(SwingFXUtils.toFXImage(GameImages.PLAY_UNSET.getImage(), null));
    }

    public void setRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_SET.getImage(), null));
    }

    public void unsetRank() {
        this.buttonRank.setImage(SwingFXUtils.toFXImage(GameImages.RANK_UNSET.getImage(), null));
    }

    public void setTutorial() {
        this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_SET.getImage(), null));
    }

    public void unsetTutorial() {
        this.buttonTutorial.setImage(SwingFXUtils.toFXImage(GameImages.TUTORIAL_UNSET.getImage(), null));
    }
}
