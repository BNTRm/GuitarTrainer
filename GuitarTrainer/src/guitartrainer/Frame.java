package guitartrainer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame{
    
    Frame(){
        super("GuitarTrainer");
        setBounds(100, 100, 768, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        ImageIcon guitar = new ImageIcon("guitar.png");
        JLabel wallpaper = new JLabel(guitar);
        getContentPane().add(wallpaper);
        wallpaper.setBounds(0, 0, 768, 600);
        setResizable(false);
        */
        ImageIcon grif = new ImageIcon("grif.png");
        JLabel fretboard = new JLabel(grif);
        getContentPane().setLayout(null);
        getContentPane().add(fretboard);
        fretboard.setBounds(0, 0, 768, 200);
        
        JButton noteC = new JButton("C");
        getContentPane().add(noteC);
        noteC.setBounds(100, 200, 70, 30);
        
        JButton noteCD = new JButton("C#/Db");
        getContentPane().add(noteCD);
        noteCD.setBounds(200, 200, 70, 30);
        
        JButton noteD = new JButton("D");
        getContentPane().add(noteD);
        noteD.setBounds(300, 200, 70, 30);
        
        JButton noteDE = new JButton("D#/Eb");
        getContentPane().add(noteDE);
        noteDE.setBounds(400, 200, 70, 30);
        
        JButton noteE = new JButton("E");
        getContentPane().add(noteE);
        noteE.setBounds(500, 200, 70, 30);
        
        JButton noteF = new JButton("F");
        getContentPane().add(noteF);
        noteF.setBounds(600, 200, 70, 30);
        
        JButton noteFG = new JButton("F#/Gb");
        getContentPane().add(noteFG);
        noteFG.setBounds(100, 260, 70, 30);
        
        JButton noteG = new JButton("G");
        getContentPane().add(noteG);
        noteG.setBounds(200, 260, 70, 30);
        
        JButton noteGA = new JButton("G#/Ab");
        getContentPane().add(noteGA);
        noteGA.setBounds(300, 260, 70, 30);
        
        JButton noteA = new JButton("A");
        getContentPane().add(noteA);
        noteA.setBounds(400, 260, 70, 30);
        
        JButton noteAB = new JButton("A#/Bb");
        getContentPane().add(noteAB);
        noteAB.setBounds(500, 260, 70, 30);
        
        JButton noteB = new JButton("B");
        getContentPane().add(noteB);
        noteB.setBounds(600, 260, 70, 30);
        
        JButton replay = new JButton("Replay");
        getContentPane().add(replay);
        replay.setBounds(20, 530, 100, 30);
    }
}