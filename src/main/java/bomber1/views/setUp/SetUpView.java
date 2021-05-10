package bomber1.views.setUp;

import bomber1.views.basic.View;

public interface SetUpView extends View {

    void init();

    void drawSetUp();

    void switchToGame();

    void switchToHome();
}
