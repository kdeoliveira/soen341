package datastream.transfer;

import datastream.Data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class DataTransfer extends Data implements Transferable{
    private static final int NUMBER_ARGUMENT = 2;
    protected FileOutputStream destination;

    public DataTransfer(){
        super();
        this.destination = null;
        this.counter = new int[NUMBER_ARGUMENT];
    }
    
    public DataTransfer(File source, File destination) throws IOException{
        super(source);
        this.destination = new FileOutputStream(destination);
        this.counter = new int[NUMBER_ARGUMENT];
    }    

    public void fork() throws IOException{
        this.transfer(this.file.read());
    }

    public int[] getCounter(){
        try {
            return new int[] { this.file.available(), (int) this.destination.getChannel().size() };
        } catch (IOException e) {
            return new int[0];
        }
    }
}
