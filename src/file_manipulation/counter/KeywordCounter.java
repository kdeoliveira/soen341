package file_manipulation.counter;
import java.io.*;


public class KeywordCounter extends DataCounter {

    private boolean flagKeyword = false;

    public KeywordCounter(File file) throws IOException{
        super(file);
    }


    protected void count() throws IOException{
        int ch = file.read();
        if(ch == EOF)                  return;

        if((char) ch != SPACE)       {
            if(!flagKeyword){
                flagKeyword = true;
                ++this.counter;
                System.out.print(outputChar);
            }
        }
        else{
            flagKeyword = false;
        }
            
        this.count();
    }
}
