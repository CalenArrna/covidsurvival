package covidsurvival;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.IOException;

public class Sound {
    Clip clip;

    {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static final String bgm = "res/bgm.wav";
    public static final String tvStatic = "res/tvstatic.wav";
    public static final String tvStatic2 = "res/tvstatic2.wav";
    public static final String gyorfi = "res/gyorfi.wav";
    public static final String catmeow = "res/catmeow.wav";
    public static final String test = "res/test.wav";
    public static final String door = "res/doorclosing.wav";

    public static AudioInputStream openSound(String audioFileName) {
        try {
            return AudioSystem.getAudioInputStream(new File(audioFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void playSound(AudioInputStream audio) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();

            if (audio != null) {
                clip.open(audio);

                clip.start();
            } else {
                System.out.println("Input stream not valid");
            }
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public  void playBGMSound(AudioInputStream audio) {
        if (audio != null) {
            try {
                clip.open(audio);
            } catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stopLoop() {
        clip.stop();
        clip.close();
    }
}

