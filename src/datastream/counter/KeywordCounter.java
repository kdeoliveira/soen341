package datastream.counter;

import java.io.*;

import filemanagement.util.*;

public class KeywordCounter extends DataCounter {

    private char outputChar;
    private boolean flagKeyword = false;

    public KeywordCounter(File file) throws IOException{
        super(file);
        this.counter = new int[1];
        VERBOSEMESSAGE = "This file contains %s words";
        this.outputChar = NONE;
    }

    public KeywordCounter() {
        super();
        this.counter = new int[1];
        this.outputChar = NONE;
    }

    protected void setDefaultOutput(){
        this.outputChar = 'w';
    }
    protected void setOutput(char[] c){
        if(c.length != 1)   return;
        this.outputChar = c[0];
    }
    
    
    // Recursive counter for each keyword found between spaces
	public void count(int ch) throws IOException{
        if(ch == EOF)                  return;

        if((char) ch != SPACE)       {
            if(!flagKeyword){
                flagKeyword = true;
                this.counter[0] += 1;
                Print.character(outputChar);
            }
        }
        else{
            flagKeyword = false;
        }
        this.fork();
    }
}
