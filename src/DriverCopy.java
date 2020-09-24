import java.io.IOException;

import file_manipulation.*;


public class DriverCopy {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        Copy copy = new Copy(ar);

        try{
            copy.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
