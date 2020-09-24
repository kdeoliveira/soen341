package file_manipulation;
import java.io.*;


import file_manipulation.exception.*;
import file_manipulation.counter.*;

public class WC extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 1;

    public WC(Administrator args){
        this.arguments = args;
        VERBOSEMESSAGE = "This file contains %s characters and words";
        super.processArguments(NUMBER_ARGUMENTS);    
    }

    @Override
    public int execute() throws IOException{
        if(!this.isValid())     return -1;

        try(CharacterCounter charCounter = new CharacterCounter(srcPath);
            KeywordCounter keywordCounter = new KeywordCounter(srcPath);
            SequenceCounter sequenceCounter = new SequenceCounter(srcPath);
        ){
            this.execOptions();
            if(VERBOSE){
                charCounter.counter('c');
                keywordCounter.counter('w');
                sequenceCounter.counter('l');
                Print.newline();
            }
            else{
                charCounter.counter();
                keywordCounter.counter();
                sequenceCounter.counter();
            }
            this.counter = charCounter.getCounter() + keywordCounter.getCounter();
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        
        Print.verbose(this.counter, VERBOSE, VERBOSEMESSAGE, srcPath);

        return this.counter;
    }

    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }

}
