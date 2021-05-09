package bomberOne.tools.audio;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class EffectsHandler {
    private static final Map<GameEffects, Media> CACHE;
    private static MediaPlayer player;

    static {
        CACHE = new EnumMap<>(GameEffects.class);
        Arrays.stream(GameEffects.values()).forEach(values -> {
            try {
                final Media audio = new Media(ClassLoader.getSystemResource(values.getMediaPath()).toURI().toString());
                CACHE.put(values, audio);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

    private EffectsHandler() {

    }

    public static synchronized void start(final GameEffects type) {
        player = new MediaPlayer(CACHE.get(type));
        player.setVolume(type.getVolume());
        player.play();
    }
}
