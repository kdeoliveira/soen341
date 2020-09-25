package file_manipulation;

public class WordCount extends FileUtil{

    // public WordCount(Administrator arguments){
    //     super(arguments);
    // }

    // //Execute command
    //     public int execute() throws IOException{
    //     if(!this.isValid())     return -1;

    //     try(DataCounter data = new KeywordCounter(srcPath)){
    //         this.execOptions();
    //         data.counter();
    //         this.counter = data.getCounter();

    //         Print.verbose(data, VERBOSE, srcPath);
    //     }
    //     catch(InvalidArgumentUtil e){
    //         e.printError();
    //     }

    //     return this.counter;
    // }

    // //Static reference to class
    // public static WordCount wordcount(Administrator args){
    //     return new WordCount(args);
    // }
    // protected InvalidArgumentUtil throwInvalidArgument(){
    //     return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    // }
}
