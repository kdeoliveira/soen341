package filemanagement.util;

//Provides options values and methods for command line
public enum OPTIONS{
    HELP("-h", "-?", "-help"), VERBOSE("-v", "-verbose"), BANNER("-b", "-banner");

    private final String opt1;
    private final String opt2;
    private final String opt3;


    OPTIONS(String opt1){
        this.opt1 = opt1;
        this.opt2 = null;
        this.opt3 = null;
    }
    OPTIONS(String opt1, String opt2){
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = null;
    }
    OPTIONS(String opt1, String opt2, String opt3){
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
    }

    //Verify if string contains a specific option
    public boolean contains(String str){
        try{
            return this.opt1.equals(str) || this.opt2.equals(str) || this.opt3.equals(str);
        }
        //Verifies if str is null
        catch(NullPointerException npe){
            return false;
        }
    }

    public String getOpt1(){
        return this.opt1;
    }
    //Return help output given a string
    public String usage(String str){
        return String.format("usage: [%s] [%s] [%s] <%s>", HELP.opt1, VERBOSE.opt1, BANNER.opt1, str );
    }
    //Return help output given two string
    public String usage(String str1, String str2){
        return String.format("usage: [%s] [%s] [%s] <%s> <%s>", this.opt1, this.opt2, this.opt3, str1, str2 );
    }
    //Return banner output given a string
    public String banner(String str){
        return String.format("%s Version 1.0 \n"+
                            "Copyright (C) Concordia 2020. All Rights Reserved\n"+
                            "Written by Kevin de Oliveira",
                            str
                            );
    }

    public void printHelper(String str){
        Print.exit(usage(str));
    }

    public void printHelper(String str, String str2){
        Print.exit(usage(str, str2));
    }

    public void printBanner(String str){
        Print.exit(banner(str));
    }

}