package fileManipulation;
import java.util.*;

public class Arguments {
    private List<String> argsName;
    String optionnal;
    private int argsSize;

    public Arguments(String args[]){
        argsName = new ArrayList<>(Arrays.asList(args));
        argsSize = argsName.size();
        this.options();
    }

    private void options(){

        optionnal = argsName.stream().filter(
            x -> x.startsWith("-")
        ).findAny()
        .orElse(null);

        if(optionnal != null)
            argsName.remove(optionnal);
    }

    public String getOptions(){
        if(!this.isValid())
            return null;
        return optionnal;
    }

    public List<String> getArguments(){
        if(!this.isValid())
            return Collections.emptyList();

        return argsName;

    }

    public boolean isValid(){
        if(argsSize < 1)
            return false;

        if(argsSize > 2)
            return optionnal != null;

        return true;
    }
    
    public boolean isValid(int maxSize){
        if(argsSize < 1)
            return false;

        if(argsSize > maxSize)
            return optionnal != null;

        return true;
    }

    public int argumentSize(){
        return argsName.size();
    }
}
