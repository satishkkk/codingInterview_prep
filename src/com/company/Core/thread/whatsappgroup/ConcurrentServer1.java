package com.company.Core.thread.whatsappgroup;

import sun.plugin2.message.Conversation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConcurrentServer1 {

    public static ArrayList<PrintWriter> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Server signing On");
        ServerSocket ss = new ServerSocket(9081);

        for (int i = 0; i < 10; i++) {
            Socket soc = ss.accept();
            Conversation1 c = new Conversation1(soc);
            c.start();
        }
        System.out.println("Server signing Off");
    }
}

class Conversation1 extends Thread {

    Socket soc;

    public Conversation1(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {
        System.out.println("Conversation thread  "+
                Thread.currentThread().getName() +
                "   signing On"
        );

        try {

            BufferedReader nis = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );

            PrintWriter nos = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    soc.getOutputStream()
                            )
                    ), true
            );

            ConcurrentServer1.al.add(nos);

            String str = nis.readLine();
            while(!str.equals("End")){
                System.out.println("Server Recieved  "+str);
                for(PrintWriter o : ConcurrentServer1.al){
                    o.println(str);
                }
                str = nis.readLine();
            }
            nos.println("End");
        }

        catch(Exception e){
            System.out.println(
                    "Client Seems to have abruptly closed the connection"
            );
        }

        System.out.println("Conversation thread  "+
                Thread.currentThread().getName() +
                "   signing Off"
        );

    }

}