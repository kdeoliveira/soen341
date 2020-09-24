import java.io.IOException;

import file_manipulation.*;


public class DriverLine {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        LineCount lc = new LineCount(ar);

        try{
            lc.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
