package bomberone.views.setUp;

import bomberone.views.View;

public interface SetUpView extends View {

    /**
     * This method loads the resources.
     */
    void drawSetUp();

    /**
     * This method switch the view to GameView.
     */
    void switchToGame();

    /**
     * This method switch the view to HomeView.
     */
    void switchToHome();
}
