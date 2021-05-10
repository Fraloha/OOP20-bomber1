package bomberOne.tools.audio;

public enum GameAudio {

    /**
     * 
     */
    CLASSIC(Sounds.AUDIO, "classic.wav", 0.1),

    /**
     * 
     */
    HOME(Sounds.AUDIO, "home.wav", 0.1),

    /**
     * 
     */
    POWER_UP(Sounds.EFFECT, "powerUp.wav", 0.7),

    /**
     * 
     */
    ENEMY_HIT(Sounds.EFFECT, "enemy_death.wav", 0.7),

    /**
     * 
     */
    HITTED(Sounds.EFFECT, "hitted.wav", 0.7),

    /**
     * 
     */
    BOMB(Sounds.EFFECT, "bomb.wav", 0.7);

    private static final String AUDIO_PATH = "audio/";
    private static final String EFFECTS_PATH = "effects/";

    private Sounds type;
    private String fileName;
    private double volume;

    GameAudio(final Sounds type, final String fileName, final double volume) {
        this.type = type;
        this.fileName = fileName;
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public Sounds getType() {
        return this.type;
    }

    public String getMediaPath() {
        return this.type.equals(Sounds.AUDIO) ? GameAudio.AUDIO_PATH + this.fileName
                : GameAudio.EFFECTS_PATH + this.fileName;
    }
}
