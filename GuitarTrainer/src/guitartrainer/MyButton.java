package guitartrainer;

import javax.swing.JButton;

public class MyButton extends JButton {
    private int id;
    
    public MyButton(int newId){
        id = newId;
        switch(id){
            case 0:  {this.setText("F"); break;}
            case 1:  {this.setText("F#/Gb"); break;}
            case 2:  {this.setText("G"); break;}
            case 3:  {this.setText("G#/Ab"); break;}
            case 4:  {this.setText("A"); break;}
            case 5:  {this.setText("A#/Bb"); break;}
            case 6:  {this.setText("B"); break;}
            case 7:  {this.setText("C"); break;}
            case 8:  {this.setText("C#/Db"); break;}
            case 9:  {this.setText("D"); break;}
            case 10: {this.setText("D#/Eb"); break;}
            case 11: {this.setText("E"); break;}
        }
    }
    
    public int getId(){
        return id;
    }
}
