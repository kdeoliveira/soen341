import java.io.IOException;

import datastream.*;
import datastream.counter.*;

import filemanagement.*;
import filemanagement.util.Administrator;

public class DriverLine {
    public static void main(String[] args) {
        Administrator ar = new Administrator(args);
        
        Data data = new SequenceCounter();
        
        FileUtil wordcount = new FileUtil(ar, data);

        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
