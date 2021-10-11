package com.PatkarSir_core.javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
    public static void main(String[] args) throws IOException {

        String filePath = "S:\\JAVA_Project\\codingInterview_prep\\src\\com\\company\\Core\\javaIO\\Output.txt";
        BufferedReader fis = new BufferedReader(new FileReader(filePath));

        List<String> out = new ArrayList<String>();

        String str3 = fis.readLine();
        while(str3!= null){
            out.add(str3);
            str3 = fis.readLine();
        }
        System.out.println("out = " + out);
    }
}
