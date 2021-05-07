package bomberOne.tools.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public enum GameAudio {
    /**
     * 
     */
    POWER_UP("powerUp.wav"),

    /**
     * 
     */
    CLASSIC("classic.wav"),

    /**
     * 
     */
    HOME("home.wav"),

    /**
     * 
     */
    BOMB("bomb.wav");

    private static final String RES_PATH = "audio/";

    private String fileName;
    private AudioInputStream audio;
    private static Clip clip;

    GameAudio(final String fileName) {
        this.fileName = fileName;
    }

    public void setAudio(final AudioInputStream audio) {
        this.audio = audio;
    }

    public AudioInputStream getAudio() {
        return this.audio;
    }

    public String getAudioPath() {
        return RES_PATH + this.fileName;
    }
    
    public static Clip getClip() {
        return clip;
    }
}
