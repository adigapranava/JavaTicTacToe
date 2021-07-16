package music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class musicPlayer {
    private File file;
    AudioInputStream as;
    Clip clip;

    public musicPlayer(){
        file = new File("music/music.wav");
        try {
            as = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(as);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playSong() {
        clip.start();        
    }
}
