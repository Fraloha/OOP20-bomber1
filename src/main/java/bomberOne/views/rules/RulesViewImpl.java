package bomberOne.views.rules;

import bomberOne.tools.ResourcesLoader;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.basic.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class RulesViewImpl extends ViewImpl implements RulesView {

    @FXML
    private ImageView backToHome;

    @FXML
    private Button button;

    @Override
    public void init() {
        this.button.setFont(ResourcesLoader.getFont(20));
        this.button.setText("ZIO PORCOOOOO");
        // Font font =
        // Font.loadFont(ClassLoader.getSystemResource("font/AtlantisInternational-jen0.ttf").toString(),
        // 20);
        // this.button.setFont(font);
    }

    @FXML
    public void switchToHome() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
