package file_manipulation;

import java.util.*;

import file_manipulation.exception.InvalidArgumentUtil;

public class Arguments {
    private List<String> argsName;
    String optionnal = null;
    private int argsSize;


    public Arguments(String[] arg){
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

    public void exit(){
        System.exit(0);
    }
}
