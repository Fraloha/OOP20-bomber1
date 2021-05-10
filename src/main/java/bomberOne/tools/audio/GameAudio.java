package bomberOne.tools.audio;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;

import javafx.scene.media.Media;

public enum GameAudio {

    /**
     * 
     */
    CLASSIC("audio/", "classic.wav", 0.012),

    /**
     * 
     */
    HOME("audio/", "home.wav", 0.012),

    /**
     * 
     */
    POWER_UP("effects/", "powerUp.wav", 0.7),

    /**
     * 
     */
    BOMB("effects/", "bomb.wav", 0.7);

    private String path;
    private String fileName;
    private double volume;

    GameAudio(final String path, final String fileName, final double volume) {
        this.path = path;
        this.fileName = fileName;
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public String getPath() {
        return this.path;
    }

    public String getMediaPath() {
        return this.path + this.fileName;
    }
}
