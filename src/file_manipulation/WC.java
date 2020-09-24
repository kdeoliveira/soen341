package file_manipulation;
import java.io.*;

import file_manipulation.exception.*;
import file_manipulation.counter.*;

public class WC extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 1;

    public WC(){
        super();
    }

    public WC(Arguments args){
        this.arguments = args;
        VERBOSEMESSAGE = "This file contains %s characters";
        super.processArguments(NUMBER_ARGUMENTS);    
    }

    public int execute() throws IOException{
        if(!this.isValid())     return -1;

        try(CharacterCounter charCounter = new CharacterCounter(srcPath);
            KeywordCounter keywordCounter = new KeywordCounter(srcPath);
        ){
            this.execOptions();
            charCounter.counter('c');
            keywordCounter.counter('w');
            this.counter = charCounter.getCounter();
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        Print.newline();
        Print.verbose(this.counter, VERBOSE, VERBOSEMESSAGE, srcPath);

        return this.counter;
    }

    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }

}
