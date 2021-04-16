package bomberOne.tools.img;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 
 * This Resource loader use this enum to collect the Images of the objects.
 * 
 *
 */
public enum ObjectsImages {

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
    FIRE("fire.png"),

    /**
     * 
     */
    SPAWN("spawn.png");

    private static final String RES_PATH = "." + File.separator + "images" + File.separator;

    private String fileName;
    private BufferedImage image;

    ObjectsImages(final String fileName) {
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
