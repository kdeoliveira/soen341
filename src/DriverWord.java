import java.io.IOException;

import file_manipulation.*;


public class DriverWord {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        WordCount wc = new WordCount(ar);

        try{
            wc.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
