package file_manipulation;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import file_manipulation.exception.InvalidFileUtil;
import file_manipulation.exception.InvalidArgumentUtil;

public class Copy extends FileUtil{
    //Count number of arguments allowed
    private static final int NUMBER_ARGUMENTS = 2;
    //Destination file can be overwritten
    private boolean FORCE_COPY = false;
    
    public Copy(){
        super();
    }

    public Copy(Arguments arguments){
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }

    //Override super method 
    @Override
    public boolean isValid() throws InvalidFileUtil{
        if(this.srcPath != null && !Files.isReadable(this.srcPath))
            throw new InvalidFileUtil();

        //Check if destination folder exists
        if(this.destPath != null){
            if(Files.isDirectory(destPath)){
                return Files.exists(destPath);
            }
            return Files.exists(destPath.getParent());
        }

        return true;
    }

    protected void options() throws InvalidArgumentUtil{
        if(optionnal == null)
            return;
        if(optionnal.equals("-h") || optionnal.equals("-?") || optionnal.equals("--help")){
            System.out.println("Usage: <options> <src file> <dest file>");
            System.exit(0);
        }
        if(optionnal.equals("-f")){
            FORCE_COPY = true;
        }
        else{
            throw new InvalidArgumentUtil("Invalid operand");
        }
    }
    public int execute(){
        try{
            if(!this.isValid())
                return -1;
        }
        catch(InvalidFileUtil ifu){
            ifu.printError();
        }

        int c = 0;
        try
        {
            this.options();
            if(!Files.isReadable(this.srcPath)){
                throw new InvalidFileUtil();
            }

            //TODO Overwrite only with option -f

            Files.copy(this.srcPath, this.destPath);
            c = (int) Files.size(srcPath);
        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
        catch(FileAlreadyExistsException e)
        {
            try{
                System.out.println("File already exists at "+this.destPath.getParent());

                if(FORCE_COPY){
                    System.out.println("File will be overwritten");
                    Files.copy(this.srcPath, this.destPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch(IOException eFroce){
                e.printStackTrace();
            }
        }
        catch(InvalidFileUtil ifu){
            ifu.printError();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("File was copied successfully");
        return c;
        
    }

    public static Copy copy(Arguments args){
        return new Copy(args);
    }

}