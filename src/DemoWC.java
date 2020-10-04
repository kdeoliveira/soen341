import java.io.IOException;

import file_manipulation.*;
import file_manipulation.counter.*;

public class DemoWC {
    public static void main(String[] args) {
        Class<Void> clazz;
        FileUtil wordcount = new FileUtil(
                                            new Administrator(args),
                                            new Wc(void)
                                        );
        try{
            wordcount.execute();
        }
        catch(IOException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
