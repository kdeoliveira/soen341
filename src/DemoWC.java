import java.io.IOException;

import datastream.counter.*;
import filemanagement.FileUtil;
import filemanagement.util.*;

public class DemoWC {
    public static void main(String[] args) {
        FileUtil wordcount = new FileUtil(
                                            new Administrator(args),
                                            new Wc()
                                        );
        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
