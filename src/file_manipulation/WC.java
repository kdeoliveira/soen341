package file_manipulation;

public class WC{

    private Arguments arguments;

    public WC(){
        this.arguments = null;
    }

    public WC(Arguments args){
        this.arguments = args;
    }

    public int linecount(){
        return LineCount.linecount(arguments).execute();
    }
    public int charcount(){
        return CharCount.charcount(arguments).execute();
    }
    public int wordcount(){
        return WordCount.wordcount(arguments).execute();
    }

}
