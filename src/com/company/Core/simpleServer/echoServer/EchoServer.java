package com.company.Core.simpleServer.echoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception{
        System.out.println("Server Signing ON");

        ServerSocket ss  = new ServerSocket(9081);
        Socket soc = ss.accept();

        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                )
                ,true);

        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );

        String str = nis.readLine();
        while(!str.equals("End")){
            System.out.println("Server received "+ str);
            nos.println(str);
            str = nis.readLine();
        }
        nos.println("End");
        System.out.println("Server Signing OFF");
    }
}
