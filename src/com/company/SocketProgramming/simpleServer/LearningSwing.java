package com.company.SocketProgramming.simpleServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class LearningSwing {
    public static void main(String[] args) throws Exception{

        Socket soc = new Socket("127.0.0.1",9081);

        PrintWriter nos = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                soc.getOutputStream()
                        )
                ),true
        );

        JFrame f1 = new JFrame("GUI Client");
        JButton b1 = new JButton("Ok");
        JTextArea ta = new JTextArea(10,10);
        ta.setEditable(false);

        JTextField tf = new JTextField(20);
        JPanel p1 = new JPanel();
        p1.add(tf);
        p1.add(b1);

        f1.add(p1, BorderLayout.SOUTH);
        f1.add(ta);
        f1.setSize(400,400);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        L1 l1 = new L1(tf,ta,nos);

        b1.addActionListener(l1);
        tf.addActionListener(l1);
    }

}

class L1 implements ActionListener {

    JTextField tf;
    JTextArea ta;
    PrintWriter nos;
    L1(JTextField tf, JTextArea ta,PrintWriter nos){
        this.tf = tf;
        this.ta = ta;
        this.nos = nos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str =  tf.getText();
        ta.append(str + "\n");
        tf.setText("");
        nos.println(str);
        if( str.equals("End")){
            System.exit(1);
        }
    }



}


