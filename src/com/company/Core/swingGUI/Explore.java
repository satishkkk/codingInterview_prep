package com.company.Core.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Explore {


    public static void main(String[] args) {

        JFrame f1 = new JFrame("My GUI");
        f1.setSize(400, 400);
        f1.setLocation(300, 300);

        JButton b1 = new JButton("Send");

        JTextArea ta = new JTextArea(10, 10);
        f1.add(ta);
        ta.setEditable(false);

        JTextField tf = new JTextField(20);


        JPanel p1 = new JPanel();//placeholder for text field and button in south
        p1.add(tf);
        p1.add(b1);

        f1.add(p1, BorderLayout.SOUTH);
        f1.setVisible(true);// visible in ui
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close on clicking the x button on frame

        /*Inner class
         * event will be of type ActionEvent in event queue and if we want to handle event of type actionEvent and
         *if we want to write listener for that then that listner should implemnt Interface of ActionListner
         * */

        class L1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked \n");
                /*Read the data from text field
                 * Write the data to text area
                 * Claer the text field*/
                String str = tf.getText();
                if (!str.equals("")) {
                    ta.append(str + "\n");
                    tf.setText("");
                }
            }
        }

        L1 l1 = new L1();
        b1.addActionListener(l1);

    }

}

