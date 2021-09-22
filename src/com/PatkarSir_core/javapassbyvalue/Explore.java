package com.PatkarSir_core.javapassbyvalue;

/*
*
* The 2 variables x & y are of primitive types and they are stored inside the stack memory.
* When calling modifyPrimitiveTypes(), 2 copies are created inside the stack memory (let’s say w & z)
* and then passed to the method. Hence original variables are not being sent to the method and
* any modification inside the method flow is affecting only the copies.
*
* */
public class Explore {

    public static void main(String[] args) {

        int x = 1;
        int y = 2;

        System.out.print("Values of x & y before primitive modification: ");
        System.out.println(" x = " + x + " ; y = " + y );

        modifyPrimitiveTypes(x,y);

        System.out.print("Values of x & y after primitive modification: ");
        System.out.println(" x = " + x + " ; y = " + y );
    }


    private static void modifyPrimitiveTypes(int x, int y)
    {
        x = 5;
        y = 10;
    }
}
