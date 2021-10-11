package com.PatkarSir_core.project;

import java.io.File;
import java.io.IOException;

public class batRunner {

    public static void main(String[] args) {

        System.out.println("Thread Name: "+ Thread.currentThread().getName());

        Thread t1 = new Thread(new Task("S:\\JAVA_Project\\Hello world\\src\\com\\project\\hello1.bat"));
        t1.start();

        Thread t2 = new Thread(new Task("S:\\JAVA_Project\\Hello world\\src\\com\\project\\hello2.bat"));
        t2.start();
    }


    static class Task implements Runnable{
        private final String batPath;

        public Task(String batPath){
            this.batPath=batPath;
        }

        public void run(){
            System.out.println("Thread Started:"+ Thread.currentThread().getName());
            ProcessBuilder processBuilder = new ProcessBuilder(batPath);
            processBuilder.directory(new File("S:\\JAVA_Project\\Hello world\\src\\com\\project"));
            File logFile = new File("S:\\JAVA_Project\\Hello world\\src\\com\\project\\log1.txt");
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(logFile));
            Process p = null;
            try {
                p = processBuilder.start();
                p.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done"+ Thread.currentThread().getName());
        }
    }

}
