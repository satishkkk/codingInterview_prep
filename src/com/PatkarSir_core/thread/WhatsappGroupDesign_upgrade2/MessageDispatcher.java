package com.PatkarSir_core.thread.WhatsappGroupDesign_upgrade2;
import java.io.PrintWriter;

//this is deamon thread which will run until application is running . . .deque data from message queue and send it to all the connected clients
public class MessageDispatcher extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                String str = Server.q.dequeue(); // remove message from the queue fro processing
                for (PrintWriter o : Server.noslist) {
                    o.println(str); //send message to all the users
                }
            } catch (Exception e) {
            }
        }
    }
}