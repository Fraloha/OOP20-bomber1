package bomberone.views.common;


import javafx.scene.image.Image;

/**
 * This enum contains the Sprites of the animated GameObjects.
 * 
 *
 */
public enum AnimatedObjectsSprites {

    /**
     * 
     */
    BOMBER_WHITE("bomber1.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    BOMBER_BLACK("bomber2.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    BOMBER_RED("bomber3.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    BOMBER_BLUE("bomber4.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    FIRE("fire.png", AnimatedObjectsSprites.STD_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    BOMB("bombSprite.png", AnimatedObjectsSprites.STD_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    PIERCE_BOMB("bombPiercedSprite.png", AnimatedObjectsSprites.STD_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    ENEMIES_STANDARD("enemiesStandard.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH),

    /**
     * 
     */
    ENEMIES_HARD("enemiesHard.png", AnimatedObjectsSprites.ENTITY_HEIGHT, AnimatedObjectsSprites.STD_WIDTH);

    private static final int STD_HEIGHT = 32;
    private static final int STD_WIDTH = 32;
    private static final int ENTITY_HEIGHT = 48;

    private static final String RES_PATH = "images/";
    private Image image;
    private Image[][] sprites;
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
    public void setImage(final Image img) {
        this.image = img;
    }

    /**
     * Attach the images Matrix to the Value.
     * 
     * @param sprites to attach to the Value
     */
    public void setSprite(final Image[][] sprites) {
        this.sprites = sprites;
    }

    /**
     * 
     * @return the image attached to the Value.
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * 
     * @return the images matrix attached to the Value.
     */
    public Image[][] getSprites() {
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
