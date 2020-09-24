package file_manipulation;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.io.*;

public final class Print {
    private static PrintWriter output;
    public static final String ANSI_RESET;
    public static final String ANSI_RED;
    public static final String ANSI_YELLOW;
    public static final String ANSI_BLUE;
    static{
        output = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8), true);
        if(!System.getProperty("os.name").equals("windows")){
            ANSI_RESET = "\u001B[0m";
            ANSI_RED = "\u001B[31m";
            ANSI_YELLOW = "\u001B[33m";
            ANSI_BLUE = "\u001B[34m";
        }
        else{
            ANSI_RESET = "\0";
            ANSI_RED = "\0";
            ANSI_YELLOW = "\0";
            ANSI_BLUE = "\0";
        }
    }
    private Print(){
        throw new UnsupportedOperationException();
    }

    public static PrintWriter getOutput(){
        return output;
    }

    public static void verbose(final Object o,final boolean condition,final String str,final File sourceFile) {
        if(condition && str != null){
            output.printf(("File "+ANSI_YELLOW+"%s"+ANSI_RESET+" has been verified %n"),sourceFile.getName());
            output.printf(str, o.toString());
        }
        else
            output.print("Counter result: \u001B[33m"+o.toString()+"\u001B[0m");
        
        output.println();
        output.flush();
    }

    public static void line(final String str) {
        output.println(str);
        output.flush();
    }

    public static void line(final char ch) {
        output.println(ch);
        output.flush();
    }

    public static void character(final char ch) {
        output.print(ch);
        output.flush();
    }
    public static void newline(){
        output.println();
        output.flush();
    }
    public static void exit(final String str){
        output.println(str);
        System.exit(0);
    }

    public static void exit(final String str, final String str2){
        output.println(str);
        if(str2 != null)
            output.println(str2);
        System.exit(0);
    }

}
