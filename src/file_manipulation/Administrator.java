package file_manipulation;

import java.util.*;

import file_manipulation.exception.InvalidArgumentUtil;

public class Administrator {
    private List<String> argsName;
    String optionnal = null;
    private int argsSize;
    private boolean VERBOSE;

    public Administrator(String[] arg){
        argsName = new ArrayList<>(Arrays.asList(arg));
        argsSize = argsName.size();
        this.options();
    }

    private void options(){
       if(!argsName.isEmpty() && argsName.get(0).startsWith("-")){
            optionnal = argsName.remove(0);
            argsSize--;
       }
    }

    public void execOptions(Class<?> clazz, String str) throws InvalidArgumentUtil{  
        if(optionnal == null)    
            return;
    
        if(OPTIONS.HELP.contains(optionnal))
            OPTIONS.HELP.printHelper(str);
        
        else if(OPTIONS.BANNER.contains(optionnal))
            OPTIONS.BANNER.printBanner(clazz.getName());

        else if(OPTIONS.VERBOSE.contains(optionnal))
            this.VERBOSE = true;
    
        else
            throw new InvalidArgumentUtil("Invalid operand", OPTIONS.HELP.usage(str));
    }

    public void execOptions(Class<?> clazz, String str, String str2) throws InvalidArgumentUtil{  
        if(optionnal == null)    
            return;
    
        if(OPTIONS.HELP.contains(optionnal))
            OPTIONS.HELP.printHelper(str, str2);
        
        else if(OPTIONS.BANNER.contains(optionnal))
            OPTIONS.BANNER.printBanner(clazz.getName());

        else if(OPTIONS.VERBOSE.contains(optionnal))
            this.VERBOSE = true;
    
        else
            throw new InvalidArgumentUtil("Invalid operand", OPTIONS.HELP.usage(str,str2));
    }

    public String getOptions(){
        return optionnal;
    }

    public List<String> getArguments(){
        return argsName;
    }

    public boolean isValid(int minSize, int maxSize) throws InvalidArgumentUtil{
        if(argsSize < minSize)
            throw new InvalidArgumentUtil("missing operand");

        return argsSize == maxSize;
    }

    public int argumentSize(){
        return argsSize;
    }

    public boolean getVerbose(){
        return this.VERBOSE;
    }

    public void exit(){
        System.exit(0);
    }
}
