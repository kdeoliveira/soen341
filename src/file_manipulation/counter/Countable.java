package file_manipulation.counter;

import java.io.IOException;

@FunctionalInterface
public interface Countable {
    public void counter() throws IOException;
}
