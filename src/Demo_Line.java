import file_manipulation.*;


public class Demo_Line {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        LineCount lc = new LineCount(ar);

        lc.execute();

    }
}
