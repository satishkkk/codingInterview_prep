package com.PatkarSir_core.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {

    public static void main(String[] args) throws IOException {
        BufferedReader kin =new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter your name : ");
        String str = kin.readLine();
        System.out.println("WELCOME , "+ str);

        System.out.println("Enter Number 1 : ");
        String num1= kin.readLine();
        int n1= Integer.parseInt(num1);

        System.out.println("Enter Number 2 : ");
        String num2= kin.readLine();
        int n2= Integer.parseInt(num2);

        int sum = n1+n2;
        System.out.println("SUM IS "+ sum);

        System.out.println("Enter Float Number 1 : ");
        String num11= kin.readLine();
       float f1= Float.parseFloat(num11);

        System.out.println("Enter Number 2 : ");
        String num12= kin.readLine();
        float f2= Float.parseFloat(num12);

        float floatsum = f1+f2;
        System.out.println("Float SUM IS "+ floatsum);
    }
}
