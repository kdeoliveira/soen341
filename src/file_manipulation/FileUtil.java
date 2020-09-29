package file_manipulation;

import java.io.*;
import java.lang.reflect.Constructor;

import file_manipulation.counter.DataCounter;
import file_manipulation.counter.MixCounter;
import file_manipulation.exception.InvalidArgumentUtil;

//Abstract super class for all file operations
public class FileUtil {
    protected File [] srcPath;
    protected Administrator arguments;
    private static final int NUMBER_ARGUMENTS = 1;

    private Class<? extends DataCounter> countable;

    public FileUtil(Administrator admin, DataCounter data) {
        this.arguments      = admin;
        countable           = data.getClass();
        srcPath             = new File[NUMBER_ARGUMENTS];

        this.processArguments(NUMBER_ARGUMENTS);
    }

    public FileUtil(Administrator admin, DataCounter data, int numberArguments){
        this.arguments      = admin;
        countable           = data.getClass();
        srcPath             = new File[numberArguments];

        this.processArguments(numberArguments);
    }

    public FileUtil(Administrator admin, int numberArguments){
        this.arguments      = admin;
        countable           = null;
        srcPath             = new File[numberArguments];

        this.processArguments(numberArguments);
    }

    // Parse arguments based on number of allowed arguments
    private void processArguments(int numberOfArguments){
       try{
            if(arguments.isValid(0, numberOfArguments))     this.assignFileAttributes();
            else                                            throw this.throwInvalidArgument();
        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
    }

    // Assign files for each string on argument
    private void assignFileAttributes(){
        for(int i=0 ; i < arguments.argumentSize(); i++)
            srcPath[i] = new File(arguments.getArguments().get(i));
    }

    public boolean isFileValid(){
        if (this.srcPath[0] != null)    return this.srcPath[0].canRead();
        return false;
    }

    // Execute action based on arguments and Counter provided
    public boolean execute() throws IOException, NoSuchMethodException{
        try{
            arguments.execOptions(countable, Print.FILESOURCE);
            if(!this.isFileValid())    throw new InvalidArgumentUtil("Invalid source file");
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        
        // Invoke constructor of Counter
        Constructor<? extends DataCounter> countConstructor = countable
                .getDeclaredConstructor(File.class);

        try(DataCounter data = countConstructor.newInstance(srcPath[0])){
            boolean verbose = arguments.getVerbose();

            if(data.getClass().getName() == MixCounter.class.getName()){
                if(verbose)     data.counter('w', 'l', 'c');
                else            data.counter();

                Print.verboseMix((MixCounter)data, verbose, srcPath[0]);
            }
            else{
                data.counter();
                Print.verbose(data, verbose, srcPath[0]);
            }
                
        }
        catch(Exception e){
            throw new IOException();
        }
        return true;
    }

    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(Print.FILESOURCE));
    }

}
