import java.io.File;
import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.*;


public class DriverLine {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        
        try(DataCounter algorithm = new SequenceCounter()){
            FileUtil lc = new FileUtil(ar, algorithm);
            lc.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
