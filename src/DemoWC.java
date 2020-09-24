import java.io.IOException;

import file_manipulation.*;


public class DemoWC {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        WC wordcount = new WC(ar);

        try{
            wordcount.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
