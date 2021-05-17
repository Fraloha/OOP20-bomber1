package bomberone.tools.audio;

public enum GameSounds {

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

    /**
     * Constant path of Sounds.AUDIO.
     */
    private static final String AUDIO_PATH = "audio/";
    /**
     * Constant path of Sounds.EFFECTS.
     */
    private static final String EFFECTS_PATH = "effects/";

    private Sounds type;
    private String fileName;
    private double volume;

    GameSounds(final Sounds type, final String fileName, final double volume) {
        this.type = type;
        this.fileName = fileName;
        this.volume = volume;
    }

    /**
     * Method that return the volume set in @this GameSounds.
     * 
     * @return volume
     */
    public double getVolume() {
        return this.volume;
    }

    /**
     * Method that return Sounds.AUDIO in case @this is an audio sound else Sounds.EFFECT.
     * 
     * @return Sounds.type
     */
    public Sounds getType() {
        return this.type;
    }

    /**
     * Method that return the path of @this media.
     * 
     * @return String path
     */
    public String getMediaPath() {
        return this.type.equals(Sounds.AUDIO) ? GameSounds.AUDIO_PATH + this.fileName
                : GameSounds.EFFECTS_PATH + this.fileName;
    }
}
