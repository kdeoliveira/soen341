package file_manipulation.counter;

import java.io.*;

@FunctionalInterface
public interface Countable<K>{
    public void counter(K object) throws IOException;
}
