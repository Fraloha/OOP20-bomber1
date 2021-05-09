package bomberOne.tools.audio;

public enum GameEffects {
    /**
     * 
     */
    POWER_UP("powerUp.wav", 1.0),

    /**
     * 
     */
    BOMB("bomb.wav", 1.0);

    private static final String RES_PATH = "audio/";

    private String fileName;
    private double volume;

    GameEffects(final String fileName, final double volume) {
        this.fileName = fileName;
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public String getMediaPath() {
        return RES_PATH + this.fileName;
    }
}
