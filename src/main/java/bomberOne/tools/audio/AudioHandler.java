package bomberOne.tools.audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class SoundsHandler {
    private static AudioInputStream audio;
    private static Clip clip;

    public static void start(final GameAudio type) {
        try {
            clip = AudioSystem.getClip();
            audio = type.getAudio();
            clip.open(audio);
            clip.start();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void startLoop(final GameAudio type, final int loop) {
        try {
            clip = AudioSystem.getClip();
            audio = type.getAudio();
            clip.open(audio);
            clip.loop(loop);
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void stop() {
        clip.stop();
    }
}
