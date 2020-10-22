package com.project.SwingJoption;

import javax.swing.*;

public class JoptionTutorial_takestringInput {

    public static void main(String[] args) {


        String name = JOptionPane.showInputDialog(
                "Enter your Name"
        );

        String title = JOptionPane.showInputDialog(
                "Enter your title"
        );

        JOptionPane.showMessageDialog(
                null,
                "Welcome to Java " +
                        title +
                        " " +
                        name
        );
    }


}
