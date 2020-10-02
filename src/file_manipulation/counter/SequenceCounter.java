package file_manipulation.counter;
import java.io.*;

import file_manipulation.Print;

public class SequenceCounter extends DataCounter{

    public SequenceCounter(){
        super();
        this.counter = new int[1];
    }
    public SequenceCounter(File file) throws IOException{
        super(file);
        this.counter = new int[1];
        VERBOSEMESSAGE = "This file contains %s lines";
    }

    // Recursive counter of each new line 
    protected void count() throws IOException{
        int k = file.read();
        if(k == EOF)                  return;

        if((char) k == NEWLINE)       {
            this.counter[0] += 1;
            Print.character(outputChar);
        }
        
        count();
    }
    
}
