import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.*;


public class DriverLine {
    public static void main(String[] args) {
        Administrator ar = new Administrator(args);
        
        Countable data = new SequenceCounter();
        
        FileUtil wordcount = new FileUtil(ar, data);

        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
