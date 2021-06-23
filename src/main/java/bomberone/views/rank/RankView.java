package bomberone.views.rank;

import bomberone.views.View;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public interface RankView extends View {

    /**
     * This method sets an Image object to an ImageView object, on the basis of a
     * boolean value. If the first parameter is true, the "verified" argument is set
     * as the image of the ImageView object, otherwise the "notVerified" argument is
     * set.
     * 
     * @param set         The boolean value that acts like a condition.
     * @param verified    The Image object that has to be set if the "set" argument
     *                    is true.
     * @param notVerified The Image object that has to be set if the "set argument
     *                    is false.
     * @param imageToSet  The ImageView where the second or third argument has to be
     *                    set.
     */
    void setButton(boolean set, Image verified, Image notVerified, ImageView imageToSet);

    /**
     * This method sets the initial images at the form initialization.
     */
    void setButtonImages();

    /**
     * This method sets all the buttons event handlers.
     */
    void setButtonsEventHandlers();

    /**
     * This method initialize the TableView object, setting the font and the style.
     * 
     * @param fontToSet The font of the cells.
     */
    void tableViewInitialization(Font fontToSet);

    /**
     * This method loads all the images that the view need to set to the ImageView
     * objects.
     */
    void loadImages();

    /**
     * This method loads the ranks.
     */
    void loadRanks();

    /**
     * This method changes the rank to visualize on the basis of the click event in
     * the next or previous buttons.
     * 
     * @param next This arguments has to be true if the next rank (a more difficult
     *             mode rank) is to be showed, otherwise false to visualize the
     *             previous rank (a less difficult mode rank).
     */
    void changeRank(boolean next);

    /**
     * This method switch the view to the home.
     */
    void onBackToMainMenuClicked();

    /**
     * This method shows a more difficult mode rank.
     */
    void onNextClicked();

    /**
     * This method shows a less difficult mode rank.
     */
    void onPreviousClicked();
}
