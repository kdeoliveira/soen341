import file_manipulation.*;


public class Demo_WC {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        WC wordcount = new WC(ar);

        wordcount.charcount();
        wordcount.linecount();
        wordcount.wordcount();

        
        



    }
}
