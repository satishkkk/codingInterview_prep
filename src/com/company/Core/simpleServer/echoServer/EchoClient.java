package com.company.Core.simpleServer.echoServer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        System.out.println("Client Signing ON");

        JFrame f1 = new JFrame("GUI Echo Client");

        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        JTextField tf = new JTextField(15);

        JButton b1 = new JButton("Send");

        JPanel p = new JPanel();
        p.add(tf);
        p.add(b1);

        f1.add(ta);
        f1.add(BorderLayout.SOUTH,p);
        f1.setSize(400,400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Socket soc = new Socket("127.0.0.1",9081);

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

        L1 l1 = new L1(ta,tf,nos);
        b1.addActionListener(l1);
//        tf.addActionListener(l1);

        String str = nis.readLine();
        while(!str.equals("End")){
            ta.append(str+"\n");
            System.out.println("Message recieved from server :"+str);
            str = nis.readLine();
        }
        ta.append("\nClient Signing Off\n");
    }
}



class L1 implements ActionListener {
    private JTextArea ta;
    private JTextField tf;
    private PrintWriter nos;

    public L1(JTextArea ta, JTextField tf, PrintWriter nos) {
        this.ta = ta;
        this.tf = tf;
        this.nos = nos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        nos.println(str);
        tf.setText("");
        if(str.equals("End")) {
            nos.close();
            System.exit(0);
        }
    }
}
