import file_manipulation.*;


public class Demo_Copy {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        Copy copy = new Copy(ar);

        copy.execute();
    }
}
