package guitartrainer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.Timer;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;

public class Frame extends JFrame{
    
    private Notes notes = new Notes();
    private JLayeredPane lPane;
    private int string, fret, right, wrong, goal = -1;
    private JLabel points = new JLabel();
    private JButton play,  note = new JButton();
    private MyButton noteBtns[] = {
        new MyButton(7), new MyButton(8), new MyButton(9),
        new MyButton(10), new MyButton(11), new MyButton(0),
        new MyButton(1), new MyButton(2), new MyButton(3),
        new MyButton(4), new MyButton(5), new MyButton(6)};
    private JMenuBar menuBar;
    private JMenu goalMenu;
    private TimerLabel timerLabel = new TimerLabel();
    
    public Frame(){
        
        super("GuitarTrainer v0.1");
        setBounds(300, 100, 774, 600);
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
        points.setBounds(650, 520, 100, 30);
        lPane.add(points, new Integer(3));
        createPoints();
        
        timerLabel.setFont(new Font(timerLabel.getFont().getFontName(), timerLabel.getFont().getStyle(), 24));
        timerLabel.setBounds(355, 525, 60, 20);
        lPane.add(timerLabel, new Integer(2));
    }
    
    private void setButtons(){
        
        noteBtns[0].setBounds(100, 200, 70, 30);
        noteBtns[1].setBounds(200, 200, 70, 30);
        noteBtns[2].setBounds(300, 200, 70, 30);
        noteBtns[3].setBounds(400, 200, 70, 30);
        noteBtns[4].setBounds(500, 200, 70, 30);
        noteBtns[5].setBounds(600, 200, 70, 30);
        noteBtns[6].setBounds(100, 260, 70, 30);
        noteBtns[7].setBounds(200, 260, 70, 30);
        noteBtns[8].setBounds(300, 260, 70, 30);
        noteBtns[9].setBounds(400, 260, 70, 30);
        noteBtns[10].setBounds(500, 260, 70, 30);
        noteBtns[11].setBounds(600, 260, 70, 30);
        for(int i = 0; i < 12; i ++){
            lPane.add(noteBtns[i], new Integer(2));
            noteBtns[i].setBackground(new Color(240, 240, 255));
        }
        addActionListeners();
        play = new JButton("Play");
        play.setBounds(20, 520, 100, 30);
        lPane.add(play, new Integer(2));
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
        menuBar.setBackground(new Color(225, 225, 225));
        
        addGoalMenu();
        //addTimerMenu();
        
    }
    
    private void addGoalMenu(){
        
        goalMenu = new JMenu("Goal");
        JRadioButtonMenuItem noneGoal = new JRadioButtonMenuItem("None");
        JRadioButtonMenuItem goal10 = new JRadioButtonMenuItem("10");
        JRadioButtonMenuItem goal25 = new JRadioButtonMenuItem("25");
        JRadioButtonMenuItem goal50 = new JRadioButtonMenuItem("50");
        JRadioButtonMenuItem goal75 = new JRadioButtonMenuItem("75");
        JRadioButtonMenuItem goal100 = new JRadioButtonMenuItem("100");
        ButtonGroup bg = new ButtonGroup();
        bg.add(noneGoal);
        bg.add(goal10);
        bg.add(goal25);
        bg.add(goal50);
        bg.add(goal75);
        bg.add(goal100);
        goalMenu.add(noneGoal);
        goalMenu.add(goal10);
        goalMenu.add(goal25);
        goalMenu.add(goal50);
        goalMenu.add(goal75);
        goalMenu.add(goal100);
        bg.setSelected(noneGoal.getModel(), true);
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
        if((wrong + right) == goal){
            stopTrain();
        }
        else{
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
            note.setBackground(Color.WHITE);
        }
    }
    
    public void rightAnswer() {
        
        note.setBackground(new Color(120, 255, 120));
        answerTimer(250);
        right += 1;
        createPoints();
    }
    
    public void wrongAnswer() {
        
        note.setBackground(new Color(255, 120, 120));
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
            pnts = right + " | " + wrong;
        } else{
            pnts = right + " | " + wrong + " | " + goal;
        }
        points.setText(pnts);
        points.repaint();
    }
        
    public void stopTrain(){
        
        timerLabel.stopTimer();
        buttonsOff();
        play.setText("Play");
        play.setBackground(new Color(230, 255, 230));
        lPane.remove(note);
        lPane.repaint();
        goalMenu.setEnabled(true);
    }
    
    public void startTrain(){
        
        timerLabel.restartTimer();
        buttonsOn();
        play.setText("Stop");
        play.setBackground(new Color(255, 230, 230));
        goalMenu.setEnabled(false);
        
    }
    
    public void buttonsOn(){
        
        for(int i = 0; i < 12; i ++){
            noteBtns[i].setEnabled(true);
        }
    }
    
    public void buttonsOff(){
        
        for(int i = 0; i < 12; i ++){
            noteBtns[i].setEnabled(false);
        }
    }
    
    public void addActionListeners(){
        
        for(int i = 0; i < 12; i ++){
            noteBtns[i].addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    
                    final MyButton b = (MyButton)e.getSource();
                    if(b.getId() == notes.getNotes()[string][fret].getId()){
                        rightAnswer();
                        b.setBackground(new Color(120, 255, 120));
                        new Timer().schedule(
                            new TimerTask() {
                                
                                public void run() {
                                    
                                    b.setBackground(new Color(240, 240, 255));
                                }
                            }, 250 );
                    } else{
                        wrongAnswer();
                        b.setBackground(new Color(255, 120, 120));
                        new Timer().schedule(
                            new TimerTask() {
                                
                                public void run() {
                                    
                                    b.setBackground(new Color(240, 240, 255));
                                }
                            }, 750 );
                    }
                }
            });
        }
    }
}