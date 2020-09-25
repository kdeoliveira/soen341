package file_manipulation.counter;
import java.io.*;

public class CharacterCounter extends DataCounter{

    public CharacterCounter(){
        super();
    }
    
    public CharacterCounter(File file) throws IOException{
        super(file);
        VERBOSEMESSAGE = "This file contains %s characters";
    }

    protected void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch != NEWLINE)       {
            ++this.counter;
            System.out.print(outputChar);
        }
        
        this.count();
    }



    
}
