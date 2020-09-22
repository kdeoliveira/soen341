package file_manipulation;

import java.io.*;
import java.nio.file.Files;

import file_manipulation.exception.InvalidFileUtil;
import file_manipulation.exception.InvalidArgumentUtil;



public class WordCount extends FileUtil{
    //Count number of arguments allowed
    private static final int NUMBER_ARGUMENTS = 1;

    public WordCount(){
        super();
    }

    public WordCount(Arguments arguments){
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }
    //Provide output for each options 
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
    //Execute command
    public int execute(){
        try{
            if(!super.isValid())
                return -1;
        }
        catch(InvalidFileUtil ifu){
            ifu.printError();
        }

        boolean isSpace = false;
        char c;

        try{
            this.options();
            byte[] data = Files.readAllBytes(this.srcPath);

            for(byte x : data){
                c = (char) x;
                if(c == '\n' || c == ' '){
                    if(!isSpace){
                        this.counter++;
                        isSpace = true;
                    }
                }else{
                    isSpace = false;
                }
            }            
        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("This file contains %s words %n", this.counter);
        return this.counter;
    }
    //Static reference to class
    public static WordCount wordcount(Arguments args){
        return new WordCount(args);
    }
}
