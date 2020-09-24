package file_manipulation.counter;

import java.io.*;

public abstract class DataCounter implements Countable<File>, Closeable{
    protected static final int EOF = -1;
    protected static final char NONE = '\0';
    protected static final char SPACE = ' ';
    protected static final char NEWLINE = '\n';
    protected static final char RETURN = '\r';
    protected String VERBOSEMESSAGE = null;
    protected int counter = 0;
    protected char outputChar;
    FileInputStream file = null;

    public DataCounter(){
        outputChar = NONE;
    }

    public DataCounter(char character){
        outputChar = character;
    }

    public void counter(File file) throws IOException{
        this.file = new FileInputStream(file);
        count();
    }

    public void counter(File file, char ch) throws IOException{
        this.outputChar = ch;
        this.file = new FileInputStream(file);
        count();
    }

    protected abstract void count() throws IOException;


    public int getCounter(){
        return this.counter;
    }


    public void close() throws IOException{
            file.close();
    }

    public String getVerbose(){
        return VERBOSEMESSAGE;
    }
}
