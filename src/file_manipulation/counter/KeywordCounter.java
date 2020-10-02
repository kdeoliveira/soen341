package file_manipulation.counter;

import java.io.*;

import file_manipulation.Print;


public class KeywordCounter extends DataCounter {

    private boolean flagKeyword = false;

    public KeywordCounter(File file) throws IOException{
        super(file);
        this.counter = new int[1];
        VERBOSEMESSAGE = "This file contains %s words";
    }

    public KeywordCounter() {
        super();
        this.counter = new int[1];
    }
    
    // Recursive counter for each keyword found between spaces
	protected void count() throws IOException{
        int ch = file.read();
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
            
        this.count();
    }
}
