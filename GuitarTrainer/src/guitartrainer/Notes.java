package guitartrainer;

public class Notes {
    private Note[][] notes = new Note[6][12];
    
    public Notes(){
        notes[0][0] = new Note("F");
        notes[0][1] = new Note("F#/Gb");
        notes[0][2] = new Note("G");
        notes[0][3] = new Note("G#/Ab");
        notes[0][4] = new Note("A");
        notes[0][5] = new Note("A#/Bb");
        notes[0][6] = new Note("B");
        notes[0][7] = new Note("C");
        notes[0][8] = new Note("C#/Db");
        notes[0][9] = new Note("D");
        notes[0][10] = new Note("D#/Eb");
        notes[0][11] = new Note("E");
        notes[1][0] = new Note("C");
        notes[1][1] = new Note("C#/Db");
        notes[1][2] = new Note("D");
        notes[1][3] = new Note("D#/Eb");
        notes[1][4] = new Note("E");
        notes[1][5] = new Note("F");
        notes[1][6] = new Note("F#/Gb");
        notes[1][7] = new Note("G");
        notes[1][8] = new Note("G#/Ab");
        notes[1][9] = new Note("A");
        notes[1][10] = new Note("A#/Bb");
        notes[1][11] = new Note("B");
        notes[2][0] = new Note("G#/Ab");
        notes[2][1] = new Note("A");
        notes[2][2] = new Note("A#/Bb");
        notes[2][3] = new Note("B");
        notes[2][4] = new Note("C");
        notes[2][5] = new Note("C#/Db");
        notes[2][6] = new Note("D");
        notes[2][7] = new Note("D#/Eb");
        notes[2][8] = new Note("E");
        notes[2][9] = new Note("E#/Fb");
        notes[2][10] = new Note("F");
        notes[2][11] = new Note("G");
        notes[3][0] = new Note("D#/Eb");
        notes[3][1] = new Note("E");
        notes[3][2] = new Note("F");
        notes[3][3] = new Note("F#/Gb");
        notes[3][4] = new Note("G");
        notes[3][5] = new Note("G#/Ab"); 
        notes[3][6] = new Note("A");
        notes[3][7] = new Note("A#/Bb");
        notes[3][8] = new Note("B");
        notes[3][9] = new Note("C");
        notes[3][10] = new Note("C#/Db");
        notes[3][11] = new Note("D");
        notes[4][0] = new Note("A#/Bb");
        notes[4][1] = new Note("B");
        notes[4][2] = new Note("C");
        notes[4][3] = new Note("C#/Db"); 
        notes[4][4] = new Note("D");
        notes[4][5] = new Note("D#/Eb");
        notes[4][6] = new Note("E");
        notes[4][7] = new Note("F");
        notes[4][8] = new Note("F#/Gb");
        notes[4][9] = new Note("G");
        notes[4][10] = new Note("G#/Ab");
        notes[4][11] = new Note("A");
        notes[5][0] = new Note("F");
        notes[5][1] = new Note("F#/Gb");
        notes[5][2] = new Note("G");
        notes[5][3] = new Note("G#/Ab");
        notes[5][4] = new Note("A");
        notes[5][5] = new Note("A#/Bb");
        notes[5][6] = new Note("B");
        notes[5][7] = new Note("C");
        notes[5][8] = new Note("C#/Db");
        notes[5][9] = new Note("D");
        notes[5][10] = new Note("D#/Eb");
        notes[5][11] = new Note("E");
        
        for(int i = 0; i < 6; i ++){
            for(int j = 0; j < 12; j ++){
                switch(i){
                    case 0: {notes[i][j].setY(45); break;}
                    case 1: {notes[i][j].setY(62); break;}
                    case 2: {notes[i][j].setY(83); break;}
                    case 3: {notes[i][j].setY(101); break;}
                    case 4: {notes[i][j].setY(120); break;}
                    case 5: {notes[i][j].setY(139); break;}
                }
                switch(j){
                    case 0: {notes[i][j].setX(58); break;}
                    case 1: {notes[i][j].setX(133); break;}
                    case 2: {notes[i][j].setX(206); break;}
                    case 3: {notes[i][j].setX(276); break;}
                    case 4: {notes[i][j].setX(343); break;}
                    case 5: {notes[i][j].setX(404); break;}
                    case 6: {notes[i][j].setX(465); break;}
                    case 7: {notes[i][j].setX(521); break;}
                    case 8: {notes[i][j].setX(576); break;}
                    case 9: {notes[i][j].setX(628); break;}
                    case 10:{notes[i][j].setX(679); break;}
                    case 11:{notes[i][j].setX(729); break;}
                }
                notes[i][j].setSound(i, j);
            }
        }
    }
    
    public Note[][] getNotes(){
        return notes;
    }
}
