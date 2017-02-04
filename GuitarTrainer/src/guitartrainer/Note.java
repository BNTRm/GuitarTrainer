package guitartrainer;

import java.io.File;

public class Note {
    private String name;
    private int x, y;
    private File soundFile;
    
    public Note(){
        name = "";
    }
    
    public Note(String nName){
        name = nName;
    }
    
    public void setSound(int i, int j){
        String soundFN = "sound" + i + j;
        soundFile = new File(soundFN);
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setX(int newX){
        x = newX;
    }
    
    public void setY(int newY){
        y = newY;
    }
    
    public String getName(){
        return name;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
