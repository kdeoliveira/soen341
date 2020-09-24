package file_manipulation.counter;
import java.io.*;

public class SequenceCounter extends DataCounter{
    public SequenceCounter(File file) throws IOException{
        super(file);
    }


    protected void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch == NEWLINE)       {
            ++this.counter;
            System.out.print(outputChar);
        }
        
        this.count();
    }
    
}
