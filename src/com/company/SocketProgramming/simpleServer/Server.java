package com.company.SocketProgramming.simpleServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)throws Exception{

        System.out.println("Server Signing ON");

        ServerSocket ss = new ServerSocket(9081);
        Socket soc = ss.accept();

        System.out.println("Server Says Connection Established");

        BufferedReader nis = new BufferedReader(
                new InputStreamReader(
                        soc.getInputStream()
                )
        );

        String str = nis.readLine();
        while(!str.equals("End")){
            System.out.println("Server Recieved " + str);
            str = nis.readLine();
        }
        System.out.println("Server Singing OFF");

    }



}
