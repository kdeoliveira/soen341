package file_manipulation;


public class CharCount extends FileUtil{


    // public CharCount(Administrator arguments){
    //     super(arguments);
    // }

    // public int execute() throws IOException{
    //     if(!this.isValid())     return -1;

    //     try(DataCounter data = new CharacterCounter(srcPath)){
    //         this.execOptions();
    //         data.counter();
    //         this.counter = data.getCounter();

    //         Print.verbose(data , VERBOSE, srcPath);
    //     }
    //     catch(InvalidArgumentUtil e){
    //         e.printError();
    //     }

    //     return this.counter;
    // }

    // public static CharCount charcount(Administrator args){
    //     return new CharCount(args);
    // }

    // protected InvalidArgumentUtil throwInvalidArgument(){
    //     return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    // }
}
