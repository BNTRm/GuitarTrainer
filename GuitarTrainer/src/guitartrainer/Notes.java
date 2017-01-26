package guitartrainer;

public class Notes {
    public Note[][] notes = new Note[6][12];
    
    public Notes(){
        notes[0][0].setName("F");
        notes[0][1].setName("F#/Gb");
        notes[0][2].setName("G");
        notes[0][3].setName("G#/Ab");
        notes[0][4].setName("A");
        notes[0][5].setName("A#/Bb");
        notes[0][6].setName("B");
        notes[0][7].setName("C");
        notes[0][8].setName("C#/Db");
        notes[0][9].setName("D");
        notes[0][10].setName("D#/Eb");
        notes[0][11].setName("E");
        notes[1][0].setName("C");
        notes[1][1].setName("C#/Db");
        notes[1][2].setName("D");
        notes[1][3].setName("D#/Eb");
        notes[1][4].setName("E");
        notes[1][5].setName("F");
        notes[1][6].setName("F#/Gb");
        notes[1][7].setName("G");
        notes[1][8].setName("G#/Ab");
        notes[1][9].setName("A");
        notes[1][10].setName("A#/Bb");
        notes[1][11].setName("B");
        notes[2][0].setName("G#/Ab");
        notes[2][1].setName("A");
        notes[2][2].setName("A#/Bb");
        notes[2][3].setName("B");
        notes[2][4].setName("C");
        notes[2][5].setName("C#/Db");
        notes[2][6].setName("D");
        notes[2][7].setName("D#/Eb");
        notes[2][8].setName("E");
        notes[2][9].setName("E#/Fb");
        notes[2][10].setName("F");
        notes[2][11].setName("G");
        notes[3][0].setName("D#/Eb");
        notes[3][1].setName("E");
        notes[3][2].setName("F");
        notes[3][3].setName("F#/Gb");
        notes[3][4].setName("G");
        notes[3][5].setName("G#/Ab"); 
        notes[3][6].setName("A");
        notes[3][7].setName("A#/Bb");
        notes[3][8].setName("B");
        notes[3][9].setName("C");
        notes[3][10].setName("C#/Db");
        notes[3][11].setName("D");
        notes[4][0].setName("A#/Bb");
        notes[4][1].setName("B");
        notes[4][2].setName("C");
        notes[4][3].setName("C#/Db"); 
        notes[4][4].setName("D");
        notes[4][5].setName("D#/Eb");
        notes[4][6].setName("E");
        notes[4][7].setName("F");
        notes[4][8].setName("F#/Gb");
        notes[4][9].setName("G");
        notes[4][10].setName("G#/Ab");
        notes[4][11].setName("A");
        notes[5][0].setName("F");
        notes[5][1].setName("F#/Gb");
        notes[5][2].setName("G");
        notes[5][3].setName("G#/Ab");
        notes[5][4].setName("A");
        notes[5][5].setName("A#/Bb");
        notes[5][6].setName("B");
        notes[5][7].setName("C");
        notes[5][8].setName("C#/Db");
        notes[5][9].setName("D");
        notes[5][10].setName("D#/Eb");
        notes[5][11].setName("E");
        
        for(int i = 0; i < 6; i ++){
            for(int j = 0; j < 12; j ++){
                switch(i){
                    case 0: {notes[i][j].setY(76); break;}
                    case 1: {notes[i][j].setY(94); break;}
                    case 2: {notes[i][j].setY(114); break;}
                    case 3: {notes[i][j].setY(132); break;}
                    case 4: {notes[i][j].setY(151); break;}
                    case 5: {notes[i][j].setY(170); break;}
                }
                switch(j){
                    case 0: {notes[i][j].setX(62); break;}
                    case 1: {notes[i][j].setX(137); break;}
                    case 2: {notes[i][j].setX(210); break;}
                    case 3: {notes[i][j].setX(280); break;}
                    case 4: {notes[i][j].setX(347); break;}
                    case 5: {notes[i][j].setX(408); break;}
                    case 6: {notes[i][j].setX(468); break;}
                    case 7: {notes[i][j].setX(525); break;}
                    case 8: {notes[i][j].setX(580); break;}
                    case 9: {notes[i][j].setX(632); break;}
                    case 10:{notes[i][j].setX(683); break;}
                    case 11:{notes[i][j].setX(733); break;}
                }
            }
        }
    }
}
