package datastream.counter;

import java.io.IOException;

@FunctionalInterface
public interface Countable {
    public void count(int ch) throws IOException;
}
