import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.*;

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
