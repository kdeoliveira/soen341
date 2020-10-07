package datastream.transfer;

import java.io.File;
import java.io.IOException;

import filesystem.util.*;

public class Copy extends DataTransfer {

    public Copy(){
        super();
    }
    
    public Copy(File source, File destination) throws IOException{
        super(source, destination);
    }

    public void transfer(int ch) throws IOException{
        if(ch == EOF){
            Print.newline();
            Print.line("Copied successfully");
            return;
        }
        
        this.destination.write(ch);
        if(flagVerbose)         Print.character('.');
        
        this.fork();
    }
}
