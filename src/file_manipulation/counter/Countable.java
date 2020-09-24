package file_manipulation.counter;

import java.io.*;


public interface Countable extends AutoCloseable{
    public void counter(File file) throws IOException;
    public int getCounter();
}
