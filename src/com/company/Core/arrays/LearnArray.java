package com.company.Core.arrays;

public class LearnArray {

    public static void main(String args[]){



        //out.println(Math.sqrt(4));
        int dividend = 49;
        int divisor = 7;

        int remainder = dividend/divisor;

        int quotient = dividend%divisor;

        if(quotient ==0)
            System.out.println(remainder);
        else
            System.out.println(remainder + " , " + quotient + "/"+ divisor);
    }

}
