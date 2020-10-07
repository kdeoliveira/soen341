package datastream.exception;

import datastream.Print;

public class InvalidFileUtil extends Exception{
    private static final long serialVersionUID = 1L;
    private final String message;

    public InvalidFileUtil(){
        super();
        message = "Input file is invalid or cannot be read";
    }

    public InvalidFileUtil(String str){
        super(str);
        message = str;
    }

    @Override
    public String toString(){
        return ("Error has occured: " + message);
    }

    public void printError(){
        Print.exit(this.toString());
    }
}