package filemanagement;

import java.io.*;
import java.lang.reflect.Constructor;

import datastream.*;
import filemanagement.exception.*;
import filemanagement.util.*;

public class FileMgmt extends FileSystem{
    private static final int NUMBER_ARGUMENTS = 2;

    public FileMgmt(Administrator admin, Data data) {
        super(admin, data, NUMBER_ARGUMENTS);
    }

    public FileMgmt(Administrator admin, Data data, int numberArguments){
        super(admin, data, numberArguments);
    }

    public FileMgmt(Administrator admin, int numberArguments){
        super(admin, numberArguments);
    }

    @Override
    public boolean execute() throws IOException, NoSuchMethodException{
        try{
            arguments.execOptions(this.getClass(), Print.FILESOURCE, Print.DESTSOURCE);
            //Checks if src file not valid
            if(!this.isFileValid())    throw new InvalidArgumentUtil("Invalid source file");
        }
        catch(InvalidArgumentUtil e){
            e.printError();

        }

        Constructor<? extends Data> dataConstructor = this.data.getDeclaredConstructor(File.class, File.class);


        try(Data transferable = dataConstructor.newInstance(srcPath[0], srcPath[1])){
                transferable.fork(arguments.getVerbose());
        }
        catch(Exception f404){
            throw new IOException("File not found");
        }
        return true;
    }

    @Override
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(Print.FILESOURCE, Print.DESTSOURCE));
    }
}
