package guitartrainer;

import javax.swing.JFrame;

public class Frame extends JFrame{
    
    Frame(){
        super("GuitarTrainer");
        setBounds(100, 100, 768, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
}