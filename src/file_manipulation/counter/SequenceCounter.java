package file_manipulation.counter;
import java.io.*;

public class SequenceCounter extends DataCounter{
    public SequenceCounter(File file) throws IOException{
        super(file);
    }
    public SequenceCounter() throws IOException{
        super();
    }


    public void counter() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch == NEWLINE)       {
            ++this.counter;
            System.out.print(outputChar);
        }
        
        this.counter();
    }
    
}
