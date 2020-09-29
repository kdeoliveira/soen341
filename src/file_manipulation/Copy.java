package file_manipulation;

import java.io.*;

import file_manipulation.exception.InvalidArgumentUtil;

public class Copy extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 2;
    
    public Copy(Administrator admin){
        super(admin, NUMBER_ARGUMENTS);
    }

    @Override
    public boolean execute() throws IOException {
        try{
            arguments.execOptions(this.getClass(), Print.FILESOURCE, Print.DESTSOURCE);
            //Checks if src file not valid
            if(!this.isFileValid())    throw new InvalidArgumentUtil("Invalid source file");
        }
        catch(InvalidArgumentUtil e){
            e.printError();

        }

        try(FileInputStream source = new FileInputStream(srcPath[0]);
            FileOutputStream destination = new FileOutputStream(srcPath[1])){
                boolean verbose = arguments.getVerbose();
                int c;

                while( (c = source.read()) != -1 ){
                    destination.write(c);
                    if(verbose)         Print.character('.');
                }
                Print.newline();
                Print.line("Copied successfully");
        }
        catch(FileNotFoundException f404){
            throw new IOException("File not found");
        }
        return true;
    }

    @Override
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(Print.FILESOURCE, Print.DESTSOURCE));
    }

    public static Copy copy(Administrator args){
        return new Copy(args);
    }

}