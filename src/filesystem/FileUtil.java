package filesystem;

import java.io.*;
import java.lang.reflect.Constructor;

import datastream.*;
import datastream.counter.*;
import filesystem.exception.*;
import filesystem.util.*;

//Abstract super class for all file operations
public class FileUtil extends FileSystem{
    private static final int NUMBER_ARGUMENTS = 1;

    public FileUtil(Administrator admin, Data data) {
        super(admin, data, NUMBER_ARGUMENTS);
    }

    public FileUtil(Administrator admin, Data data, int numberArguments){
        super(admin, data, numberArguments);
    }

    public FileUtil(Administrator admin, int numberArguments){
        super(admin, numberArguments);
    }

    @Override
    public boolean execute() throws IOException, NoSuchMethodException{
        try{
            arguments.execOptions(this.data, Print.FILESOURCE);
            this.processArguments(this.numberOfArguments);
            if(!this.isFileValid())    throw new InvalidArgumentUtil("Invalid source file");
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }

        // Invoke constructor of Counter
        Constructor<? extends Data> countConstructor = this.data
                .getDeclaredConstructor(File.class);

        try(Data countable = countConstructor.newInstance(srcPath[0])) {
            boolean verbose = arguments.getVerbose();

            if(countable.getClass().getName() == Wc.class.getName()){
                countable.fork(verbose);

                Print.verboseMix((Wc)countable, verbose, srcPath[0]);
            }
            else{
                countable.fork(verbose);
                Print.verbose((wcOO)countable, verbose, srcPath[0]);
            }
        }
        catch(Exception e){
            throw new IOException();
        }
        return true;
    }

    @Override
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(Print.FILESOURCE));
    }

}
