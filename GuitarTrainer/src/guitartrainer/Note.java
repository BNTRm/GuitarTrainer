package guitartrainer;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Note {
    private int x, y, id;
    private File soundFile;
    
    public Note(){
        id = -1;
    }
    
    public Note(int newId){
        id = newId;
    }
    
    public void setSound(int i, int j){
        String soundFN = "sounds\\sound" + i + "_" + j + ".wav";
        soundFile = new File(soundFN);
    }
    
    public File getSoundFile(){
        return soundFile;
    }
    
    public void setName(int newId){
        id = newId;
    }
    
    public void setX(int newX){
        x = newX;
    }
    
    public void setY(int newY){
        y = newY;
    }
    
    public int getId(){
        return id;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void playSound(){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        }
    }
}
