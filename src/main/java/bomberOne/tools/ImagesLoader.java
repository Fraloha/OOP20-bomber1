package bomberOne.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import bomberOne.tools.img.ObjectsImages;
import bomberOne.tools.img.AnimatedObjectsSprites;


public class ImagesLoader {
	
	/**
	 * When this method is called, the ResourceLoader launch "loadImages() and sliceSprite()"
	 */
	public static void start() {
		ImagesLoader.loadImages();
		ImagesLoader.sliceSprite();
		
	}
	
	/**
	 * This method load the images from the res/ and puts them on ObjectsImages enum values.
	 * 
	 * @throws IOException if it can't read the Files
	 */
	public static void loadImages() {
		try {
			ObjectsImages.BOMBER1SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOMBER1SCOREBOARD.getFilePath())));
        	ObjectsImages.BOMBER2SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOMBER2SCOREBOARD.getFilePath())));
        	ObjectsImages.BOMBER3SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOMBER3SCOREBOARD.getFilePath())));
        	ObjectsImages.BOMBER4SCOREBOARD.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOMBER4SCOREBOARD.getFilePath())));
        	ObjectsImages.LIFE_NO.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.LIFE_NO.getFilePath())));
        	ObjectsImages.LIFE_YES.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.LIFE_YES.getFilePath())));
        	ObjectsImages.ICON.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.ICON.getFilePath())));
        	ObjectsImages.BOMB.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOMB.getFilePath())));
        	ObjectsImages.BACKGROUND.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BACKGROUND.getFilePath())));
        	ObjectsImages.BOX.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.BOX.getFilePath())));
        	ObjectsImages.POWER_BOMB.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.POWER_BOMB.getFilePath())));
        	ObjectsImages.POWER_FIREPOWER.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.POWER_FIREPOWER.getFilePath())));
        	ObjectsImages.POWER_SPEED.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.POWER_SPEED.getFilePath())));
        	ObjectsImages.POWER_PIERCE.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.POWER_PIERCE.getFilePath())));
        	ObjectsImages.POWER_TIMER.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.POWER_TIMER.getFilePath())));
        	ObjectsImages.HARDWALL.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.HARDWALL.getFilePath())));
        	ObjectsImages.FIRE.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.FIRE.getFilePath())));
        	ObjectsImages.SPAWN.setImage(ImageIO.read(ClassLoader.getSystemResource(ObjectsImages.SPAWN.getFilePath())));
        	
        	AnimatedObjectsSprites.PLAYER_1.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.PLAYER_1.getFilePath())));
        	AnimatedObjectsSprites.PLAYER_2.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.PLAYER_2.getFilePath())));
	        AnimatedObjectsSprites.PLAYER_3.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.PLAYER_3.getFilePath())));
	        AnimatedObjectsSprites.PLAYER_4.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.PLAYER_4.getFilePath())));
	        AnimatedObjectsSprites.ENEMIES_HARD.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.ENEMIES_HARD.getFilePath())));
	        AnimatedObjectsSprites.ENEMIES_STANDARD.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.ENEMIES_STANDARD.getFilePath()))); 
	        AnimatedObjectsSprites.EXPLOSION.setImage(ImageIO.read(ClassLoader.getSystemResource(AnimatedObjectsSprites.EXPLOSION.getFilePath())));
	        
		} catch (IOException e) {
			System.out.println("Cannot read the Images");
			e.printStackTrace();
		}
	}
	
	 /**
     * Slice and load sprite maps.
     */
	public static void sliceSprite() {
		AnimatedObjectsSprites.PLAYER_1.setSprite(sliceSpriteMap(AnimatedObjectsSprites.PLAYER_1.getImage(), 32, 48));
    	AnimatedObjectsSprites.PLAYER_2.setSprite(sliceSpriteMap(AnimatedObjectsSprites.PLAYER_2.getImage(), 32, 48));
    	AnimatedObjectsSprites.PLAYER_3.setSprite(sliceSpriteMap(AnimatedObjectsSprites.PLAYER_3.getImage(), 32, 48));
    	AnimatedObjectsSprites.PLAYER_4.setSprite(sliceSpriteMap(AnimatedObjectsSprites.PLAYER_4.getImage(), 32, 48));
    	AnimatedObjectsSprites.ENEMIES_HARD.setSprite(sliceSpriteMap(AnimatedObjectsSprites.ENEMIES_HARD.getImage(), 32, 48));
    	AnimatedObjectsSprites.ENEMIES_STANDARD.setSprite(sliceSpriteMap(AnimatedObjectsSprites.ENEMIES_STANDARD.getImage(), 32, 48));
    	AnimatedObjectsSprites.EXPLOSION.setSprite(sliceSpriteMap(AnimatedObjectsSprites.EXPLOSION.getImage(), 32, 32));
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
