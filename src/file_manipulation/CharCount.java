package file_manipulation;

import java.io.*;

import file_manipulation.exception.*;
import file_manipulation.counter.*;


public class CharCount extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 1;

    public CharCount(){
        super();
    }

    public CharCount(Arguments arguments){
        this.arguments = arguments;
        VERBOSEMESSAGE = "This file contains %s characters";
        super.processArguments(NUMBER_ARGUMENTS);
    }

    public int execute() throws IOException{
        if(!this.isValid())     return -1;

        try(CharacterCounter charCounter = new CharacterCounter(srcPath)){
            this.execOptions();
            charCounter.counter();
            this.counter = charCounter.getCounter();
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        Print.verbose(this.counter, VERBOSE, VERBOSEMESSAGE, srcPath);

        return this.counter;
    }

    public static CharCount charcount(Arguments args){
        return new CharCount(args);
    }

    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }


}
