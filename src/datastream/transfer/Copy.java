package datastream.transfer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import datastream.Data;
import filemanagement.util.*;

public class Copy extends Data implements Transferable {
    private static final int NUMBER_ARGUMENT = 2;
    private FileOutputStream destination;

    public Copy(){
        super();
        this.destination = null;
        this.counter = new int[1];
    }
    
    public Copy(File source, File destination) throws IOException{
        super(source);
        this.destination = new FileOutputStream(destination);
        this.counter = new int[1];
    }

    public void fork() throws IOException{
        this.transfer(this.file.read());
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

    public int[] getCounter(){
        try {
            return new int[] { this.file.available(), (int) this.destination.getChannel().size() };
        } catch (IOException e) {
            return new int[0];
        }
    }

    public static int getNumberArguments(){
        return NUMBER_ARGUMENT;
    }
}
