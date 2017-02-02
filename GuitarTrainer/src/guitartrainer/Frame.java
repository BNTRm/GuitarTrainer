package guitartrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    private int string, fret, right, wrong;
    private ImageIcon tap = new ImageIcon("tap.png");
    private JLabel note = new JLabel(tap), points;
    private JButton noteButtons[] = {
        new JButton("C"), new JButton("C#/Db"), new JButton("D"),
        new JButton("D#/Eb"), new JButton("E"), new JButton("F"),
        new JButton("F#/Gb"), new JButton("G"), new JButton("G#/Ab"),
        new JButton("A"), new JButton("A#/Bb"), new JButton("B")};
    
    Frame(){
        super("GuitarTrainer");
        setBounds(100, 100, 774, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        lPane = getLayeredPane();
        
        ImageIcon grif = new ImageIcon("grif.png");
        JLabel fretboard = new JLabel(grif);
        fretboard.setBounds(0, 0, 769, 200);
        lPane.add(fretboard, new Integer(2));
        
        noteButtons[0].setBounds(100, 200, 70, 30);
        noteButtons[1].setBounds(200, 200, 70, 30);
        noteButtons[2].setBounds(300, 200, 70, 30);
        noteButtons[3].setBounds(400, 200, 70, 30);
        noteButtons[4].setBounds(500, 200, 70, 30);
        noteButtons[5].setBounds(600, 200, 70, 30);
        noteButtons[6].setBounds(100, 260, 70, 30);
        noteButtons[7].setBounds(200, 260, 70, 30);
        noteButtons[8].setBounds(300, 260, 70, 30);
        noteButtons[9].setBounds(400, 260, 70, 30);
        noteButtons[10].setBounds(500, 260, 70, 30);
        noteButtons[11].setBounds(600, 260, 70, 30);
        randomNote();
        for(int i = 0; i < 12; i ++){
            lPane.add(noteButtons[i], new Integer(2));
        }
        addALers();
        
        JButton replay = new JButton("Relay");
        replay.setBounds(20, 520, 100, 30);
        lPane.add(replay, new Integer(2));
        replay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                right = 0;
                wrong = 0;
                randomNote();
            }
        });
        randomNote();
        Font font = new Font(null, Font.PLAIN, 20);
        createPoints();
        points.setFont(font);
        points.setBounds(649, 520, 100, 30);
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
    
    public void rightAnswer() {
        JLabel notif = new JLabel("RIGHT");
        notif.setBounds(335, 350, 100, 30);
        notif.setForeground(Color.green);
        lPane.add(notif, new Integer(2));
        //задержка 1 сек
        //стирание надписи
        right ++;
        createPoints();
    }
    
    public void wrongAnswer() {
        JLabel notif = new JLabel("WRONG");
        notif.setBounds(335, 350, 100, 30);
        notif.setForeground(Color.red);
        lPane.add(notif, new Integer(2));
        //задержка 1 сек
        //стирание надписи
        wrong ++;
        createPoints();
    }
    
    public void createPoints(){
        String pnts = right + "/" + wrong + "/20";
        points.setText(pnts);
    }
    
    public void addALers(){
        noteButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[0].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[1].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[2].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[3].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[4].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[5].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[6].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[7].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[8].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[9].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[10].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
        noteButtons[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[11].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}
                randomNote();}});
    }
}