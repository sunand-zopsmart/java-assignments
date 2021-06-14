package me.sunand.assignment1.core;

import java.io.File;


public class SystemInfo {
    //This class computes system level info at runtime.
    public static void main(String[] args) {
        // To fetch the name of the user
        String currentUser = System.getProperty("user.name");
        System.out.println("Name of the current user: " + currentUser);

        /*Creating the runtime object*/
        Runtime runtime = Runtime.getRuntime();

        //Details of the Memory space
        long totalSpace = runtime.totalMemory();
        long freeSpace = runtime.freeMemory();

        System.out.println("**** Sizes in Mega Bytes ****\n");

        System.out.println("Total memory space: " + totalSpace / (1024 * 1024) + " MB");
        System.out.println("Free memory space: " + freeSpace / (1024 * 1024) + " MB\n");


        //CPU Details

        System.out.println("Number of available processors in CPU: " + runtime.availableProcessors() + "\n");


        // Details of disk space
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root.getAbsolutePath() + " has total space of " + root.getTotalSpace() / (1024 * 1024) + " MB");
        }

        //Fetching the home directory
        String home_Directory = System.getProperty("user.home");
        System.out.println("Home directory is : " + home_Directory);

        //Fetching the OS name
        String osName = System.getProperty("os.name");
        System.out.println("Operating system Build =>" + osName);

        //Fetching the OS version
        String osVersion = System.getProperty("os.version");
        System.out.println("Operating system version =>" + osVersion);

    }
}