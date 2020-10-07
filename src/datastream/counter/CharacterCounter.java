package datastream.counter;

import java.io.*;

import filemanagement.util.*;

public class CharacterCounter extends DataCounter{

    private char outputChar;

    public CharacterCounter(){
        super();
        this.counter = new int[1];
        this.outputChar = NONE;
    }
    
    public CharacterCounter(File file) throws IOException{
        super(file);
        this.counter = new int[1];
        VERBOSEMESSAGE = "This file contains %s characters";
        this.outputChar = NONE;
    }

    protected void setDefaultOutput(){
        this.outputChar = 'c';
    }
    protected void setOutput(char[] c){
        if(c.length != 1)   return;
        this.outputChar = c[0];
    }

    // Recursive counter of each charactere, except new line 
    public void count(int ch) throws IOException{
        if(ch == EOF)                  return;

        if((char) ch != NEWLINE)       {
            this.counter[0] += 1;
            Print.character(outputChar);
        }
        this.fork();
    }
}
