package file_manipulation.counter;
import java.io.*;

public class SequenceCounter extends DataCounter{

    public SequenceCounter(){
        super();
        VERBOSEMESSAGE = "The file contains %s lines";
    }

    public SequenceCounter(char character){
        super(character);
        VERBOSEMESSAGE = "The file contains %s lines";        
    }

    @Override
    public void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch == NEWLINE)       {
            ++this.counter;
            System.out.print(outputChar);
        }
        
        this.count();
    }
    
}
