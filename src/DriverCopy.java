import java.io.IOException;

import datastream.*;
import datastream.transfer.Copy;
import filesystem.*;
import filesystem.util.Administrator;


public class DriverCopy {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        Data copy = new Copy();
        FileSystem cp = new FileMgmt(ar, copy);

        try{
            cp.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
