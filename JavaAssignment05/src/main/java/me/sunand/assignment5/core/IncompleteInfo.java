package me.sunand.assignment5.core;

import java.io.File;
import java.util.Scanner;
/**
 * This class contains a method
 * The method checks the file has incomplete information of the git log
 */
public class IncompleteInfo {
     static boolean incompleteinfo(File f) throws Exception
    {
        boolean flag1=true;
        boolean flag2=true;
        boolean flag3=true;
        Scanner sc=new Scanner(f);
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            if(line.contains("commit"))
                flag1=false;
            if(line.contains("Author"))
                flag2=false;
            if(line.contains("Date"))
                flag3=false;
        }
        return (flag1||flag2||flag3);
    }
}
