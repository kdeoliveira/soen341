import fileManipulation.*;

public class Demo {
    public static void main(String[] args){
        Arguments ar = new Arguments(args);

        System.out.println(ar.getOptions());
        System.out.println(ar.getArguments());

        Copy cp = new Copy(ar);
        charcount cc = new charcount(ar);
        linecount lc = new linecount(ar);
        wordcount wc = new wordcount(ar);

        cp.execute();

    }
}
