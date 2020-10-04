package file_manipulation;

import java.io.File;
import java.io.IOException;
import file_manipulation.counter.*;

public class CounterFactory{
    private DataCounter data;
    private File file;

    public CounterFactory(){
    }
    public CounterFactory(File file) {
        this.file = file;
    }

    public SequenceCounter getSequenceCounter() throws IOException {
        if(this.file != null)
            return new SequenceCounter(this.file);
        else
            return new SequenceCounter();
    }

    public KeywordCounter getKeywordCounter() throws IOException {
        if(this.file != null)
            return new KeywordCounter(this.file);
        else
            return new KeywordCounter();        
    }

    public CharacterCounter getCharacterCounter() throws IOException {
        if(this.file != null)
            return new CharacterCounter(this.file);
        else
            return new CharacterCounter();
    }

    public DataCounter getDataCounter(){
        return this.data;
    }

    public void countLines() throws IOException{
        this.data = new SequenceCounter(this.file);
        this.data.counter();
    }

    public void countWords() throws IOException{
        this.data = new KeywordCounter(this.file);
        this.data.counter();
    }

    public void countCharacter() throws IOException{
        this.data = new CharacterCounter(this.file);
        this.data.counter();
    }

    public int[] getCounter(){
        return this.data.getCounter();
    }

    public void setFile(File file){
        this.file = file;
    }

}
