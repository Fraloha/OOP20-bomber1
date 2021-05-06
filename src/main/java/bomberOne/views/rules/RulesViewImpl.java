package bomberOne.views.rules;

import bomberOne.views.basic.ViewImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class RulesViewImpl extends ViewImpl implements RulesView {

    @FXML
    private Button button;

    @Override
    public void init() {
        Font font = Font.loadFont(ClassLoader.getSystemResource("font/AtlantisInternational-jen0.ttf").toString(), 20);
        this.button.setFont(font);
    }

    @Override
    public void switchToHome() {

    }
}
