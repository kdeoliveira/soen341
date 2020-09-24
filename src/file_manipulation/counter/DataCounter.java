package file_manipulation.counter;

import java.io.*;

public abstract class DataCounter implements AutoCloseable, Countable{
    protected static final int EOF = -1;
    protected static final char NONE = '\0';
    protected static final char SPACE = ' ';
    protected static final char NEWLINE = '\n';
    protected static final char RETURN = '\r';
    protected int counter = 0;
    private int size = 0;
    protected char outputChar;
    FileInputStream file;

    public DataCounter(){
        file = null;
        outputChar = NONE;
    }

    public DataCounter(File file) throws IOException{
        outputChar = NONE;
        this.file = new FileInputStream(file);
        this.size = this.file.available();
    }

    public void counter(char ch) throws IOException{
        this.outputChar = ch;
        count();
    }
    public void counter() throws IOException{
        this.outputChar = NONE;
        count();
    }

    protected abstract void count() throws IOException;

    public int getCounter(){
        return this.counter;
    }


    public int size(){
        return this.size;
    }

    public void close() throws IOException{
            file.close();
    }


}
