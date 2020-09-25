package file_manipulation.counter;

import java.io.*;

import file_manipulation.Print;

public class MixCounter extends DataCounter {
    private boolean flagKeyword = false;
    private int counterWord = 0;
    private int counterChar = 0;
    private int counterLine = 0;
    private char character1 = NONE;
    private char character2 = NONE;
    private char character3 = NONE;

    public MixCounter(){
        super();
    }

    public MixCounter(File file) throws IOException{
        super(file);
        VERBOSEMESSAGE = "This file contains %s characters, %s words and %s lines";
    }

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

        counterChar += countCharacter(ch);
        counterWord += countKeyword(ch);
        counterLine += countSequence(ch);
        
        this.count();
    }

    private int countKeyword(int ch){
        if((char) ch != SPACE)       {
            if(!flagKeyword){
                flagKeyword = true;
                System.out.print(character1);
                return 1;
            }
        }
        else{
            flagKeyword = false;
        }
        return 0;
    }

    private int countSequence(int ch){
        if((char) ch == NEWLINE)       {
            System.out.print(character2);
            return 1;
        }
        return 0;
    }

    private int countCharacter(int ch){
        if((char) ch != NEWLINE)       {
            System.out.print(character3);
            return 1;
        }

        return 0;
    }

    public int getCounterChar(){
        return this.counterChar;
    }

    public int getCounterLine(){
        return this.counterLine;
    }

    public int getCounterWord(){
        return this.counterWord;
    }


}
