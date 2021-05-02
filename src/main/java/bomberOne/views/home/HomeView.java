package bomberOne.views.home;

import bomberOne.views.basic.View;

public interface HomeView extends View {

    void init();

    void drawHome();

    void switchToSetUp();

    void switchToCredits();

    void switchToRank();
}
