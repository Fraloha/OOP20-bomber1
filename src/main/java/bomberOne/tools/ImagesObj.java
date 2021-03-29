package bomberOne.tools;

import java.awt.image.BufferedImage;

/**
 * This Resource loader use this enum to collect the Images on his map
 * @author Luigi Borriello
 *
 */
public enum ImagesObj {
	 ICON,
     BACKGROUND,
     HARDWALL,
     BOX,
     POWER_BOMB,
     POWER_FIREPOWER,
     POWER_SPEED,
     POWER_PIERCE,
     POWER_TIMER;

     BufferedImage image = null;

     public BufferedImage getImage() {
         return this.image;
     }
}
