package file_manipulation;

import java.io.*;

import file_manipulation.exception.InvalidArgumentUtil;

public class Copy extends FileUtil{
    private static final int NUMBER_ARGUMENTS = 2;
    
    public Copy(){
        super();
    }

    public Copy(Administrator admin){
        super(admin, NUMBER_ARGUMENTS);
    }

    @Override
    protected void execOptions() throws InvalidArgumentUtil{  
        if(optionnal == null)    
            return;
    
        if(OPTIONS.HELP.contains(optionnal))
            OPTIONS.HELP.printHelper(FILESOURCE, DESTSOURCE);
        
        else if(OPTIONS.BANNER.contains(optionnal))
            OPTIONS.BANNER.printBanner(this.getClass().getName());

        else if(OPTIONS.VERBOSE.contains(optionnal))
            this.VERBOSE = true;
    
        else
            throw new InvalidArgumentUtil("Invalid operand", OPTIONS.HELP.usage(FILESOURCE, DESTSOURCE));
    }

    @Override
    public int execute() throws IOException {
        if(!this.isValid())     return -1;

        try(FileInputStream source = new FileInputStream(srcPath);
            FileOutputStream destination = new FileOutputStream(destPath)){
                this.execOptions();
                int c;

                while( (c = source.read()) != -1 ){
                    destination.write(c);
                    if(VERBOSE){
                        Print.character('.');
                        Print.line("Copied successfully");
                    }
                }
        }
        catch(InvalidArgumentUtil e){
            e.printError();
        }
        catch(FileNotFoundException f404){
            f404.printStackTrace(Print.getOutput());
        }
        return 0;
    }

    public static Copy copy(Administrator args){
        return new Copy(args);
    }
    @Override
    protected InvalidArgumentUtil throwInvalidArgument(){
        return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE, DESTSOURCE));
    }

}