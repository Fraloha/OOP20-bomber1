package bomberOne.tools.img;

import java.awt.image.BufferedImage;
import java.io.File;

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
    HOME_LOGO("logo_BomberOne.png"),

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
    TUTORIAL_UNSET("TUTORIAL_unset.png"),

    /**
     * 
     */
    TUTORIAL_SET("TUTORIAL_set.png"),

    /**
     * 
     */
    CREDITS("credits.png");


    private static final String RES_PATH = "images/";

    private String fileName;
    private BufferedImage image;

    GameImages(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Set the image on the specific enum's value.
     * 
     * @param image
     */
    public void setImage(final BufferedImage image) {
        this.image = image;
    }

    /**
     * Get the image of the specific enum's value.
     * 
     * @return the images
     */
    public BufferedImage getImage() {
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
