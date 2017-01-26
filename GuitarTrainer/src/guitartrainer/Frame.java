package guitartrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Frame extends JFrame{
    
    Frame(){
        super("GuitarTrainer");
        setBounds(100, 100, 784, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLayeredPane lPane = getLayeredPane();
        
        ImageIcon grif = new ImageIcon("grif.png");
        JLabel fretboard = new JLabel(grif);
        fretboard.setBounds(0, 0, 769, 200);
        lPane.add(fretboard, new Integer(2));
        
        JButton noteC = new JButton("C");
        noteC.setBounds(100, 200, 70, 30);
        lPane.add(noteC, new Integer(2));
        
        JButton noteCD = new JButton("C#/Db");
        noteCD.setBounds(200, 200, 70, 30);
        lPane.add(noteCD, new Integer(2));
        
        JButton noteD = new JButton("D");
        noteD.setBounds(300, 200, 70, 30);
        lPane.add(noteD, new Integer(2));
        
        JButton noteDE = new JButton("D#/Eb");
        noteDE.setBounds(400, 200, 70, 30);
        lPane.add(noteDE, new Integer(2));
        
        JButton noteE = new JButton("E");
        noteE.setBounds(500, 200, 70, 30);
        lPane.add(noteE, new Integer(2));
        
        JButton noteF = new JButton("F");
        noteF.setBounds(600, 200, 70, 30);
        lPane.add(noteF, new Integer(2));
        
        JButton noteFG = new JButton("F#/Gb");
        noteFG.setBounds(100, 260, 70, 30);
        lPane.add(noteFG, new Integer(2));
        
        JButton noteG = new JButton("G");
        noteG.setBounds(200, 260, 70, 30);
        lPane.add(noteG, new Integer(2));
        
        JButton noteGA = new JButton("G#/Ab");
        noteGA.setBounds(300, 260, 70, 30);
        lPane.add(noteGA, new Integer(2));
        
        JButton noteA = new JButton("A");
        noteA.setBounds(400, 260, 70, 30);
        lPane.add(noteA, new Integer(2));
        
        JButton noteAB = new JButton("A#/Bb");
        noteAB.setBounds(500, 260, 70, 30);
        lPane.add(noteAB, new Integer(2));
        
        JButton noteB = new JButton("B");
        noteB.setBounds(600, 260, 70, 30);
        lPane.add(noteB, new Integer(2));
        
        JButton replay = new JButton("Replay");
        replay.setBounds(20, 520, 100, 30);
        lPane.add(replay, new Integer(2));
        
        Notes notes = new Notes();
        randomNote(notes.notes, lPane);
    }
    
    public void randomNote(Note notes[][], JLayeredPane lP){
        Random r = new Random(System.currentTimeMillis());
        int i = -1, j = -1;
        while(i < 0 || i > 5){
            i = r.nextInt() % 10;
        }
        while(j < 0 || j > 11){
            j = r.nextInt() % 100;
        }
        ImageIcon tap = new ImageIcon("tap.png");
        JLabel note = new JLabel(tap);
        note.setBounds(i, j, 7, 5);
        lP.add(note, new Integer(3));
    }
}