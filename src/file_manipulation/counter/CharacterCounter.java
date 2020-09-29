package file_manipulation.counter;

import java.io.*;

import file_manipulation.Print;

public class CharacterCounter extends DataCounter{

    public CharacterCounter(){
        super();
    }
    
    public CharacterCounter(File file) throws IOException{
        super(file);
        VERBOSEMESSAGE = "This file contains %s characters";
    }
    // Recursive counter of each charactere, except new line 
    protected void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch != NEWLINE)       {
            ++this.counter;
            Print.character(outputChar);
        }
        
        this.count();
    }



    
}
