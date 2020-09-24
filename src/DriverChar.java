import java.io.IOException;


import file_manipulation.*;

public class DriverChar {
    public static void main(String[] args){

        System.out.println(System.getProperty("os.name"));

        Administrator ar = new Administrator(args);

        CharCount cc = new CharCount(ar);

        try{
            cc.execute();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
