package com.PatkarSir_core.javaIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

    public static void main(String[] args) throws IOException {

        String filePath = "S:\\JAVA_Project\\codingInterview_prep\\src\\com\\company\\Core\\javaIO\\Output.txt";
        PrintWriter fos = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(filePath,true)
                ), true
        );
        fos.println("Writing to file");


    }


}
