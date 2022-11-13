/*
 * Author: Riley Chai
 * Class: ICS4U
 * Program: Recursion Assignment Part B GUI
 */

/**
 *
 * @author 335480661
 */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Part 8
public class SoundPlayer {

    public void play(final String fileName) {
        
        //Note: use .wav files
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
                    clip.open(inputStream);
                    clip.start();//Start sound playing.
                    Thread.sleep(clip.getMicrosecondLength() / 1000);//Converts microSeconds to milliSeconds.
                } catch (Exception e) {
                    System.out.println("Play sound error: " + e.getMessage() + " for " + fileName);
                }               
            }          
        }).start();
    }
}
