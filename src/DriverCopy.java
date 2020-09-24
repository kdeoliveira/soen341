import java.io.IOException;

import file_manipulation.*;


public class DriverCopy {
    public static void main(String[] args){
        Administrator ar = new Administrator(args);

        Copy copy = new Copy(ar);

        try{
            copy.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
