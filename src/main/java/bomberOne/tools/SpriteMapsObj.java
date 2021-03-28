package bomberOne.tools;

import java.awt.image.BufferedImage;

public enum SpriteMapsObj {

	 PLAYER_1,
     PLAYER_2,
     PLAYER_3,
     PLAYER_4,
     BOMB,
     EXPLOSION_SPRITEMAP;

     BufferedImage image = null;
     BufferedImage[][] sprites = null;

     public BufferedImage getImage() {
         return this.image;
     }

     public BufferedImage[][] getSprites() {
         return this.sprites;
     }
}
