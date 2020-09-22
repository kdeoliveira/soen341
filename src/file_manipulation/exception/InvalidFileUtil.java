package file_manipulation.exception;


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
        System.out.println(this.toString());
        System.exit(-1);
    }
}