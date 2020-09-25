package file_manipulation.counter;
import java.io.*;

public class SequenceCounter extends DataCounter{

    public SequenceCounter(){
        super();
    }
    public SequenceCounter(File file) throws IOException{
        super(file);
        VERBOSEMESSAGE = "This file contains %s lines";
    }


    protected void count() throws IOException{
        int k = file.read();
        if(k == EOF)                  return;

        if((char) k == NEWLINE)       {
            ++this.counter;
            System.out.print(outputChar);
        }
        
        count();
    }

    public static void main(String[] args) throws IOException {
        try(SequenceCounter sc = new SequenceCounter(new File("ProjectA_Sprint#_40054907_KevindeOliveira/src/test.txt"))){
            sc.counter();
        }
    }
    
}
