package file_manipulation;

public class WC extends FileUtil{

    // public WC(Administrator args){
    //     super(args);
    // }

    // public int execute() throws IOException{
    //     if(!this.isValid())     return -1;

    //     try(DataCounter data = new MixCounter(srcPath)){
    //         this.execOptions();
    //         if(VERBOSE){
    //             data.counter('w', 'l', 'c');
    //             Print.newline();
    //         }
    //         else{
    //             data.counter();
    //         }
    //         Print.verboseMix((MixCounter) data, VERBOSE, srcPath);
    //     }
    //     catch(InvalidArgumentUtil e){
    //         e.printError();
    //     }
        
        

    //     return this.counter;
    // }

    // protected InvalidArgumentUtil throwInvalidArgument(){
    //     return new InvalidArgumentUtil("Invalid number of arguments", OPTIONS.HELP.usage(FILESOURCE));
    // }

}
