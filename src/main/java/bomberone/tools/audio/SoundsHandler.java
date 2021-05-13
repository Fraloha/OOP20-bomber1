package bomberone.tools.audio;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public final class SoundsHandler {

    private static final Map<GameSounds, Media> CACHE_AUDIO;
    private static final Map<GameSounds, Media> CACHE_EFFECTS;
    private static MediaPlayer playerAudio;
    private static MediaPlayer playerEffects;

    static {
        CACHE_AUDIO = new EnumMap<>(GameSounds.class);
        CACHE_EFFECTS = new EnumMap<>(GameSounds.class);
        Arrays.stream(GameSounds.values()).forEach(values -> {
            if (values.getType().equals(Sounds.EFFECT)) {
                try {
                    final Media audio = new Media(ClassLoader.getSystemResource(values.getMediaPath()).toURI().toString());
                    CACHE_EFFECTS.put(values, audio);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    final Media audio = new Media(ClassLoader.getSystemResource(values.getMediaPath()).toURI().toString());
                    CACHE_AUDIO.put(values, audio);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private SoundsHandler() {

    }

    /**
     * Static method that starts the GameSounds input on the correct player,
     * playerEffect in case of GameSounds effect or playerAudio in case of
     * GameSounds audio.
     * 
     * @param type
     */
    public static synchronized void start(final GameSounds type) {
        if (type.getType().equals(Sounds.EFFECT)) {
            playerEffects = new MediaPlayer(CACHE_EFFECTS.get(type));
            playerEffects.setVolume(type.getVolume());
            playerEffects.play();
            playerEffects.setOnEndOfMedia(playerEffects::dispose);
        } else {
            playerAudio = new MediaPlayer(CACHE_AUDIO.get(type));
            playerAudio.setVolume(type.getVolume());
            playerAudio.play();
            playerAudio.setCycleCount(10);
        }
    }

    /**
     * Static method that stop the last audio played.
     */
    public static synchronized void stopAudio() {
        playerAudio.stop();
    }
}
