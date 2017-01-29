package guitartrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Frame extends JFrame{
    private Notes notes = new Notes();
    private JLayeredPane lPane;
    private int string, fret;
    private ImageIcon tap = new ImageIcon("tap.png");
    private JLabel note = new JLabel(tap);
    private JButton noteC, noteCD, noteD, noteDE, noteE, noteF, noteFG, noteG,
            noteGA, noteA, noteAB, noteB;
    
    Frame(){
        super("GuitarTrainer");
        setBounds(100, 100, 774, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        lPane = getLayeredPane();
        
        ActionListener noteButton = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteB.getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();
                } else{
                    wrongAnswer();
                }
                randomNote();
            }
        };
        
        ImageIcon grif = new ImageIcon("grif.png");
        JLabel fretboard = new JLabel(grif);
        fretboard.setBounds(0, 0, 769, 200);
        lPane.add(fretboard, new Integer(2));
        
        noteC = new JButton("C");
        noteC.setBounds(100, 200, 70, 30);
        lPane.add(noteC, new Integer(2));
        noteC.addActionListener(noteButton);
        
        noteCD = new JButton("C#/Db");
        noteCD.setBounds(200, 200, 70, 30);
        lPane.add(noteCD, new Integer(2));
        noteCD.addActionListener(noteButton);
        
        noteD = new JButton("D");
        noteD.setBounds(300, 200, 70, 30);
        lPane.add(noteD, new Integer(2));
        noteD.addActionListener(noteButton);
        
        noteDE = new JButton("D#/Eb");
        noteDE.setBounds(400, 200, 70, 30);
        lPane.add((noteDE), new Integer(2));
        noteDE.addActionListener(noteButton);
        
        noteE = new JButton("E");
        noteE.setBounds(500, 200, 70, 30);
        lPane.add(noteE, new Integer(2));
        noteE.addActionListener(noteButton);
        
        noteF = new JButton("F");
        noteF.setBounds(600, 200, 70, 30);
        lPane.add(noteF, new Integer(2));
        noteF.addActionListener(noteButton);
        
        noteFG = new JButton("F#/Gb");
        noteFG.setBounds(100, 260, 70, 30);
        lPane.add(noteFG, new Integer(2));
        noteFG.addActionListener(noteButton);
        
        noteG = new JButton("G");
        noteG.setBounds(200, 260, 70, 30);
        lPane.add(noteG, new Integer(2));
        noteG.addActionListener(noteButton);
        
        noteGA = new JButton("G#/Ab");
        noteGA.setBounds(300, 260, 70, 30);
        lPane.add(noteGA, new Integer(2));
        noteGA.addActionListener(noteButton);
        
        noteA = new JButton("A");
        noteA.setBounds(400, 260, 70, 30);
        lPane.add(noteA, new Integer(2));
        noteA.addActionListener(noteButton);
        
        noteAB = new JButton("A#/Bb");
        noteAB.setBounds(500, 260, 70, 30);
        lPane.add(noteAB, new Integer(2));
        noteAB.addActionListener(noteButton);
        
        noteB = new JButton("B");
        noteB.setBounds(600, 260, 70, 30);
        lPane.add(noteB, new Integer(2));
        noteB.addActionListener(noteButton);
        
        JButton replay = new JButton("Relay");
        replay.setBounds(20, 520, 100, 30);
        lPane.add(replay, new Integer(2));
        replay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomNote();
            }
        });
        randomNote();
        
        JLabel points = new JLabel();
        points.setBounds(649, 520, 100, 30);
        points.setOpaque(true);
        points.setBackground(Color.gray);
        lPane.add(points, new Integer(3));
    }
    
    public void randomNote(){
        lPane.remove(note);
        lPane.revalidate();
        lPane.repaint();
        Random r = new Random(System.currentTimeMillis());
        string = -1;
        fret = -1;
        while(string < 0 || string > 5){
            string = r.nextInt() % 10;
        }
        while(fret < 0 || fret > 11){
            fret = r.nextInt() % 100;
        }
        note.setBounds(notes.getNotes()[string][fret].getX(),
                notes.getNotes()[string][fret].getY(), 15, 15);
        lPane.add(note, new Integer(3));
    }
    
    public void rightAnswer(){
        JLabel notif = new JLabel("RIGHT");
        notif.setBounds(335, 350, 100, 30);
        notif.setForeground(Color.green);
        lPane.add(notif, new Integer(2));
        //Секундный таймер
        //Стирание надписи
        //Добавление в счетчик верных ответов
    }
    
    public void wrongAnswer(){
        JLabel notif = new JLabel("WRONG");
        notif.setBounds(335, 350, 100, 30);
        notif.setForeground(Color.red);
        lPane.add(notif, new Integer(2));
        //Секундный таймер
        //Стирание надписи
        //Добавление в счетчик неверных ответов
    }
}