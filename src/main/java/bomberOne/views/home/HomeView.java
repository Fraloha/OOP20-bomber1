package bomberOne.views.home;

import bomberOne.views.basic.View;

public interface HomeView extends View {

    void drawHomeView();

    void render();

    void switchToSetUp();

    void switchToCredits();

    void switchToRank();
}
