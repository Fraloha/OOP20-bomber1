package bomberone.tools.audio;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public final class SoundsHandler {

    private Map<GameSounds, Media> cacheAudio;
    private Map<GameSounds, Media> cacheEffects;
    private MediaPlayer playerAudio;
    private MediaPlayer playerEffects;

    private SoundsHandler() {
        this.cacheAudio = new EnumMap<>(GameSounds.class);
        this.cacheEffects = new EnumMap<>(GameSounds.class);
        Arrays.stream(GameSounds.values()).forEach(values -> {
            if (values.getType().equals(Sounds.EFFECT)) {
                try {
                    final Media audio = new Media(
                            ClassLoader.getSystemResource(values.getMediaPath()).toURI().toString());
                    this.cacheEffects.put(values, audio);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    final Media audio = new Media(
                            ClassLoader.getSystemResource(values.getMediaPath()).toURI().toString());
                    this.cacheAudio.put(values, audio);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        playerAudio = new MediaPlayer(this.cacheAudio.get(GameSounds.HOME));
    }

    /**
     * SINGLETON pattern.
     */
    private static class LazyHolder {
        private static final SoundsHandler SINGLETON = new SoundsHandler();
    }

    /**
     * Create SINGLETON on the first call.
     * 
     * @return SoundsHandler
     */
    public static SoundsHandler getInstance() {
        return LazyHolder.SINGLETON;
    }

    /**
     * Static method that starts the GameSounds input on the correct player,
     * playerEffect in case of GameSounds effect or playerAudio in case of
     * GameSounds audio.
     * 
     * @param type
     */
    public synchronized void start(final GameSounds type) {
        if (type.getType().equals(Sounds.EFFECT)) {
            this.playerEffects = new MediaPlayer(this.cacheEffects.get(type));
            this.playerEffects.setVolume(type.getVolume());
            this.playerEffects.play();
            this.playerEffects.setOnEndOfMedia(this.playerEffects::dispose);
        } else {
            if (!isPlaying()) {
                if (!this.playerAudio.getMedia().equals(this.cacheAudio.get(type))) {
                    this.playerAudio.dispose();
                    this.playerAudio = new MediaPlayer(this.cacheAudio.get(type));
                }
                this.playerAudio.setVolume(type.getVolume());
                this.playerAudio.play();
                this.playerAudio.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        SoundsHandler.getInstance().replayAudio();
                    }
                });
            }
        }
    }

    /**
     * Method that return true if playerAudio is already playing.
     * 
     * @return boolean
     */
    public boolean isPlaying() {
        return this.playerAudio.getStatus().equals(Status.PLAYING);
    }

    /**
     * Method that restart the playerAudio.
     */
    public synchronized void replayAudio() {
        this.playerAudio.stop();
        this.playerAudio.play();
    }

    /**
     * Method that stop the last audio played and free all resources associated with
     * playerAudio.
     */
    public synchronized void stopAudio() {
        this.playerAudio.stop();
        this.playerAudio.dispose();
    }
}
