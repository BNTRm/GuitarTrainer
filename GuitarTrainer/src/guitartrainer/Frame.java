package guitartrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;
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
    private JLabel notif = new JLabel(), points = new JLabel(), note = new JLabel(tap);
    private JButton play, noteButtons[] = {
        new JButton("C"), new JButton("C#/Db"), new JButton("D"),
        new JButton("D#/Eb"), new JButton("E"), new JButton("F"),
        new JButton("F#/Gb"), new JButton("G"), new JButton("G#/Ab"),
        new JButton("A"), new JButton("A#/Bb"), new JButton("B")};
    
    Frame(){
        super("GuitarTrainer v0.1");
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
        for(int i = 0; i < 12; i ++){
            lPane.add(noteButtons[i], new Integer(2));
        }
        addActionListeners();
        play = new JButton("Play");
        play.setBounds(20, 520, 100, 30);
        lPane.add(play, new Integer(2));
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                right = wrong = 0;
                createPoints();
                startTrain();
                randomNote();
            }
        });
        stopTrain();
        Font font = new Font(null, Font.PLAIN, 20);
        notif.setFont(font);
        points.setFont(font);
        points.setBounds(649, 520, 100, 30);
        lPane.add(points, new Integer(3));
        createPoints();
    }
    
    public void randomNote(){
        lPane.remove(note);
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
        if((wrong + right) == 20){
            stopTrain();
        }
    }
    
    public void rightAnswer() {
        ImageIcon Rtap = new ImageIcon("Rtap.png");
        note.setIcon(Rtap);
        new java.util.Timer().schedule(
            new TimerTask() {
                public void run() {
                    note.setIcon(tap);
                    randomNote();
                }
            }, 300 );
        right += 1;
        createPoints();
    }
    
    public void wrongAnswer() {
        ImageIcon Wtap = new ImageIcon("Wtap.png");
        note.setIcon(Wtap);
        new java.util.Timer().schedule(
            new TimerTask() {
                public void run() {
                    note.setIcon(tap);
                    randomNote();
                }
            }, 300 );
        wrong += 1;
        createPoints();
    }
    
    public void createPoints(){
        String pnts = right + "/" + wrong + "/20";
        points.setText(pnts);
        points.repaint();
    }
        
    public void stopTrain(){
        for(int i = 0; i < 12; i ++){
            noteButtons[i].setEnabled(false);
        }
        play.setText("Play");
        lPane.remove(note);
        lPane.repaint();
    }
    
    public void startTrain(){
        for(int i = 0; i < 12; i ++){
            noteButtons[i].setEnabled(true);
        }
        play.setText("Replay");
    }
    
    public void addActionListeners(){
        noteButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[0].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[1].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[2].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[3].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[4].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[5].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[6].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[7].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[8].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[9].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[10].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
        noteButtons[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(noteButtons[11].getText() == notes.getNotes()[string][fret].getName()){
                    rightAnswer();} else{
                    wrongAnswer();}}});
    }
}