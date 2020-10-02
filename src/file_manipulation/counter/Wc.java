package file_manipulation.counter;

import java.io.*;

import file_manipulation.Print;

public class Wc extends DataCounter {
    private boolean flagKeyword = false;
    private char character1 = NONE;
    private char character2 = NONE;
    private char character3 = NONE;

    public Wc(){
        super();
        this.counter = new int[3];
    }

    public Wc(File file) throws IOException{
        super(file);
        this.counter = new int[3];
        VERBOSEMESSAGE = "This file contains %s characters, %s words and %s lines";
    }

    //Output characters per new character/line found
    @Override
    public void counter(char character1, char character2, char character3) throws IOException{
        this.character1 = character1;
        this.character2 = character2;
        this.character3 = character3;
        this.count();
        Print.newline();
    }

    protected void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch != NEWLINE)       {
            this.counter[0] += 1;
            Print.character(character1);
            if((char) ch != SPACE)       {
                if(!flagKeyword){
                    flagKeyword = true;
                    this.counter[1] += 1;
                    Print.character(character2);
                }
            }
            else{
                flagKeyword = false;
            }
        }
        else{
            this.counter[2] += 1;
            Print.character(character3);
        }
        this.counter();
    }
}
