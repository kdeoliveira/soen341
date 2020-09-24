package file_manipulation;

import java.io.*;
import file_manipulation.counter.KeywordCounter;
import file_manipulation.exception.InvalidArgumentUtil;



public class WordCount extends FileUtil{
    //Count number of arguments allowed
    private static final int NUMBER_ARGUMENTS = 1;

    public WordCount(){
        super();
    }

    public WordCount(Arguments arguments){
        VERBOSEMESSAGE = "This file contains %s words";
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }

    //Execute command
    public int execute() throws IOException{
        if(!this.isValid())     return -1;

        try(KeywordCounter keyCounter = new KeywordCounter(srcPath)){
            this.execOptions();
            keyCounter.counter();
            this.counter = keyCounter.getCounter();
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        
        Print.verbose(this.counter, VERBOSE, VERBOSEMESSAGE, srcPath);

        return this.counter;
    }

    //Static reference to class
    public static WordCount wordcount(Arguments args){
        return new WordCount(args);
    }
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }
}
