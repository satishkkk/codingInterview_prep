package com.PatkarSir_core.thread.WhatsappGroupDesign_upgrade2;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{

    public static MessageQueue<String> q = new MessageQueue<>();

    public static ArrayList<PrintWriter> noslist = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Server Signing ON");
        ServerSocket ss = new ServerSocket(8096); //created server socket to create socket object . .eventuallt for connecting to clients

        MessageDispatcher md = new MessageDispatcher(); // this thread will deque data from the message queue and send it to all the connected client
        md.setDaemon(true);
        md.start();

        for (int i = 0; i < 10; i++)
        {
            Socket soc = ss.accept(); //blocking call only accept connection and pass it to conversation thread
            System.out.println("Connection established");
            Conversation c = new Conversation(soc);
            c.start();
        }
        System.out.println("Server Signing OFF");
    }
}


