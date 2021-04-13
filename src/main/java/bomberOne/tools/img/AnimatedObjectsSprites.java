package bomberOne.tools.img;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This enum contains the Sprites of the Object animated
 * @author Luigi
 *
 */
public enum AnimatedObjectsSprites {

	PLAYER_1("bomber1.png"),
    PLAYER_2("bomber2.png"),
    PLAYER_3("bomber3.png"),
    PLAYER_4("bomber4.png"),
    BOMB(""),
    EXPLOSION("explosion.png"),
    ENEMIES_STANDARD("enemiesStandard.png"),
    ENEMIES_HARD("enemiesHard.png");

	private static final String RES_PATH = "."  + File.separator + "images" + File.separator;
	private BufferedImage image;
    private BufferedImage[][] sprites;
    private String fileName;

    AnimatedObjectsSprites(String fileName) {
		this.fileName = fileName;
	}

    public String getFilePath() {
    	return RES_PATH + this.fileName;
    }
    
	public void setImage(BufferedImage img) {
    	this.image = img;
    }
     
    public void setSprite(BufferedImage [][] sprites) {
    	this.sprites = sprites;
    }
     
    public BufferedImage getImage() {
    	return this.image;
    }

    public BufferedImage[][] getSprites() {
    	return this.sprites;
    }
}
