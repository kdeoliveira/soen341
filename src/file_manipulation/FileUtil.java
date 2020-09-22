package file_manipulation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import file_manipulation.exception.InvalidArgumentUtil;
import file_manipulation.exception.InvalidFileUtil;

//Abstract super class for all file operations
public abstract class FileUtil {
    protected Path srcPath = null;
    protected Path destPath = null;
    protected String optionnal = null;
    protected Arguments arguments;
    protected int counter = 0;

    public FileUtil(){
        optionnal = null;
        arguments = null;
    }
    // Verify if input file is valid -> Can be overriden
    public boolean isValid() throws InvalidFileUtil{
        if (this.srcPath != null && !Files.isReadable(this.srcPath))
            throw new InvalidFileUtil();
        
        return true;
    }

    // Parse arguments 
    protected void processArguments(int numberOfArguments){
       try{
            optionnal = arguments.getOptions();

            if(!arguments.isValid() || (arguments.argumentSize() != numberOfArguments && arguments.argumentSize() != 0)){
                throw new InvalidArgumentUtil();
            }

            if(arguments.argumentSize() == 1){
                srcPath = Paths.get(arguments.getArguments().get(0)).toAbsolutePath();
            }
            if(arguments.argumentSize() == 2){
                srcPath = Paths.get(arguments.getArguments().get(0)).toAbsolutePath();
                destPath = Paths.get(arguments.getArguments().get(1)).toAbsolutePath();
            }
        }
        catch(InvalidArgumentUtil iau){
            iau.printError();
        }
    }

    protected abstract void options() throws InvalidArgumentUtil;
    public abstract int execute();
    
    public int getCounter(){
        return this.counter;
    }

    // public static Object subclass(Object o){
    //     Method mt;
    //     Object obj = null;
    //     Class <?> subclass = FileUtil.class.getClass();
    //     try{
    //         mt = subclass.getMethod("execute");
    //         obj = mt.invoke(o);
    //     }
    //     catch(Exception nmt){
    //         nmt.printStackTrace();
    //     }

    //     return obj;
        
    // }


}
