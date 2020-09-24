import java.io.File;
import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.Countable;
import file_manipulation.counter.KeywordCounter;


public class DriverLine {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        try(KeywordCounter line = new KeywordCounter()){
            FileUtil lc = new FileUtil(ar, line);
            lc.execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
