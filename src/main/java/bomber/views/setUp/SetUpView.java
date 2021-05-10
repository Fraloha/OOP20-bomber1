package bomber.views.setUp;

import bomber.views.basic.View;

public interface SetUpView extends View {

    void init();

    void drawSetUp();

    void switchToGame();

    void switchToHome();
}
