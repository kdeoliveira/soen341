package file_manipulation;

import java.io.*;
import java.nio.file.Files;

import file_manipulation.exception.InvalidFileUtil;
import file_manipulation.exception.InvalidArgumentUtil;


public class CharCount extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 1;

    public CharCount(){
        super();
    }

    public CharCount(Arguments arguments){
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }

    protected void options() throws InvalidArgumentUtil{
        if(optionnal == null)
            return;
        if(optionnal.equals("-h") || optionnal.equals("-?") || optionnal.equals("--help")){
            System.out.println("Usage: <options> <src file>");
            System.exit(0);
        }
        else{
            throw new InvalidArgumentUtil("Invalid operand");
        }
    }
    public int execute(){
        try{
            if(!super.isValid())
                return -1;
            this.options();
        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
        catch(InvalidFileUtil ifu){
            ifu.printError();
        }
        

        char c;
        try{
            byte[] data = Files.readAllBytes(this.srcPath);
            if(data.length == 0)
                throw new IOException("File is empty");

            for(byte x : data){
                c = (char) x;
                if(c != '\n')
                    this.counter++;
            }

            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        System.out.printf("This file contains %s characters %n", this.counter);
        return this.counter;
    }

    public static CharCount charcount(Arguments args){
        return new CharCount(args);
    }

}
