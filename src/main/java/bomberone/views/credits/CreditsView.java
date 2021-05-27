package bomberone.views.credits;

import bomberone.views.View;

public interface CreditsView extends View {

    /**
     * Method that load the resource.
     */
    void drawCredits();

    /**
     * Method that switch the view to HomeView.
     */
    void switchToHome();
}
