package file_manipulation.exception;

import file_manipulation.Print;

public class InvalidArgumentUtil extends Exception{
    private static final long serialVersionUID = 1L;
    private final String message;
    private final String arg;

    public InvalidArgumentUtil(){
        super();
        message = "Argument provided is invalid";
        arg = null;
    }

    public InvalidArgumentUtil(String str){
        super(str);
        message = str;
        arg = null;
    }

    public InvalidArgumentUtil(String str, String arg){
        super(str);
        message = str;
        this.arg = arg;
    }

    @Override
    public String toString(){
        return ("Error has occured: " + message);
    }

    public void printError(){
        Print.exit(this.message, this.arg);
    }





}
