package com.company.Core.thread.WhatsappGroupDesign_upgrade2;

import java.io.*;
import java.net.Socket;

public class Conversation extends Thread {

    Socket soc;

    Conversation(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {
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

            Server.noslist.add(nos); //adding new clients to the arraylist of nos

            String str = nis.readLine(); // read message from the client BLOCKING CALL
            while (!str.equals("End")) {
                Server.q.enqueue(str); //enque message in the queue
                System.out.println("Server Received "+str);
                str = nis.readLine();
            }

            nos.println("End");
            Server.noslist.remove(nos); // removed client from nos array list

            System.out.println(
                    "Connection with "+
                            soc.getInetAddress().getHostAddress()+
                            " Terminated");
        } catch (Exception e) {
        }
    }
}