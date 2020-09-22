package file_manipulation;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import file_manipulation.exception.InvalidFileUtil;
import file_manipulation.exception.InvalidArgumentUtil;

public class LineCount extends FileUtil {
    private static final int NUMBER_ARGUMENTS = 1;

    public LineCount(){
        super();
    }

    public LineCount(Arguments arguments){
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
        

        try{
            List<String> data = Files.readAllLines(this.srcPath);
            this.counter = data.size();           
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.printf("This file contains %s lines %n", this.counter);
        return this.counter;
    }
    public static LineCount linecount(Arguments args){
        return new LineCount(args);
    }

}
