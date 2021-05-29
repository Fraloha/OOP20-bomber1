package bomberone.views.rules;

import bomberone.views.View;

public interface RulesView extends View {

    /**
     * Method that load the resources.
     */
    void drawRules();

    /**
     * Method that switch the view to HomeView.
     */
    void switchToHome();
}
