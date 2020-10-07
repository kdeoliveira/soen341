package filesystem;

import java.io.*;

import datastream.*;
import filesystem.exception.*;
import filesystem.util.*;

public abstract class FileSystem {
    protected File [] srcPath;
    protected Administrator arguments;
    protected Class<? extends Data> data;

    public FileSystem(Administrator admin, Data data, int numberOfArguments){
        this.arguments      = admin;
        this.srcPath             = new File[numberOfArguments];
        this.data           = (data instanceof Data) ?  data.getClass() : Data.class;
        this.processArguments(numberOfArguments);
    }

    public FileSystem(Administrator admin, int numberOfArguments){
        this.arguments      = admin;
        this.data           = null;
        srcPath             = new File[numberOfArguments];

        this.processArguments(numberOfArguments);
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

    public abstract boolean execute() throws IOException, NoSuchMethodException;
    protected abstract InvalidArgumentUtil throwInvalidArgument();

}
