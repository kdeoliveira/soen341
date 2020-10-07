import java.io.IOException;

import datastream.*;
import datastream.counter.*;
import filesystem.FileUtil;
import filesystem.util.*;


public class DriverChar {
    public static void main(String[] args) {
        Administrator ar = new Administrator(args);

        Data data = new CharacterCounter();
        FileUtil wordcount = new FileUtil(ar, data);

        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
