package bomberOne.tools.audio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class AudioHandler {

    private static final Map<GameAudio, Media> CACHE_AUDIO;
    private static final Map<GameAudio, Media> CACHE_EFFECTS;
    private static MediaPlayer playerAudio;
    private static MediaPlayer playerEffects;

    static {
        CACHE_AUDIO = new EnumMap<>(GameAudio.class);
        CACHE_EFFECTS = new EnumMap<>(GameAudio.class);
        Arrays.stream(GameAudio.values()).forEach(values -> {
            if(values.getPath().equals("effects/")) {
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

    private AudioHandler() {

    }

    public static synchronized void start(final GameAudio type) {
        if(type.getPath().equals("effects/")) {
            playerEffects = new MediaPlayer(CACHE_EFFECTS.get(type));
            playerEffects.setVolume(type.getVolume());
            playerEffects.play();
        } else {
            playerAudio = new MediaPlayer(CACHE_AUDIO.get(type));
            playerAudio.setVolume(type.getVolume());
            playerAudio.play();
        }
    }

    public static synchronized void stopAudio() {
        playerAudio.stop();
    }
}
