package com.company.Core.thread.whatsapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("Server Signing ON");
        ServerSocket ss = new ServerSocket(9081);
        for(int i=0;i<10;i++){
            Socket soc = ss.accept();
            Conversation c = new Conversation(soc,i);
            System.out.println("Creating Thread: "+i);
            c.start();
        }
        System.out.println("Server Singing OFF");
    }
}


class Conversation extends Thread {
    Socket soc;
    int i;

    Conversation(Socket soc,int i) {
        this.soc = soc;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            BufferedReader nis = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );
            String str = nis.readLine();
            while (!str.equals("End")) {
                System.out.println("Server Recieved :" + str + " from client :" + i);
                str = nis.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}