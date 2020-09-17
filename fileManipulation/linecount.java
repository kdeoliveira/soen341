package fileManipulation;

import java.io.*;

public class linecount {

    private File srcFile;
    private String optionnal;
    private Arguments arguments;


    public linecount(Arguments arguments){
        optionnal = arguments.getOptions();

        if(!arguments.isValid() || arguments.argumentSize() != 1)
            return;
        
        srcFile = new File(arguments.getArguments().get(0));
    }

    public boolean isValid(){
        if(srcFile != null){
            return srcFile.canRead();
        }
        return false;
    }

    public boolean execute(){
        if(!isValid())
            return false;

        int counter = 0;

        try(BufferedReader in = new BufferedReader(new FileReader(srcFile))){
            System.out.println(srcFile.length() + " bytes");

            if(!in.ready())
                return false;

            while(in.readLine() != null) counter++;
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("This file contains %s lines %n", counter);
        return true;
    }
}
