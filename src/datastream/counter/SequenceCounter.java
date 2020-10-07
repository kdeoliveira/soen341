package datastream.counter;
import java.io.*;

import filemanagement.util.*;

public class SequenceCounter extends DataCounter{

    private char outputChar;

    public SequenceCounter(){
        super();
        this.counter = new int[1];
        this.outputChar = NONE;
    }
    public SequenceCounter(File file) throws IOException{
        super(file);
        this.counter = new int[1];
        VERBOSEMESSAGE = "This file contains %s lines";
        this.outputChar = NONE;
    }

    protected void setDefaultOutput(){
        this.outputChar = 'l';
    }
    protected void setOutput(char[] c){
        if(c.length != 1)   return;
        this.outputChar = c[0];
    }

    // Recursive counter of each new line 
    public void count(int ch) throws IOException{
        if(ch == EOF)                  return;

        if((char) ch == NEWLINE)       {
            this.counter[0] += 1;
            Print.character(outputChar);
        }

        this.fork();
    }
}
