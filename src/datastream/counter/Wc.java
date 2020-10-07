package datastream.counter;

import java.io.*;
import java.util.Arrays;

import filemanagement.util.*;

public class Wc extends DataCounter {
    private boolean flagKeyword = false;
    private char[] outputChar;

    public Wc(){
        super();
        this.counter = new int[3];
        this.outputChar = new char[3];
    }

    public Wc(File file) throws IOException{
        super(file);
        this.counter = new int[3];
        VERBOSEMESSAGE = "This file contains %s characters, %s words and %s lines";
        this.outputChar = new char[3];
    }

    protected void setDefaultOutput(){
        this.outputChar[0] = 'c';
        this.outputChar[1] = 'w';
        this.outputChar[2] = 'l';
    }
    protected void setOutput(char[] c){
        if(c.length > 3 || c.length == 0)   return;
        this.outputChar = Arrays.copyOf(c, c.length);
    }

    public void count(int ch) throws IOException{
        if(ch == EOF)                  return;

        if((char) ch != NEWLINE)       {
            this.counter[0] += 1;
            Print.character(this.outputChar[0]);
            if((char) ch != SPACE)       {
                if(!flagKeyword){
                    flagKeyword = true;
                    this.counter[1] += 1;
                    Print.character(this.outputChar[1]);
                }
            }
            else{
                flagKeyword = false;
            }
        }
        else{
            this.counter[2] += 1;
            Print.character(this.outputChar[2]);
        }
        this.fork();
    }
}
