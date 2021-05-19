package bomberone.views.home;

import bomberone.views.View;

public interface HomeView extends View {

    /**
     * Method that switch the view to SetUpView.
     */
    void switchToSetUp();

    /**
     * Method that switch the view to CreditsView.
     */
    void switchToCredits();

    /**
     * Method that switch the view to RankView.
     */
    void switchToRank();

    /**
     * Method that switch the view to RulesView.
     */
    void switchToRules();
}
