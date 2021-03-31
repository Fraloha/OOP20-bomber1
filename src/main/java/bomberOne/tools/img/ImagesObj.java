package bomberOne.tools.img;

import java.awt.image.BufferedImage;


/**
 * This Resource loader use this enum to collect the Images on his map
 * @author Luigi Borriello
 *
 */
public enum ImagesObj {
	 ICON,
	 SPAWN,
     BACKGROUND,
     HARDWALL,
     BOMB,
     FIRE,
     BOX,
     POWER_BOMB,
     POWER_FIREPOWER,
     POWER_SPEED,
     POWER_PIERCE,
     POWER_TIMER;

     BufferedImage image = null;

     public void setImage(BufferedImage image) {
    	 this.image = image;
     }
     
     public BufferedImage getImage() {
         return this.image;
     }
}
