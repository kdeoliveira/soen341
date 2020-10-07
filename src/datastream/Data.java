package datastream;

import java.io.*;

public abstract class Data implements Closeable {
    protected static final int EOF = -1;

    protected FileInputStream file;
    protected boolean flagVerbose;
    protected int[] counter;
    private int size;

    public Data() {
        this.file = null;
        this.flagVerbose = false;
        this.size = 0;
    }

    public Data(File file) throws IOException {
        this.file = new FileInputStream(file);
        this.size = this.file.available();
    }

    public void fork(boolean flag) throws IOException{
        this.flagVerbose = flag;
        this.fork();
    }

    protected abstract void fork() throws IOException;
    public abstract int[] getCounter();
    

    public int size(){
        return this.size;
    }

    public void setFile(File file) throws FileNotFoundException {
        this.file = new FileInputStream(file);
    }

    public void close() throws IOException{
        file.close();
    }
}
