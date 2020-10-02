import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.CharacterCounter;
import file_manipulation.counter.*;


public class DriverChar {
    public static void main(String[] args) {
        Administrator ar = new Administrator(args);

        Countable data = new CharacterCounter();
        FileUtil wordcount = new FileUtil(ar, data);

        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
