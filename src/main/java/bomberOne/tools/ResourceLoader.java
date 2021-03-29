package bomberOne.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bomberOne.tools.img.ImagesObj;
import bomberOne.tools.img.SpriteMapsObj;


public class ResourceLoader {
	
	/**
	 * This method load the images from the res/ and puts them on its map.
	 * 
	 * @throws IOException if it can't read the Files
	 */
	public static void loadImages() {
		System.out.println(System.getProperty("user.dir"));
         try {
        	 ImagesObj.ICON.setImage(ImageIO.read(new File(".//res//images//icon.png")));
        	 ImagesObj.BOMB.setImage(ImageIO.read(new File(".//res//images//bomb.png")));
        	 ImagesObj.BACKGROUND.setImage(ImageIO.read(new File(".//res//images//bg.png")));
        	 ImagesObj.BOX.setImage(ImageIO.read(new File(".//res//images//box.png")));
        	 ImagesObj.POWER_BOMB.setImage(ImageIO.read(new File(".//res//images//power_bomb.png")));
        	 ImagesObj.POWER_FIREPOWER.setImage(ImageIO.read(new File(".//res//images//power_firepower.png")));
        	 ImagesObj.POWER_SPEED.setImage(ImageIO.read(new File(".//res//images//power_speed.png")));
        	 ImagesObj.POWER_PIERCE.setImage(ImageIO.read(new File(".//res//images//power_pierce.png")));
        	 ImagesObj.POWER_TIMER.setImage(ImageIO.read(new File(".//res//images//power_timer.png")));
        	 ImagesObj.HARDWALL.setImage(ImageIO.read(new File(".//res//images//hardWall.png")));
        	 ImagesObj.FIRE.setImage(ImageIO.read(new File(".//res//images//fire.png")));
        	 
        	 SpriteMapsObj.PLAYER_1.setImage(ImageIO.read(new File(".//res//images//bomber1.png")));
        	 SpriteMapsObj.PLAYER_2.setImage(ImageIO.read(new File(".//res//images//bomber2.png")));
	         SpriteMapsObj.PLAYER_3.setImage(ImageIO.read(new File(".//res//images//bomber3.png")));
	         SpriteMapsObj.PLAYER_4.setImage(ImageIO.read(new File(".//res//images//bomber4.png")));
	         SpriteMapsObj.ENEMIES_HARD.setImage(ImageIO.read(new File(".//res//images//enemiesHard.png")));
	         SpriteMapsObj.ENEMIES_STANDARD.setImage(ImageIO.read(new File(".//res//images//enemiesSTANDARD.png")));
		        
	         SpriteMapsObj.EXPLOSION_SPRITEMAP.setImage(ImageIO.read(new File(".//res//images//explosion.png")));
	         
          } catch (IOException e) {
			System.out.println("Cannot read the Images");
			e.printStackTrace();
		}
	}
	
	 /**
     * Slice and load sprite maps.
     */
    public static void sliceSprite() {
    	SpriteMapsObj.PLAYER_1.setSprite(sliceSpriteMap(SpriteMapsObj.PLAYER_1.getImage(), 32, 48));
    	SpriteMapsObj.PLAYER_2.setSprite(sliceSpriteMap(SpriteMapsObj.PLAYER_2.getImage(), 32, 48));
    	SpriteMapsObj.PLAYER_3.setSprite(sliceSpriteMap(SpriteMapsObj.PLAYER_3.getImage(), 32, 48));
    	SpriteMapsObj.PLAYER_4.setSprite(sliceSpriteMap(SpriteMapsObj.PLAYER_4.getImage(), 32, 48));
    	SpriteMapsObj.ENEMIES_HARD.setSprite(sliceSpriteMap(SpriteMapsObj.ENEMIES_HARD.getImage(), 32, 48));
    	SpriteMapsObj.ENEMIES_STANDARD.setSprite(sliceSpriteMap(SpriteMapsObj.ENEMIES_STANDARD.getImage(), 32, 48));
    	
    	SpriteMapsObj.EXPLOSION_SPRITEMAP.setSprite(sliceSpriteMap(SpriteMapsObj.EXPLOSION_SPRITEMAP.getImage(), 32, 32));
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
