package bomberOne.tools;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import bomberOne.tools.img.ObjectsImages;
import bomberOne.tools.img.AnimatedObjectsSprites;


public class ImagesLoader {
	
	private static final int ANIMATED_HEIGHT = 48;
	private static final int OBJ_HEIGHT = 32;
	private static final int OBJ_WIDTH = 32;

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
		Arrays.stream(ObjectsImages.values()).forEach(value -> {
			try {
				value.setImage(ImageIO.read(ClassLoader.getSystemResource(value.getFilePath())));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		Arrays.stream(AnimatedObjectsSprites.values()).forEach(value -> {
			try {
				value.setImage(ImageIO.read(ClassLoader.getSystemResource(value.getFilePath())));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
	 /**
     * Slice and load sprite maps.
     */
	public static void sliceSprite() {
		Arrays.stream(AnimatedObjectsSprites.values()).forEach(value -> {
			if(value.equals(AnimatedObjectsSprites.EXPLOSION)) {
				value.setSprite(sliceSpriteMap(value.getImage(), OBJ_WIDTH, OBJ_HEIGHT));
			}
			else {
				value.setSprite(sliceSpriteMap(value.getImage(), OBJ_WIDTH, ANIMATED_HEIGHT));
			}
		});
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
