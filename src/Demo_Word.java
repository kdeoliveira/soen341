import file_manipulation.*;


public class Demo_Word {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        WordCount wc = new WordCount(ar);

        wc.execute();
    }
}
