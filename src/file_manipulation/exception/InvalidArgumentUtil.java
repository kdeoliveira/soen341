package file_manipulation.exception;

public class InvalidArgumentUtil extends Exception{
    private static final long serialVersionUID = 1L;
    private final String message;

    public InvalidArgumentUtil(){
        super();
        message = "Argument provided is invalid";
    }

    public InvalidArgumentUtil(String str){
        super(str);
        message = str;
    }

    @Override
    public String toString(){
        return ("Error has occured: " + message);
    }

    public void printError(){
        System.out.println(this.toString());
        System.exit(-1);
    }





}
