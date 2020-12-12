package com.company.Core.thread.whatsappGroupDesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ConcurrentClient1 {

    public static void main(String[] args) throws Exception{

        Socket soc = new Socket("127.0.0.1",9082);

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
                ),true
        );

        JFrame f1 = new JFrame("Rpian Client");
        JButton b1 = new JButton("Send");
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        JTextField tf = new JTextField(20);
        JPanel p1 = new JPanel();
        p1.add(tf);
        p1.add(b1);
        f1.add(ta);
        f1.add(BorderLayout.SOUTH,p1);

        ChatListener l1 = new ChatListener(tf,nos);
        b1.addActionListener(l1);
        tf.addActionListener(l1);

        f1.setSize(400,400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String str = nis.readLine();
        System.out.println("Recived message from server"+str);
        String[] messageObject = str.split("id:");
        String message = messageObject[0];
        String user = messageObject[1];

        while(!message.equals("End")){
            ta.append(message + "\t\t" + user + "\n" );
            str = nis.readLine();
            messageObject = str.split("id:");
            message = messageObject[0];
            user = messageObject[1];
        }

        ta.append("Client Signing Off");
        Thread.sleep(1000);
        System.exit(0);
    }
}



class ChatListener implements ActionListener {

    JTextField tf ;
    PrintWriter nos;
    public ChatListener(JTextField tf,PrintWriter nos){
        this.tf = tf;
        this.nos = nos;
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        nos.println(str);
        tf.setText("");
    }

}
