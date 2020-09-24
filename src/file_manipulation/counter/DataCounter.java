package file_manipulation.counter;

import java.io.*;

public abstract class DataCounter implements Countable{
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
        outputChar = NONE;
        file = null;
    }

    public DataCounter(File file) throws IOException{
        outputChar = NONE;
        this.file = new FileInputStream(file);
        this.size = this.file.available();
    }

    public void counter(char ch) throws IOException{
        this.outputChar = ch;
        counter();
    }
    public void counter(File file) throws IOException{
        this.file = new FileInputStream(file);
        counter();
    }

    public abstract void counter() throws IOException;


    public int getCounter(){
        return this.counter;
    }


    public int size(){
        return this.size;
    }

    public void close() throws IOException{
        try{
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new IOException(e.toString());
        }
    }
}
