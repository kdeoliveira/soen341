package file_manipulation;

import java.io.*;

import file_manipulation.counter.SequenceCounter;
import file_manipulation.exception.InvalidArgumentUtil;

public class LineCount extends FileUtil {
    private static final int NUMBER_ARGUMENTS = 1;

    public LineCount(){
        super();
    }

    public LineCount(Arguments arguments){
        VERBOSEMESSAGE = "This file contains %s lines";
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }



    public int execute() throws IOException{
        if(!this.isValid())     return -1;

        try(SequenceCounter lineCounter = new SequenceCounter(srcPath)){
            this.execOptions();
            lineCounter.counter();
            this.counter = lineCounter.getCounter();
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        
        Print.verbose(this.counter, VERBOSE, VERBOSEMESSAGE, srcPath);
        
        return this.counter;
    }


    public static LineCount linecount(Arguments args){
        return new LineCount(args);
    }
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }

}
