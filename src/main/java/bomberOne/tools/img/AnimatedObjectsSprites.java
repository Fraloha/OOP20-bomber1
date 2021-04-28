package bomberOne.tools.img;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This enum contains the Sprites of the Object animated.
 * 
 *
 */
public enum AnimatedObjectsSprites {

    /**
     * 
     */
    PLAYER_1("bomber1.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 

    /**
     * 
     */
    PLAYER_2("bomber2.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 

    /**
     * 
     */
    PLAYER_3("bomber3.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 

    /**
     * 
     */
    PLAYER_4("bomber4.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT),
    
    /**
     * 
     */
    FIRE("FIRE.png", AnimatedObjectsSprites.STD_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 

    /**
     * 
     */
    BOMB("bombSprite.png", AnimatedObjectsSprites.STD_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 
    
    /**
     * 
     */
    ENEMIES_STANDARD("enemiesStandard.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT), 

    /**
     * 
     */
    ENEMIES_HARD("enemiesHard.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_HEIGHT);

    public static final int STD_HEIGHT = 32;
    public static final int STD_WIDTH = 32;
    public static final int ENTITY_HEIGHT = 48;
    
    private static final String RES_PATH = "." + File.separator + "images" + File.separator;
    private BufferedImage image;
    private BufferedImage[][] sprites;
    private String fileName;
    private int width;
    private int height;

    AnimatedObjectsSprites(final String fileName, final int height, final int width) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    /**
     * 
     * @return the path of Sprite's file.
     */
    public String getFilePath() {
        return RES_PATH + this.fileName;
    }

    /**
     * 
     * @param img to attach to the Value.
     */
    public void setImage(final BufferedImage img) {
        this.image = img;
    }

    /**
     * Attach the images Matrix to the Value.
     * 
     * @param sprites to attach to the Value
     */
    public void setSprite(final BufferedImage[][] sprites) {
        this.sprites = sprites;
    }

    /**
     * 
     * @return the image attached to the Value.
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * 
     * @return the images matrix attached to the Value.
     */
    public BufferedImage[][] getSprites() {
        return this.sprites;
    }
    
    /**
     * 
     * @return the Height of every single image of the Sprite
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * 
     * @return the Width of every single image of the Sprite
     */
    public int getWidth() {
        return this.width;
    }
}
