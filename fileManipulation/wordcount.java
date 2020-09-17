package fileManipulation;
import java.io.*;


public class wordcount {
    private File srcFile;
    private String optionnal;
    private Arguments arguments;


    public wordcount(Arguments arguments){
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
        boolean isSpace = false;
        char c;
        try(FileInputStream in = new FileInputStream(srcFile)){
            System.out.println(srcFile.length() + " bytes");
            if(srcFile.length() > 0)
                counter++;

            while((x = in.read()) != -1){
                c = (char) x;
                if(c == '\n' || c == ' '){
                    if(!isSpace){
                        counter++;
                        isSpace = true;
                    }
                }else{
                    isSpace = false;
                }
            }
            
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("This file contains %s words %n", counter);
        return true;
    }
}
