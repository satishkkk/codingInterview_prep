package com.company.Core.thread.whatsappGroupDesign;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConcurrentServer1 {

    public static ArrayList<PrintWriter> logedInUsers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Server signing On");
        ServerSocket ss = new ServerSocket(9082); //creating server  socket

        for (int i = 0; i < 10; i++) {
            Socket soc = ss.accept();//blocking call
            Conversation1 c = new Conversation1(soc,i);//creating thread
            c.start();
        }
        System.out.println("Server signing Off");
    }
}

class Conversation1 extends Thread {
    PrintWriter nos;
    Socket soc;
    int id;

    public Conversation1(Socket soc,int id) {
        this.soc = soc;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Conversation thread  "+ Thread.currentThread().getName() + "   signing On");

        try {
            BufferedReader nis = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );
            nos = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    soc.getOutputStream()
                            )
                    ), true
            );

            ConcurrentServer1.logedInUsers.add(nos); //registering each user in arraylist
            System.out.println("USERS IN SYSTEM"+ConcurrentServer1.logedInUsers);

            String message = nis.readLine(); // blocking call
            while(!message.equals("End")){
                System.out.println("Server Recieved Message : "+message+" from user : "+id);
                //sending recived msg to all the users
                for(PrintWriter user : ConcurrentServer1.logedInUsers){
                    user.println(message+"id:"+id);
                }
                message = nis.readLine();
            }
            nos.println("End");
        }

        catch(Exception e){
            System.out.println(
                    "Client Seems to have abruptly closed the connection"
            );
        }finally {
            System.out.println("Remove print writer object of client from the array list");
            ConcurrentServer1.logedInUsers.remove(nos);
        }

        System.out.println("Conversation thread  "+
                Thread.currentThread().getName() +
                "   signing Off"
        );

    }

}

