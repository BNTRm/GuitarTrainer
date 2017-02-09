package guitartrainer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Frame extends JFrame{
    private Notes notes = new Notes();
    private JLayeredPane lPane;
    private int string, fret, right, wrong, goal = -1;
    private ImageIcon tap = new ImageIcon("tap.png");
    private JLabel points = new JLabel();
    private JButton play,  note = new JButton();
    private MyButton noteButtons[] = {
        new MyButton(7), new MyButton(8), new MyButton(9),
        new MyButton(10), new MyButton(11), new MyButton(0),
        new MyButton(1), new MyButton(2), new MyButton(3),
        new MyButton(4), new MyButton(5), new MyButton(6)};
    private JMenuBar menuBar;
    private JMenu goalMenu, timerMenu;
    
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
        
        setButtons();
        
        stopTrain();
        
        note.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notes.playSound(string, fret);}});
        
        points.setFont(new Font(null, Font.PLAIN, 20));
        points.setBounds(649, 520, 100, 30);
        lPane.add(points, new Integer(3));
        createPoints();
    }
    
    public void setButtons(){
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
            noteButtons[i].setBackground(Color.white);
        }
        addActionListeners();
        play = new JButton("Play");
        play.setBounds(20, 520, 100, 30);
        lPane.add(play, new Integer(2));
        play.setBackground(Color.LIGHT_GRAY);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(((JButton)e.getSource()).getText() == "Play"){
                    right = wrong = 0;
                    createPoints();
                    startTrain();
                    randomNote();
                } else if(((JButton)e.getSource()).getText() == "Stop"){
                    stopTrain();
                }
            }
        });
        
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        addGoalMenu();
        //addTimerMenu();
        
    }
    /*
    public void addTimerMenu(){
        timerMenu = new JMenu("Timer");
        JMenuItem noneTimer = new JMenuItem("None");
        JMenuItem timer15sec = new JMenuItem("15 seconds");
        JMenuItem timer30sec = new JMenuItem("30 seconds");
        JMenuItem timer45sec = new JMenuItem("45 seconds");
        JMenuItem timer1min = new JMenuItem("1 minute");
        JMenuItem timer2min = new JMenuItem("2 minute");
        timerMenu.add(timer15sec);
        timerMenu.add(timer30sec);
        timerMenu.add(timer45sec);
        timerMenu.add(timer1min);
        timerMenu.add(timer2min);
        menuBar.add(timerMenu);
    }
    */
    public void addGoalMenu(){
        goalMenu = new JMenu("Goal");
        JMenuItem noneGoal = new JMenuItem("None");
        JMenuItem goal10 = new JMenuItem("10");
        JMenuItem goal25 = new JMenuItem("25");
        JMenuItem goal50 = new JMenuItem("50");
        JMenuItem goal75 = new JMenuItem("75");
        JMenuItem goal100 = new JMenuItem("100");
        goalMenu.add(noneGoal);
        goalMenu.add(goal10);
        goalMenu.add(goal25);
        goalMenu.add(goal50);
        goalMenu.add(goal75);
        goalMenu.add(goal100);
        noneGoal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = -1;
                createPoints();}});
        goal10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = 10;
                createPoints();}});
        goal25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = 25;
                createPoints();}});
        goal50.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = 50;
                createPoints();}});
        goal75.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = 75;
                createPoints();}});
        goal100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goal = 100;
                createPoints();}});
        
        menuBar.add(goalMenu);
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
        notes.playSound(string, fret);
        note.setBackground(Color.cyan);
        if((wrong + right) == goal){
            stopTrain();
        }
    }
    
    public void rightAnswer() {
        ImageIcon Rtap = new ImageIcon("Rtap.png");
        note.setBackground(Color.green);
        answerTimer(250);
        right += 1;
        createPoints();
    }
    
    public void wrongAnswer() {
        ImageIcon Wtap = new ImageIcon("Wtap.png");
        note.setBackground(Color.red);
        answerTimer(750);
        wrong += 1;
        createPoints();
    }
    
    public void answerTimer(int time){
        buttonsOff();
        new Timer().schedule(
            new TimerTask() {
                public void run() {
                    buttonsOn();
                    randomNote();
                }
            }, time );
    }
    
    public void createPoints(){
        String pnts;
        if(goal == -1){
            pnts = right + "/" + wrong;
        } else{
            pnts = right + "/" + wrong + "/" + goal;
        }
        points.setText(pnts);
        points.repaint();
    }
        
    public void stopTrain(){
        buttonsOff();
        play.setText("Play");
        lPane.remove(note);
        lPane.repaint();
        goalMenu.setEnabled(true);
    }
    
    public void startTrain(){
        buttonsOn();
        play.setText("Stop");
        goalMenu.setEnabled(false);
        
    }
    
    public void buttonsOn(){
        for(int i = 0; i < 12; i ++){
            noteButtons[i].setEnabled(true);
        }
    }
    
    public void buttonsOff(){
        for(int i = 0; i < 12; i ++){
            noteButtons[i].setEnabled(false);
        }
    }
    
    public void addActionListeners(){
        for(int i = 0; i < 12; i ++){
            noteButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(((MyButton)e.getSource()).getId() == notes.getNotes()[string][fret].getId()){
                        rightAnswer();
                        ((MyButton)e.getSource()).setBackground(Color.green);
                        new Timer().schedule(
                            new TimerTask() {
                                public void run() {
                                    ((MyButton)e.getSource()).setBackground(Color.WHITE);
                                }
                            }, 250 );
                    } else{
                        wrongAnswer();
                        ((MyButton)e.getSource()).setBackground(Color.red);
                        new Timer().schedule(
                            new TimerTask() {
                                public void run() {
                                    ((MyButton)e.getSource()).setBackground(Color.WHITE);
                                }
                            }, 750 );
                    }
                }
            });
        }
    }
}