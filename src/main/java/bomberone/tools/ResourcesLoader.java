package bomberone.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bomberone.model.common.Maps;
import bomberone.views.common.AnimatedObjectsSprites;
import bomberone.views.common.GameImages;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;

/**
 * Utility class that load the Resources from the specific directories.
 *
 */
public final class ResourcesLoader {

    private ResourcesLoader() {

    }

    /* Singleton Pattern */
    private static class LazyHolder {
        private static final ResourcesLoader SINGLETON = new ResourcesLoader();
    }

    // Create SINGLETON on the first call.
    public static ResourcesLoader getInstance() {
        return LazyHolder.SINGLETON;
    }

    /**
     * When this method is called, the ResourceLoader launch "loadImages() and
     * sliceSprite()".
     */
    public void start() {
        this.loadImages();
        this.sliceSprite();
        this.loadMap();
    }

    /**
     * This method load the images from the res/ and puts them on ObjectsImages enum
     * values.
     * 
     * @throws IOException if it can't read the Files
     */
    public void loadImages() {
        Arrays.stream(GameImages.values()).forEach(value -> {
            value.setImage(new Image(ClassLoader.getSystemResourceAsStream(value.getFilePath())));
        });

        Arrays.stream(AnimatedObjectsSprites.values()).forEach(value -> {
            value.setImage(new Image(ClassLoader.getSystemResourceAsStream(value.getFilePath())));
        });
    }

    /**
     * This method load the the fixed map of the game.
     * 
     * @throws IOException if it can't read the Files
     */
    public void loadMap() {
        Arrays.stream(Maps.values()).forEach(value -> {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(ClassLoader.getSystemResourceAsStream(value.getFilePath())));
                List<List<String>> mapLayout = new ArrayList<>();
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    if (currentLine.isEmpty()) {
                        continue;
                    }
                    mapLayout.add(new ArrayList<>(Arrays.asList(currentLine.split(","))));
                }
                value.setList(mapLayout);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * That method return the font of the program, sized with the input parameter.
     * 
     * @param size
     * @return Font
     */
    public Font getFont(final int size) {
        return Font.loadFont(ClassLoader.getSystemResource("font/AtlantisInternational-jen0.ttf").toString(), size);
    }

    /**
     * Slice and load sprite maps.
     */
    public void sliceSprite() {
        Arrays.stream(AnimatedObjectsSprites.values()).forEach(value -> {
            value.setSprite(sliceSpriteMap(value.getImage(), value.getWidth(), value.getHeight()));
        });
    }

    /**
     * Slice sprite sheet into individual sprites stored in a two-dimensional array.
     * 
     * @param spriteMap    Sprite sheet to be sliced
     * @param spriteWidth  Width of each individual sprite
     * @param spriteHeight Height of each individual sprite
     * @return Two-dimensional array of sprites
     */
    private Image[][] sliceSpriteMap(final Image spriteMap, final int spriteWidth,
            final int spriteHeight) {
        int rows = (int) (spriteMap.getHeight() / spriteHeight);
        int cols = (int) (spriteMap.getWidth() / spriteWidth);
       Image[][] sprites = new Image[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sprites[row][col] = new WritableImage(spriteMap.getPixelReader(), col * spriteWidth, row * spriteHeight, spriteWidth,
                        spriteHeight);
            }
        }
        return sprites;
    }

    /**
     * Get the URL of RankView StyleSheets.
     * @return the URL.toString() of RankViewStyleSheets
     */
    public String getRankStyleSheets() {
        return ClassLoader.getSystemResource("styleSheets/RankViewStyle.css").toString();
    }
}
