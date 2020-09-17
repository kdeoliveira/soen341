package fileManipulation;
import java.io.*;

public abstract class FileUtil {
    protected File destFile = null;
    protected File srcFile = null;
    protected String optionnal = null;
    protected Arguments arguments;

    public FileUtil(){
        optionnal = null;
        arguments = null;
    }

    public boolean isValid(){
        if(srcFile != null){
            return srcFile.canRead();
        }

        return false;
    }

    protected void processArguments(int numberOfArguments){
        optionnal = arguments.getOptions();

        if(!arguments.isValid() || arguments.argumentSize() != numberOfArguments){
            return;
        }

        if(arguments.argumentSize() == 1)
            srcFile = new File(arguments.getArguments().get(0));
        if(arguments.argumentSize() == 2){
            srcFile = new File(arguments.getArguments().get(0));
            destFile = new File(arguments.getArguments().get(1));
        }
    }

    protected void options(){
        if(optionnal == null)
            return;
        if(optionnal.equals("-h")){
            System.out.println("Usage: <options> <src file> <dest file>");
            System.exit(0);
        }
    }

    public abstract boolean execute();


}
