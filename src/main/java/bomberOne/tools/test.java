package bomberOne.tools;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

public class test {

	public static void main(String [] args) {
		ResourceLoader.loadImages();
		JFrame test = new JFrame();
		Canvas canvas = new Canvas();
		ImageObserver imageO = new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				return false;
			}
		};
		test.setIconImage(ImagesObj.BACKGROUND.getImage());
		test.getContentPane().add(canvas);
		test.setVisible(true);
	}
}
