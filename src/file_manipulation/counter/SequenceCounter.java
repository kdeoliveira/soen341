package file_manipulation.counter;
import java.io.*;

import file_manipulation.Print;

public class SequenceCounter extends DataCounter{

    public SequenceCounter(){
        super();
    }
    public SequenceCounter(File file) throws IOException{
        super(file);
        VERBOSEMESSAGE = "This file contains %s lines";
    }

    // Recursive counter of each new line 
    protected void count() throws IOException{
        int k = file.read();
        if(k == EOF)                  return;

        if((char) k == NEWLINE)       {
            ++this.counter;
            Print.character(outputChar);
        }
        
        count();
    }
    
}
