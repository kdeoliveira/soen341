package fileManipulation;

import java.io.*;

public class charcount {
    private File srcFile;
    private String optionnal;
    private Arguments arguments;


    public charcount(Arguments arguments){
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

        int x = 0, counter = 0;
        char c;
        try(FileInputStream in = new FileInputStream(srcFile)){
            System.out.println(srcFile.length() + " bytes");

            while((x = in.read()) != -1){
                c = (char) x;
                if(c != '\n')
                    counter++;
            }

            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("This file contains %s characters %n", counter);
        return true;
    }
}
