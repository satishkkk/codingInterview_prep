package com.PatkarSir_core.thread.WhatsappGroupDesign_upgrade2;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Client Signing on");
        try {
            Socket soc = new Socket("127.0.0.1", 8096);

            /*to read data from server create thread*/
            Reader r = new Reader(soc);
            r.start();

            System.out.println("Client says connection established");

            PrintWriter nos = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(
                            soc.getOutputStream()
                    )
            ), true);

            BufferedReader kin = new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );

            //send message to server
            String messageToSent = kin.readLine();
            while (!messageToSent.equals("End")) {
                System.out.println("SENDING MESSAGE TO SERVER : " + messageToSent);
                nos.println(messageToSent);
                messageToSent = kin.readLine();
            }
            nos.println("End");

            System.out.println("Client Signing off");

        } catch (ConnectException e) {

        }
    }
}
