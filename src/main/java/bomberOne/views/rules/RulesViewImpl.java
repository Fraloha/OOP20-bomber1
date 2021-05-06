package bomberOne.views.rules;

import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class RulesViewImpl extends ViewImpl implements RulesView {

    @FXML
    private ImageView backToHome;

    @Override
    public void init() {

    }

    @FXML
    public final void switchToHome() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
