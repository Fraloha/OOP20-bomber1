package bomberone.views.setUp;

import bomberone.views.basic.View;

public interface SetUpView extends View {

    void init();

    void drawSetUp();

    void switchToGame();

    void switchToHome();
}
