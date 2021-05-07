package bomberOne.tools.audio;

import javax.sound.sampled.AudioInputStream;

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
    BOMB("bomb.wav");

    private static final String RES_PATH = "audio/";

    private String fileName;
    private AudioInputStream audio;

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

}
