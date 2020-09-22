import file_manipulation.*;


public class Demo_Char {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        CharCount cc = new CharCount(ar);

        cc.execute();
    }
}
