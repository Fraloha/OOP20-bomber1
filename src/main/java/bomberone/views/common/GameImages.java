package bomberone.views.common;

import javafx.scene.image.Image;

/**
 * The Resource loader use this enum to collect the Images used in the Game.
 * 
 *
 */
public enum GameImages {

    /**
     * 
     */
    BOMBER1SCOREBOARD("b1SB.png"),
    /**
     * 
     */
    BOMBER2SCOREBOARD("b2SB.png"),

    /**
     * 
     */
    BOMBER3SCOREBOARD("b3SB.png"),

    /**
     * 
     */
    BOMBER4SCOREBOARD("b4SB.png"),

    /**
     * 
     */
    LIFE_NO("lifeNo.png"),

    /**
     * 
     */
    LIFE_YES("lifeYes.png"),

    /**
     * 
     */
    ICON("icon.png"),

    /**
     * 
    */
    BOMB("bomb.png"),

    /**
     * 
     */
    BACKGROUND("bg.png"),

    /**
     * 
     */
    BOX("box.png"),

    /**
     * 
     */
    QUIT_GAME("quitGame.png"),

    /**
     * 
     */
    POWER_BOMB("power_bomb.png"),

    /**
     * 
     */
    POWER_FIREPOWER("power_firepower.png"),

    /**
     * 
     */
    POWER_SPEED("power_speed.png"),

    /**
     * 
     */
    POWER_PIERCE("power_pierce.png"),

    /**
     * 
     */
    POWER_TIMER("power_timer.png"),

    /**
     * 
     */
    HARDWALL("hardWall.png"),

    /**
     * 
     */
    // FIRE("fire.png"),

    /**
     * 
     */
    CLOCK("clock.png"),

    /**
     * 
     */
    SPAWN("spawn.png"),

    /**
     * 
     */
    BOMBER_LOGO("logo_bomber.png"),

    /**
     * 
     */
    ONE_LOGO("logo_one.png"),

    /**
     * 
     */
    PLAY_UNSET("PLAY_unset.png"),

    /**
     * 
     */
    PLAY_SET("PLAY_set.png"),

    /**
     * 
     */
    RANK_UNSET("RANK_unset.png"),

    /**
     * 
     */
    RANK_SET("RANK_set.png"),

    /**
     * 
     */
    RULES_UNSET("RULES_unset.png"),

    /**
     * 
     */
    RULES_SET("RULES_set.png"),

    /**
     * 
     */
    CREDITS("credits.png"),

    /**
     * 
     */
    RULES("rules_logo.png"),
    /**
     * 
     */
    P1("p1.png"),

    /**
     * 
     */
    P2("p2.png"),

    /**
     * 
     */
    P3("p3.png"),

    /**
     * 
     */
    P4("p4.png"),

    /**
     * 
     */
    DX("DX.png"),

    /**
     * 
     */
    SX("SX.png"),

    /**
     * 
     */
    WASD_SET("WASD_set.png"),

    /**
     * 
     */
    WASD_UNSET("WASD_unset.png"),

    /**
     * 
     */
    ARROWS_SET("ARROWS_set.png"),

    /**
     * 
     */
    ARROWS_UNSET("ARROWS_unset.png"),

    /**
     * 
     */
    HARD_SET("HARD_set.png"),

    /**
     * 
     */
    HARD_UNSET("HARD_unset.png"),

    /**
     * 
     */
    EASY_SET("EASY_set.png"),

    /**
     * 
     */
    EASY_UNSET("EASY_unset.png"),

    /**
     * 
     */
    RANKVIEWTITLE("classifica_logo.png"),

    /**
     * 
     */
    EASYMODE("easy_logo.png"),

    /**
     * 
     */
    HARDMODE("hard_logo.png"),

    /**
     * 
     */
    NEXT_SET("NEXT_set.png"),

    /**
     * 
     */
    NEXT_UNSET("NEXT_unset.png"),

    /**
     * 
     */
    PREV_SET("PREV_set.png"),

    /**
     * 
     */
    PREV_UNSET("PREV_unset.png"),

    /**
     * 
     */
    HOME_BUTTON("HOME_button.png");

    private static final String RES_PATH = "images/";

    private String fileName;
//    private BufferedImage image;
    private Image image;

    GameImages(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Set the image on the specific enum's value.
     * 
     * @param image
     */
    public void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Get the image of the specific enum's value.
     * 
     * @return the images
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Get the path of the image's file.
     * 
     * @return the path of the images file
     */
    public String getFilePath() {
        return RES_PATH + this.fileName;
    }
}
