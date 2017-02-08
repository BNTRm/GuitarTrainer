package guitartrainer;

import java.io.File;

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
        String soundFN = "sound" + i + j + ".wav";
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
}
