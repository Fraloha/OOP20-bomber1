package bomberOne.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceLoader {
	
	/**
	 * This method load the images from the res/ and puts them on its map.
	 * 
	 * @throws IOException if it can't read the Files
	 */
	public static void loadImages() {
		System.out.println(System.getProperty("user.dir"));
         try {
        	 ImagesObj.ICON.image = ImageIO.read(new File(".//res//images//icon.png"));
        	 ImagesObj.BACKGROUND.image = ImageIO.read(new File(".//res//images//bg.png"));
        	 ImagesObj.BOX.image = ImageIO.read(new File(".//res//images//box.png"));
        	 ImagesObj.POWER_BOMB.image = ImageIO.read(new File(".//res//images//power_bomb.png"));
        	 ImagesObj.POWER_FIREPOWER.image = ImageIO.read(new File(".//res//images//power_firepower.png"));
        	 ImagesObj.POWER_SPEED.image = ImageIO.read(new File(".//res//images//power_speed.png"));
        	 ImagesObj.POWER_PIERCE.image = ImageIO.read(new File(".//res//images//power_pierce.png"));
        	 ImagesObj.POWER_TIMER.image = ImageIO.read(new File(".//res//images//power_timer.png"));
        	 ImagesObj.HARDWALL.image = ImageIO.read(new File(".//res//images//hardWall.png"));
        	 
        	 
        	 SpriteMapsObj.PLAYER_1.image = ImageIO.read(new File(".//res//images//bomber1.png"));
        	 SpriteMapsObj.PLAYER_2.image = ImageIO.read(new File(".//res//images//bomber2.png"));
	         SpriteMapsObj.PLAYER_3.image = ImageIO.read(new File(".//res//images//bomber3.png"));
	         SpriteMapsObj.PLAYER_4.image = ImageIO.read(new File(".//res//images//bomber4.png"));
	         SpriteMapsObj.BOMB.image = ImageIO.read(new File(".//res//images//bomb.png"));
	         SpriteMapsObj.EXPLOSION_SPRITEMAP.image = ImageIO.read(new File(".//res//images//explosion.png"));
	         SpriteMapsObj.ENEMIES.image = ImageIO.read(new File(".//res//images//enemies.png"));

          } catch (IOException e) {
			System.out.println("Cannot read the Images");
			e.printStackTrace();
		}
	}
	
	 /**
     * Slice and load sprite maps.
     */
    public static void sliceSprite() {
    	SpriteMapsObj.PLAYER_1.sprites = sliceSpriteMap(SpriteMapsObj.PLAYER_1.image, 32, 48);
    	SpriteMapsObj.PLAYER_2.sprites = sliceSpriteMap(SpriteMapsObj.PLAYER_2.image, 32, 48);
    	SpriteMapsObj.PLAYER_3.sprites = sliceSpriteMap(SpriteMapsObj.PLAYER_3.image, 32, 48);
    	SpriteMapsObj.PLAYER_4.sprites = sliceSpriteMap(SpriteMapsObj.PLAYER_4.image, 32, 48);
    	SpriteMapsObj.BOMB.sprites = sliceSpriteMap(SpriteMapsObj.BOMB.image, 32, 32);
    	SpriteMapsObj.EXPLOSION_SPRITEMAP.sprites = sliceSpriteMap(SpriteMapsObj.EXPLOSION_SPRITEMAP.image, 32, 32);
    }
    
    /**
     * Slice sprite sheet into individual sprites stored in a two-dimensional array.
     * @param spriteMap Sprite sheet to be sliced
     * @param spriteWidth Width of each individual sprite
     * @param spriteHeight Height of each individual sprite
     * @return Two-dimensional array of sprites
     */
    private static BufferedImage[][] sliceSpriteMap(BufferedImage spriteMap, int spriteWidth, int spriteHeight) {
        int rows = spriteMap.getHeight() / spriteHeight;
        int cols = spriteMap.getWidth() / spriteWidth;
        BufferedImage[][] sprites = new BufferedImage[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sprites[row][col] = spriteMap.getSubimage(col * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
            }
        }

        return sprites;
    }
}
