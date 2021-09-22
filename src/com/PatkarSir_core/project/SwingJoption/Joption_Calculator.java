package com.PatkarSir_core.project.SwingJoption;

import javax.swing.*;

public class Joption_Calculator {


    public static void main(String[] args) {

        String number1 = JOptionPane.showInputDialog(
                "Enter Number1"
        );

        String number2 = JOptionPane.showInputDialog(
                "Enter Number2"
        );

        String operation = JOptionPane.showInputDialog(
                "Enter 1 for Addition\n"+
                        "Enter 2 for Substraction\n"+
                        "Enter 3 for Multiplication\n"+
                        "Enter 4 for Division\n"
        );


        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int op = Integer.parseInt(operation);

        int result = 0;

        switch(op){

            case 1 : result = num1 + num2; break;
            case 2 : result = num1 - num2; break;
            case 3 : result = num1 * num2; break;
            case 4 : result = num1 / num2; break;

        }

        JOptionPane.showMessageDialog(
                null,
                "Result = " + result
        );
    }
}
