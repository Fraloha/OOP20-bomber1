package bomberOne.tools.img;

import java.awt.image.BufferedImage;

public enum SpriteMapsObj {

	 PLAYER_1,
     PLAYER_2,
     PLAYER_3,
     PLAYER_4,
     BOMB,
     EXPLOSION_SPRITEMAP,
     ENEMIES_STANDARD,
     ENEMIES_HARD;

     BufferedImage image = null;
     BufferedImage[][] sprites = null;

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
