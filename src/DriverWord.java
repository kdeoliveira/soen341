import java.io.IOException;

import file_manipulation.*;


public class DriverWord {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        WordCount wc = new WordCount(ar);

        try{
            wc.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
