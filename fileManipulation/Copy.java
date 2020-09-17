package fileManipulation;


import java.io.*;

public class Copy extends FileUtil{
    private final int NUMBER_ARGUMENTS = 2;
    public Copy(){
        super();
    }
    public Copy(Arguments arguments){
        this.arguments = arguments;
        super.processArguments(NUMBER_ARGUMENTS);
    }

    @Override
    public boolean isValid(){
        if(this.srcFile!= null){
            return this.srcFile.canRead();
        }
        if(this.destFile != null){
            if(!this.destFile.exists()){
                try{
                    return this.destFile.createNewFile();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return this.destFile.canWrite();
        }

        return false;
    }

    public boolean execute(){
        if(!this.isValid())
            return false;
        this.options();
        System.out.println(" Execute: " + this.srcFile.getName());
        int c;
        try(
            FileInputStream in = new FileInputStream(this.srcFile);
            FileOutputStream out = new FileOutputStream(this.destFile)
        )
        {
            System.out.println(srcFile.length() + " bytes");

            while((c = in.read()) != -1){
                System.out.print((char) c);
                out.write(c);
            }
            System.out.println();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
        
    }

}