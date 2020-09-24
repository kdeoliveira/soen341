import java.io.IOException;

import file_manipulation.*;


public class DemoWC {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        WC wordcount = new WC(ar);

        try{
            wordcount.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
