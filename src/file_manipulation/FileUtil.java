package file_manipulation;

import java.io.*;
import java.lang.reflect.Constructor;

import file_manipulation.counter.DataCounter;
import file_manipulation.counter.MixCounter;
import file_manipulation.exception.InvalidArgumentUtil;

//Abstract super class for all file operations
public class FileUtil {
    protected File srcPath = null;
    protected File destPath = null;
    protected String optionnal = null;
    protected boolean VERBOSE = false;
    protected Administrator arguments;
    protected int counter = 0;
    private static final int NUMBER_ARGUMENTS = 1;

    private Class<? extends DataCounter> countable;

    protected static final String FILESOURCE = "source file";
    protected static final String DESTSOURCE = "destination file";


    public FileUtil(){
        arguments = null;
        countable = null;
    }

    public FileUtil(Administrator admin, DataCounter data){
        this.arguments = admin;
        countable = data.getClass();
        
        this.processArguments(NUMBER_ARGUMENTS);
    }

    public FileUtil(Administrator admin, int numberArguments){
        this.arguments = admin;
        countable = null;
        this.processArguments(numberArguments);
    }

    public boolean isValid(){
        if (this.srcPath != null)
            return this.srcPath.canRead();
        
        return false;
    }

    // Parse arguments 
    protected void processArguments(int numberOfArguments){
        optionnal = arguments.getOptions();
       try{
            if(arguments.isValid(1, numberOfArguments))
                this.assignFileAttributes();
            else
                throw this.throwInvalidArgument();

        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
    }

    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    }

    private void assignFileAttributes(){
        if(arguments.argumentSize() == 1){
            srcPath = new File(arguments.getArguments().get(0));
        }
        if(arguments.argumentSize() == 2){
            srcPath = new File(arguments.getArguments().get(0));
            destPath = new File(arguments.getArguments().get(1));
        }
    }

    protected void execOptions() throws InvalidArgumentUtil{  
        if(optionnal == null)    
            return;
    
        if(OPTIONS.HELP.contains(optionnal))
            OPTIONS.HELP.printHelper(FILESOURCE);
        
        else if(OPTIONS.BANNER.contains(optionnal))
            OPTIONS.BANNER.printBanner(this.getClass().getName());

        else if(OPTIONS.VERBOSE.contains(optionnal))
            this.VERBOSE = true;
    
        else
            throw new InvalidArgumentUtil("Invalid operand", OPTIONS.HELP.usage(FILESOURCE));
    }

    public int execute() throws IOException, NoSuchMethodException{
        if(!this.isValid())     return -1;

        Constructor<? extends DataCounter> countConstructor = countable
                .getDeclaredConstructor(File.class);

        try(DataCounter data = countConstructor.newInstance(srcPath)){
            this.execOptions();
            if(data.getClass().getName() == MixCounter.class.getName()){
                if(VERBOSE)
                    data.counter('w', 'l', 'c');
                else
                    data.counter();
                Print.verboseMix((MixCounter)data, VERBOSE, srcPath);
            }
            else{
                data.counter();
                Print.verbose(data, VERBOSE, srcPath);
            }
                
            this.counter = data.getCounter();

        }
        catch(Exception e){
            throw new IOException();
        }
        return this.counter;
    }
    
    public int getCounter(){
        return this.counter;
    }

}
