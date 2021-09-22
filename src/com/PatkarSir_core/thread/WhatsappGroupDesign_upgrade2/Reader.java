package com.PatkarSir_core.thread.WhatsappGroupDesign_upgrade2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader extends Thread {

    Socket soc;

    Reader(Socket soc) {
        this.soc = soc;
    }

    public void run() {
        try {
            BufferedReader nis = new BufferedReader(
                    new InputStreamReader(
                            soc.getInputStream()
                    )
            );

            String str = nis.readLine();
            while( !str.equals("End") )
            {
                System.out.println("Message from Server >> " +str );
                str = nis.readLine();
            }
        } catch (Exception e) {
        }
    }
}
