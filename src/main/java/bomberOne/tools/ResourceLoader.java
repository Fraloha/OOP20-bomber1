package bomberOne.tools;

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
        	
        	 SpriteMapsObj.PLAYER_1.image = ImageIO.read(new File(".//res//images//bomber1.png"));
        	 SpriteMapsObj.PLAYER_2.image = ImageIO.read(new File(".//res//images//bomber2.png"));
	         SpriteMapsObj.PLAYER_3.image = ImageIO.read(new File(".//res//images//bomber3.png"));
	         SpriteMapsObj.PLAYER_4.image = ImageIO.read(new File(".//res//images//bomber4.png"));
	         SpriteMapsObj.BOMB.image = ImageIO.read(new File(".//res//images//bomb.png"));
	         SpriteMapsObj.EXPLOSION_SPRITEMAP.image = ImageIO.read(new File(".//res//images//explosion.png"));

          } catch (IOException e) {
			System.out.println("Cannot read the Images");
			e.printStackTrace();
		}
          
	}
}
