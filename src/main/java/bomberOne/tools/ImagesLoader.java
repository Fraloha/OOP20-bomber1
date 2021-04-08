package bomberOne.tools;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bomberOne.tools.img.ImagesObj;
import bomberOne.tools.img.SpriteMapsObj;


public class ImagesLoader {
	
	 private static final String RES_PATH = "."  + File.separator + "images" + File.separator;
	/**
	 * When this method is called, the ResourceLoader launch "loadImages() and sliceSprite()"
	 */
	public static void start() {
		ImagesLoader.loadImages();
		ImagesLoader.sliceSprite();
		
	}
	
	/**
	 * This method load the images from the res/ and puts them on ImageObj enum values.
	 * 
	 * @throws IOException if it can't read the Files
	 */
	public static void loadImages() {
		System.out.println(System.getProperty("user.dir"));
         try {
        	 
        	 ImagesObj.BOMBER1SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "b1SB.png")));
        	 ImagesObj.BOMBER2SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "b2SB.png")));
        	 ImagesObj.BOMBER3SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "b3SB.png")));
        	 ImagesObj.BOMBER4SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "b4SB.png")));
        	 ImagesObj.LIFE_NO.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "lifeNo.png")));
        	 ImagesObj.LIFE_YES.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "lifeYes.png")));
         	 
        	 
        	 ImagesObj.ICON.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "icon.png")));
        	 ImagesObj.BOMB.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bomb.png")));
        	 ImagesObj.BACKGROUND.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bg.png")));
        	 ImagesObj.BOX.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "box.png")));
        	 ImagesObj.POWER_BOMB.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "power_bomb.png")));
        	 ImagesObj.POWER_FIREPOWER.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "power_firepower.png")));
        	 ImagesObj.POWER_SPEED.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "power_speed.png")));
        	 ImagesObj.POWER_PIERCE.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "power_pierce.png")));
        	 ImagesObj.POWER_TIMER.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "power_timer.png")));
        	 ImagesObj.HARDWALL.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "hardWall.png")));
        	 ImagesObj.FIRE.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "fire.png")));
        	 ImagesObj.SPAWN.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "spawn.png")));
        	 
        	 SpriteMapsObj.PLAYER_1.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bomber1.png")));
        	 SpriteMapsObj.PLAYER_2.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bomber2.png")));
	         SpriteMapsObj.PLAYER_3.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bomber3.png")));
	         SpriteMapsObj.PLAYER_4.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "bomber4.png")));
	         SpriteMapsObj.ENEMIES_HARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "enemiesHard.png")));
	         SpriteMapsObj.ENEMIES_STANDARD.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "enemiesSTANDARD.png")));
		        
	         SpriteMapsObj.EXPLOSION_SPRITEMAP.setImage(ImageIO.read(ClassLoader.getSystemResource(RES_PATH + "explosion.png")));
	         
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
